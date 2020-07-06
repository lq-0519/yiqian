package lq.yiqian.service;

import lq.yiqian.domain.SysLog;

import java.util.List;

/**
 * @author LQ
 * @create 2020-06-10 11:59
 */
public interface ISysLogService {
    void save(SysLog sysLog);


    List<SysLog> findByMethod(String condition, Integer page, Integer size);
}
