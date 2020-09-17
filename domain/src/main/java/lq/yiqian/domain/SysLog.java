package lq.yiqian.domain;


import java.util.Date;

/**
 * @author LQ
 * @create 2020-06-09 19:48
 */
public class SysLog {
    private Integer id;
    private Date visitTime;// 访问时间
    private String ip;// 访问者的ip
    private Long executionTime;// 访问时长
    private String method;// 访问的方法
    private String browser;// 访问者的浏览器
    private String operatingSystem;// 访问者的操作系统

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public SysLog() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Long executionTime) {
        this.executionTime = executionTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public SysLog(Integer id, Date visitTime, String ip, Long executionTime, String method, String browser, String operatingSystem) {
        this.id = id;
        this.visitTime = visitTime;
        this.ip = ip;
        this.executionTime = executionTime;
        this.method = method;
        this.browser = browser;
        this.operatingSystem = operatingSystem;
    }
}
