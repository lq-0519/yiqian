package lq.yiqian.service.impl;

import lq.yiqian.dao.UserDao;
import lq.yiqian.domain.User;
import lq.yiqian.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author LQ
 * @create 2020-07-04 19:30
 */

/**
 * 用户
 */
@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    private UserDao userDao;

    /**
     * 用户登录
     * <p>
     * 检验用户名和密码是否正确
     */
    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
