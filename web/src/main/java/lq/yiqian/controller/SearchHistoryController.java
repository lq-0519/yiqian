package lq.yiqian.controller;

import com.github.pagehelper.PageInfo;
import lq.yiqian.domain.SearchHistory;
import lq.yiqian.domain.TopSearch;
import lq.yiqian.service.ISearchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author LQ
 * @create 2020-06-25 17:57
 */

/**
 * 查询记录
 */
@Controller
@RequestMapping("/searchHistory")
public class SearchHistoryController {
    @Autowired
    private ISearchHistoryService searchHistoryService;

    /**
     * 展示查询记录
     * <p>
     * 使用分页
     *
     * @param page
     * @return
     */
    @RequestMapping("/showSearchHistory")
    public ModelAndView showSearchHistory(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        ModelAndView modelAndView = new ModelAndView();
        int todayTotal = searchHistoryService.findTodayTotal();// 查询今天的搜索记录数
        int yesterdayTotal = searchHistoryService.findYesterdayTotal();// 查询昨天的搜索记录数
        List<SearchHistory> searchHistories = searchHistoryService.findAllByPage(page, 40);// 查询出搜索记录
        PageInfo pageInfo = new PageInfo(searchHistories);
        modelAndView.addObject("todayTotal", todayTotal);
        modelAndView.addObject("yesterdayTotal", yesterdayTotal);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("pages/admin/searchHistory");
        return modelAndView;
    }

    /**
     * 展示书库热搜
     * <p>
     * 使用分页
     *
     * @param page
     * @return
     */
    @RequestMapping("/showTopSearch")
    public ModelAndView showTopSearch(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        ModelAndView modelAndView = new ModelAndView();
        List<TopSearch> topSearches = searchHistoryService.findTopSearch(page, 20);// 查询出搜索记录
        PageInfo pageInfo = new PageInfo(topSearches);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("pages/topSearch");
        return modelAndView;
    }
}
