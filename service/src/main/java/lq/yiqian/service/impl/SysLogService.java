package lq.yiqian.service.impl;

import com.github.pagehelper.PageHelper;
import lq.yiqian.dao.SysLogDao;
import lq.yiqian.domain.SysLog;
import lq.yiqian.service.ISysLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
    @Resource
    private SysLogDao sysLogDao;

    /**
     * 新增日志
     */
    @Override
    public void save(SysLog sysLog) {
        sysLogDao.save(sysLog);
    }

    /**
     * 根据uri查询
     */
    @Override
    public List<SysLog> findByUri(String condition, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return sysLogDao.findByMethod("%" + condition + "%");
    }
}
