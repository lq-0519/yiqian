package lq.yiqian.controller;

import com.github.pagehelper.PageInfo;
import lq.yiqian.domain.SearchHistory;
import lq.yiqian.domain.TopSearch;
import lq.yiqian.service.ISearchHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 查询记录
 *
 * @author LQ
 * @create 2020-06-25 17:57
 */
@Controller
@RequestMapping("/searchHistory")
public class SearchHistoryController {
    @Resource
    private ISearchHistoryService searchHistoryService;

    /**
     * 展示查询记录
     * <p>
     * 使用分页
     */
    @RequestMapping("/showSearchHistory")
    public ModelAndView showSearchHistory(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        ModelAndView modelAndView = new ModelAndView();
        // 查询今天的搜索记录数
        int todayTotal = searchHistoryService.findTodayTotal();
        // 查询昨天的搜索记录数
        int yesterdayTotal = searchHistoryService.findYesterdayTotal();
        // 查询出搜索记录
        List<SearchHistory> searchHistories = searchHistoryService.findAllByPage(page, 40);
        PageInfo<SearchHistory> pageInfo = new PageInfo<>(searchHistories);
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
     */
    @RequestMapping("/showTopSearch")
    public ModelAndView showTopSearch(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        ModelAndView modelAndView = new ModelAndView();
        // 查询出搜索记录
        List<TopSearch> topSearches = searchHistoryService.findTopSearch(page, 20);
        PageInfo<TopSearch> pageInfo = new PageInfo<>(topSearches);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("pages/topSearch");
        return modelAndView;
    }
}
