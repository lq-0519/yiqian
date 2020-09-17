package lq.yiqian.service.impl;

import com.github.pagehelper.PageHelper;
import lq.yiqian.dao.SearchHistoryDao;
import lq.yiqian.domain.SearchHistory;
import lq.yiqian.domain.TopSearch;
import lq.yiqian.service.ISearchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author LQ
 * @create 2020-06-24 17:51
 */
@Service
@Transactional
public class SearchHistoryService implements ISearchHistoryService {
    @Autowired
    private SearchHistoryDao searchHistoryDao;

    /**
     * 查询今天的搜索记录数
     *
     * @return
     */
    @Override
    public int findTodayTotal() {
        int todayTotal = searchHistoryDao.findTodayTotal();
        return todayTotal;
    }

    /**
     * 查询昨天的搜索记录数
     *
     * @return
     */
    @Override
    public int findYesterdayTotal() {
        int yesterdayTotal = searchHistoryDao.findYesterdayTotal();
        return yesterdayTotal;
    }

    /**
     * 使用分页查询所有
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<SearchHistory> findAllByPage(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return searchHistoryDao.findAll();
    }

    /**
     * 产生新的搜索记录
     *
     * @param searchHistory
     */
    @Override
    public void save(SearchHistory searchHistory) {
        searchHistoryDao.save(searchHistory);
    }

    /**
     * 查询书库热搜
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<TopSearch> findTopSearch(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<TopSearch> topSearch = searchHistoryDao.findTopSearch();
        return topSearch;
    }
}
