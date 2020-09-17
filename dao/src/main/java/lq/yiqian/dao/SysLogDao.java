package lq.yiqian.dao;

import lq.yiqian.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LQ
 * @create 2020-06-10 12:04
 */

/**
 * 操作日志
 */
public interface SysLogDao {
    /**
     * 新增日志
     *
     * @param sysLog
     */
    @Insert("insert into sysLog(visitTime, ip, executionTime, uri, browser, operatingSystem )" +
            " values(#{visitTime}, #{ip},  #{executionTime}, #{uri}, #{browser}, #{operatingSystem})")
    void save(SysLog sysLog);

    /**
     * 根据uri查询
     *
     * @param s
     * @return
     */
    @Select("select id, visitTime, ip, uri, executionTime, browser, operatingSystem from sysLog " +
            "where  uri like #{s} order by visitTime desc ")
    List<SysLog> findByMethod(String s);
}
