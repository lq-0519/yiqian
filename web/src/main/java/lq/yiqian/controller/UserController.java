package lq.yiqian.controller;

import lq.yiqian.domain.User;
import lq.yiqian.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author LQ
 * @create 2020-07-04 19:29
 */

/**
 * 用户
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * 用户登录
     * <p>
     * 登陆成功就跳转到后台的首页
     * 登陆失败让重新登陆
     *
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public String login(@RequestParam(name = "username") String username,
                        @RequestParam(name = "password") String password,
                        HttpSession session) {
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        User user1 = userService.login(user);
        if (user1 != null) {
            //用户名密码正确
            session.setAttribute("user", user1);
            return "redirect:/regiBook/findByUntreated";
        } else {
            //用户名密码错误
            session.setAttribute("loginErrorMsg", "登陆失败!");
            return "redirect:/login.jsp";
        }
    }

    /**
     * 判断用户是否已经登陆
     * <p>
     * 用户登录了就跳转到后台的首页
     * 没登录就跳转到登陆
     *
     * @param session
     * @return
     */
    @RequestMapping("/isLogin")
    public String isLogin(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            //登陆了
            return "redirect:/regiBook/findByUntreated";
        } else {
            //没登录呢
            return "redirect:/login.jsp";
        }
    }

    /**
     * 用户退出登录
     * <p>
     * 直接删除session中的user属性即可
     *
     * @param session
     * @return
     */
    @RequestMapping("/loggedOut")
    public String loggedOut(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/index.jsp";
    }
}
