package lq.yiqian.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author LQ
 * @create 2020-07-04 18:20
 */

/**
 * 页面出错的过滤器
 * <p>
 * 需要拦截所有的资源
 * 页面出错了就跳转到指定页面
 */
@WebFilter({"/*"})
public class ExceptionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {// 捕获错误
            chain.doFilter(request, response);
        } catch (Exception e) {
            // 存储错误信息
            request.setAttribute("errorMsg", e.getMessage());
            // 跳转到错误界面
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
