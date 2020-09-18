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
     *
     * @param bookName
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<Book> findByBookName(String bookName, int page, int size) {
        PageHelper.startPage(page, size);//设置分页的条件
        return bookListDao.findByBookName("%" + bookName + "%");
    }

    /**
     * 添加新书
     *
     * @param bookName
     * @param path
     */
    @Override
    public void save(String bookName, String path) {
        bookListDao.save(bookName, path);
    }

    /**
     * 更新Redis缓存
     */
    @Override
    public void updateRedis() {
        Jedis jedis = JedisPoolUtils.getJedis();
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
            // 查询数据库
            List<Book> books = findByBookName(split[0], Integer.parseInt(split[1]), 20);
            // 封装为pageInfo
            PageInfo pageInfo = new PageInfo(books);
            // 解析为JSON, 放进Redis中
            jedis.set(key, JSON.toJSONString(pageInfo));
        }
        jedis.close();
    }
}
