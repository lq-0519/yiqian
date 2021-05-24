package lq.yiqian.controller;

import eu.bitwalker.useragentutils.UserAgent;
import lq.yiqian.domain.SysLog;
import lq.yiqian.service.ISysLogService;
import lq.yiqian.utils.IpUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 记录用户操作
 * @create 2020-06-09 20:08
 * @author yiqian
 */
@Component
@Aspect
public class LogAop {
    @Resource
    private HttpServletRequest request;
    @Resource
    private ISysLogService sysLogService;

    /**
     * 开始时间
     */
    private Date visitTime;

    /**
     * 访问的类
     */
    private Class aClass;

    /**
     * 前置通知
     * <p>
     * 主要获取开始时间 执行的类 执行的方法
     */
    @Before("execution(* lq.yiqian.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) {
        //访问的类
        aClass = joinPoint.getTarget().getClass();
        if (aClass != LogAop.class && aClass != SysLogController.class) {
            //如果执行的是LogAop类就直接跳过就行
            //开始时间
            visitTime = new Date();
        }
    }

    /**
     * 后置通知
     * <p>
     * 获取访问的ip
     * 获取访问的时长
     */
    @SuppressWarnings("unused")
    @After("execution(* lq.yiqian.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint) {
        if (aClass != null && aClass != LogAop.class && aClass != SysLogController.class) {
            //获取访问的时长
            long time = System.currentTimeMillis() - visitTime.getTime();
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
