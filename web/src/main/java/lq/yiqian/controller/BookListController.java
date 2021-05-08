package lq.yiqian.controller;

import com.github.pagehelper.PageInfo;
import lq.yiqian.domain.SearchHistory;
import lq.yiqian.service.IBookListService;
import lq.yiqian.service.ISearchHistoryService;
import lq.yiqian.service.IVariableService;
import lq.yiqian.utils.IpUtils;
import lq.yiqian.utils.es.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

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
    @Resource
    private IBookListService bookListService;
    @Resource
    private ISearchHistoryService searchHistoryService;
    @Resource
    private ServletContext servletContext;
    @Resource
    private IVariableService variableService;

    /**
     * 根据书名查询书单
     * <p>
     * 查询到了就返回查询出来的数据, 没查询到就返回到空的那个jsp页面
     * 查询的同时需要记录下来查询的结果
     */
    @RequestMapping("/findByBookName")
    public ModelAndView findByBookName(HttpServletRequest request,
                                       @RequestParam(name = "bookName") String bookName,
                                       @RequestParam(name = "page", defaultValue = "1") Integer page,
                                       @RequestParam(name = "isSave", defaultValue = "1") Integer isSave) {
        ModelAndView modelAndView = new ModelAndView();
        if (StringUtils.isEmpty(bookName)) {
            //传过来的值不合法, 直接返回即可
            modelAndView.setViewName("index");
            return modelAndView;
        }
        // 默认一页13条数据
        PageInfo<Book> pageInfo = bookListService.findByBookName(bookName, page, 13);
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
        searchRecord(request, bookName, isSave, (int) total);
        return modelAndView;
    }


    private void searchRecord(HttpServletRequest request, String bookName, Integer isSave, int total) {
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
            searchHistory.setResult(total);
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
    }
}
