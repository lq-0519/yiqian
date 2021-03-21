package lq.yiqian.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author LQ
 * @create 2020-06-09 19:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysLog {
    private Integer id;
    private Date visitTime;// 访问时间
    private String ip;// 访问者的ip
    private Long executionTime;// 访问时长
    private String uri;// 访问的URI
    private String browser;// 访问者的浏览器
    private String operatingSystem;// 访问者的操作系统

}
