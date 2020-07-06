package lq.yiqian.dao;

import lq.yiqian.domain.SearchHistory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LQ
 * @create 2020-06-24 17:48
 */
public interface SearchHistoryDao {
    /**
     * 查询所有
     * <p>
     * 按照时间倒序
     *
     * @return
     */
    @Select("select ip, searchTime, bookName, result, id from searchHistory order by searchTime desc")
    public List<SearchHistory> findAll();

    /**
     * 查询今天的搜索记录数
     *
     * @return
     */
    @Select("select count(id) from searchHistory where to_days(searchTime) = to_days(now())")
    int findTodayTotal();

    /**
     * 查询昨天的搜索记录数
     *
     * @return
     */
    @Select("SELECT count(id) FROM searchHistory where to_days(NOW()) - to_days(searchTime) = 1 ")
    int findYesterdayTotal();

    /**
     * 添加新的查询记录
     *
     * @param searchHistory
     */
    @Insert("insert into searchHistory(ip, searchTime, bookName, result) " +
            " values(#{ip},#{searchTime},#{bookName},#{result})")
    void save(SearchHistory searchHistory);
}
