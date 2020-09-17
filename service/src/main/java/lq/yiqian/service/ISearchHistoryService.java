package lq.yiqian.service;

import lq.yiqian.domain.SearchHistory;
import lq.yiqian.domain.TopSearch;

import java.util.List;

/**
 * @author LQ
 * @create 2020-06-24 17:51
 */
public interface ISearchHistoryService {
    int findTodayTotal();

    int findYesterdayTotal();

    List<SearchHistory> findAllByPage(Integer page, Integer i);

    void save(SearchHistory searchHistory);

    List<TopSearch> findTopSearch(Integer page, Integer size);
}
