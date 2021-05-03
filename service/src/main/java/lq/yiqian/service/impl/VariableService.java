package lq.yiqian.service.impl;

import lq.yiqian.dao.VariableDao;
import lq.yiqian.domain.Variable;
import lq.yiqian.service.IVariableService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LQ
 * @create 2020-07-04 12:06
 */
@Service("variableService")
@Transactional
public class VariableService implements IVariableService {
    @Resource
    private VariableDao variableDao;

    /**
     * 查询所有
     */
    @Override
    public List<Variable> findAll() {
        return variableDao.findAll();
    }

    /**
     * 根据键更新值
     */
    @Override
    public void updateByName_value(String name, String value) {
        variableDao.updateByName_value(name, value);
    }

    /**
     * 更新页脚信息
     */
    @Override
    public void updateFooterInfo(String qqGroup, String adminQQ) {
        variableDao.updateByName_value("qqGroup", qqGroup);
        variableDao.updateByName_value("adminQQ", adminQQ);
    }

    /**
     * 更新搜索次数
     */
    @Override
    public void updateSearchTotal(String searchTotal, String value) {
        variableDao.updateByName_value(searchTotal, value);
    }
}
