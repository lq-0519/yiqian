package lq.yiqian.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lq.yiqian.dao.BookListDao;
import lq.yiqian.domain.Book;
import lq.yiqian.service.IBookListService;
import lq.yiqian.utils.JedisPoolUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import java.util.List;

/**
 * @author LQ
 * @create 2020-06-24 15:57
 */

/**
 * 查询书单的service层
 */
@Service
@Transactional
public class BookListService implements IBookListService {
    @Autowired
    private BookListDao bookListDao;

    public List<Book> findAll() {
        return bookListDao.findAll();
    }

    /**
     * 根据书名查询书单
     */
    @Override
    public List<Book> findByBookName(String bookName, int page, int size) {
        PageHelper.startPage(page, size);//设置分页的条件
        return bookListDao.findByBookName("%" + bookName + "%");
    }

    /**
     * 添加新书
     */
    @Override
    public void save(String bookName, String path) {
        bookListDao.save(bookName, path);
    }

    /**
     * 更新Redis缓存
     *
     * @param appendBookName 新插入的书名
     */
    @Override
    public void updateRedis(String appendBookName) {
        Jedis jedis = JedisPoolUtils.getJedis();
        // 参数合法性检验
        if (appendBookName != null && appendBookName.length() != 0 && !("null".equals(appendBookName))) {
            // 获取Redis中所有的key, 使用模式: '*---*'
            ScanParams scanParams = new ScanParams();
            scanParams.count(500);
            scanParams.match("*---*");
            ScanResult<String> scanResult = jedis.scan("0", scanParams);
            // 遍历所有的key
            List<String> keys = scanResult.getResult();
            for (String key : keys) {
                // 解析key为bookName+page
                String[] split = key.split("---");
                String bookName = split[0];
                String page = split[1];
                // 判断最近插入的书名是否包含这个key
                if (appendBookName.contains(bookName)) {
                    // 包含, 更新这个键值对
                    // 查询数据库
                    List<Book> books = findByBookName(bookName, Integer.parseInt(page), 13);
                    // 封装为pageInfo
                    PageInfo pageInfo = new PageInfo(books);
                    // 解析为JSON, 放进Redis中
                    jedis.set(key, JSON.toJSONString(pageInfo));
                }
            }
        }
        jedis.close();
    }

    /**
     * 将新插入的书名添加到Redis中
     */
    @Override
    @Deprecated
    public void saveBookNameToRedis(String bookName) {
        Jedis jedis = JedisPoolUtils.getJedis();
        // 先从Redis中查询出来
        String value = jedis.get("appendBookName");
        // 将书名拼接到后面
        value += bookName + "-";
        // 再将键值对重新设置回Redis
        jedis.set("appendBookName", value);
        jedis.expire("appendBookName", 3600 * 8);// 设置8个小时的存活时间
        jedis.close();
    }
}
