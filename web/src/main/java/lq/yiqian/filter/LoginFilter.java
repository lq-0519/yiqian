package lq.yiqian.filter;

import lq.yiqian.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author LQ
 * @create 2020-07-04 18:46
 */

/**
 * 用户登录
 */
@WebFilter({"/pages/admin/*",
        "/invitationCode/*",
        "/regiBook/findByUntreated",
        "/regiBook/findById",
        "/regiBook/updateById_bookName_author",
        "/regiBook/updateResult",
        "/regiBook/findByIsFundAdmin",
        "/regiBook/delById",
        "/searchHistory/showSearchHistory",
        "/sysLog/*",
        "/variable/updateNotice",
        "/variable/updateFooterInfo",
})
public class LoginFilter implements javax.servlet.Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response1 = (HttpServletResponse) response;// 强转为可用的response对象, 因为之前的response对象包含的方法太少了
        HttpServletRequest request1 = (HttpServletRequest) request;// 强转为可用的request对象, 因为之前的request对象包含的方法太少了
        HttpSession session = request1.getSession();// 获取session
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 未登录
            response1.sendRedirect("/login.jsp");
        } else {
            // 已登录
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}




