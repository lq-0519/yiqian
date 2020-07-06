package lq.yiqian.service.impl;

import com.github.pagehelper.PageHelper;
import lq.yiqian.dao.SysLogDao;
import lq.yiqian.domain.SysLog;
import lq.yiqian.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author LQ
 * @create 2020-06-10 11:59
 */

/**
 * 操作日志
 */
@Service
@Transactional
public class SysLogService implements ISysLogService {
    @Autowired
    private SysLogDao sysLogDao;

    /**
     * 新增日志
     *
     * @param sysLog
     */
    @Override
    public void save(SysLog sysLog) {
        sysLogDao.save(sysLog);
    }

    /**
     * 根据方法名查询
     *
     * @param condition
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<SysLog> findByMethod(String condition, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return sysLogDao.findByMethod("%" + condition + "%");
    }
}
