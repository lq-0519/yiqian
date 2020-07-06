package lq.yiqian.dao;

import lq.yiqian.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author LQ
 * @create 2020-07-04 19:30
 */

/**
 * 用户
 */
public interface UserDao {
    /**
     * 根据用户名和密码查询
     *
     * @param username
     * @param password
     * @return
     */
    @Select("select username, password from user " +
            " where username = #{username} and password = #{password}")
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
