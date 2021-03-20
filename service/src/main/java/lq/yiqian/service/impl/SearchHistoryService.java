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
     */
    @Override
    public int findTodayTotal() {
        return searchHistoryDao.findTodayTotal();
    }

    /**
     * 查询昨天的搜索记录数
     */
    @Override
    public int findYesterdayTotal() {
        return searchHistoryDao.findYesterdayTotal();
    }

    /**
     * 使用分页查询所有
     */
    @Override
    public List<SearchHistory> findAllByPage(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return searchHistoryDao.findAll();
    }

    /**
     * 产生新的搜索记录
     */
    @Override
    public void save(SearchHistory searchHistory) {
        searchHistoryDao.save(searchHistory);
    }

    /**
     * 查询书库热搜
     */
    @Override
    public List<TopSearch> findTopSearch(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return searchHistoryDao.findTopSearch();
    }
}
