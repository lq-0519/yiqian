package lq.yiqian.controller;

import eu.bitwalker.useragentutils.UserAgent;
import lq.yiqian.domain.SysLog;
import lq.yiqian.service.ISysLogService;
import lq.yiqian.utils.IpUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author LQ
 * @create 2020-06-09 20:08
 */

/**
 * 记录用户操作
 */
@Component
@Aspect
public class LogAop {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ISysLogService sysLogService;

    private Date visitTime; //开始时间
    private Class aClass; //访问的类

    /**
     * 前置通知
     * <p>
     * 主要获取开始时间 执行的类 执行的方法
     *
     * @param joinPoint
     */
    @Before("execution(* lq.yiqian.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        aClass = joinPoint.getTarget().getClass();//访问的类
        if (aClass != LogAop.class && aClass != SysLogController.class) {
            //如果执行的是LogAop类就直接跳过就行
            visitTime = new Date();//开始时间
        }
    }

    /**
     * 后置通知
     * <p>
     * 获取访问的ip
     * 获取访问的时长
     *
     * @param joinPoint
     */
    @After("execution(* lq.yiqian.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint) {
        if (aClass != null && aClass != LogAop.class && aClass != SysLogController.class) {
//            String s = request.getRequestURL().toString();
            //获取访问的时长
            long time = new Date().getTime() - visitTime.getTime();
            //获取访问的ip地址
            String ip = IpUtils.getIp(request);
            // 获取访问者的浏览器
            UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
            String browser = userAgent.getBrowser().toString();
            // 获取访问者的操作系统
            String operatingSystem = userAgent.getOperatingSystem().toString();
            String uri = request.getRequestURI();
            //将这些信息封装到SysLog里
            SysLog sysLog = new SysLog(null, visitTime, ip, time,
                    uri, browser, operatingSystem);
            //调用service
            sysLogService.save(sysLog);
        }
    }
}
