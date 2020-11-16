package lq.yiqian.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import lq.yiqian.domain.Book;
import lq.yiqian.domain.SearchHistory;
import lq.yiqian.service.IBookListService;
import lq.yiqian.service.ISearchHistoryService;
import lq.yiqian.service.IVariableService;
import lq.yiqian.utils.IpUtils;
import lq.yiqian.utils.JedisPoolUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author LQ
 * @create 2020-06-24 16:02
 */

/**
 * 书单
 */
@Controller
@RequestMapping("/book")
public class BookListController {
    @Autowired
    private IBookListService bookListService;
    @Autowired
    private ISearchHistoryService searchHistoryService;
    @Autowired
    private ServletContext servletContext;
    @Autowired
    private IVariableService variableService;

    /**
     * 根据书名查询书单
     * <p>
     * 查询到了就返回查询出来的数据, 没查询到就返回到空的那个jsp页面
     * 查询的同时需要记录下来查询的结果
     *
     * @param request
     * @param bookName
     * @param page
     * @param isSave
     * @return
     */
    @RequestMapping("/findByBookName")
    public ModelAndView findByBookName(HttpServletRequest request,
                                       @RequestParam(name = "bookName") String bookName,
                                       @RequestParam(name = "page", defaultValue = "1") Integer page,
                                       @RequestParam(name = "isSave", defaultValue = "1") Integer isSave) {
        ModelAndView modelAndView = new ModelAndView();
        if (bookName == null || bookName.length() == 0) {
            //传过来的值不合法, 直接返回即可
            modelAndView.setViewName("index");
            return modelAndView;
        }
        Jedis jedis = JedisPoolUtils.getJedis();
        // 先查Redis
        String key = bookName + "---" + page; // key的格式: bookName---page
        String value = jedis.get(key);
        PageInfo pageInfo = null;
        if (value == null || value.length() == 0) {
            // 没查到
            // 查询数据库, 序列化数据存入Redis, 返回数据
            // 默认一页13条数据
            List<Book> books = bookListService.findByBookName(bookName, page, 13);
            pageInfo = new PageInfo(books);
            value = JSON.toJSONString(pageInfo);
            jedis.set(key, value);
            System.out.println("Redis没命中");
        } else {
            // 查到了, 序列化数据, 返回
            pageInfo = JSON.parseObject(value, PageInfo.class);
            System.out.println("Redis命中");
        }
        jedis.close();
        //获取查询到的结果数
        long total = pageInfo.getTotal();
        modelAndView.addObject("bookName", bookName);
        if (total != 0) {
            //结果总数不为0, 代表查到了
            modelAndView.addObject("pageInfo", pageInfo);
            modelAndView.setViewName("pages/searchResult");
        } else {
            //使用书名没有查到数据, 接跳转到结果为空的界面
            modelAndView.setViewName("pages/resultEmpty");
        }
        // 记录搜索
        if (isSave == 1) {
            String searchTotalStr = (String) servletContext.getAttribute("searchTotal");
            Integer searchTotal = Integer.parseInt(searchTotalStr);
            // 获取IP地址
            String ip = IpUtils.getIp(request);
            // 获取时间
            Date searchDate = new Date();
            SearchHistory searchHistory = new SearchHistory();
            searchHistory.setIp(ip);
            searchHistory.setBookName(bookName);
            searchHistory.setResult((int) total);
            searchHistory.setSearchTime(searchDate);
            searchHistoryService.save(searchHistory);
            // 更新搜索次数
            // 搜索次数+1
            searchTotal++;
            // 更新ServletContext里面的值
            servletContext.setAttribute("searchTotal", searchTotal + "");
            // 更新数据库
            variableService.updateSearchTotal("searchTotal", "" + searchTotal);// 更新数据库
        }
        return modelAndView;
    }

    /**
     * 更新Redis缓存
     *
     * @return
     */
    @RequestMapping("/updateRedis")
    public String updateRedis() {
        bookListService.updateRedis();
        return "redirect:/regiBook/findByUntreated";
    }
}
