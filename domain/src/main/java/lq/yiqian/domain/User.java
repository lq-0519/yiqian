package lq.yiqian.domain;

/**
 * @author LQ
 * @create 2020-07-04 19:28
 */

import lombok.Data;

/**
 * 用户bean
 */
@Data
public class User {
    private Integer id;
    private String username;// 用户名
    private String password;// 密码

}
