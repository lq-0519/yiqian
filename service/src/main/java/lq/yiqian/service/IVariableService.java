package lq.yiqian.service;

import lq.yiqian.domain.Variable;

import java.util.List;

/**
 * @author LQ
 * @create 2020-07-04 12:06
 */
public interface IVariableService {
    List<Variable> findAll();

    void updateByName_value(String name, String value);

    void updateFooterInfo(String qqGroup, String adminQQ);

    void updateSearchTotal(String searchTotal, String value);

}
