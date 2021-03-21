package lq.yiqian.domain;

/**
 * @author LQ
 * @create 2020-07-04 19:28
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户bean
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;// 用户名
    private String password;// 密码

}
