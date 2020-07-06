package lq.yiqian.dao;

import lq.yiqian.domain.Variable;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author LQ
 * @create 2020-07-04 12:07
 */
public interface VariableDao {
    /**
     * 查询所有
     *
     * @return
     */
    @Select("select id, name, value from variable ")
    List<Variable> findAll();

    /**
     * 更新数据
     *
     * @param name
     * @param value
     */
    @Update("update variable set value=#{value} where name = #{name}")
    void updateByName_value(@Param("name") String name, @Param("value") String value);
}
