package lq.yiqian.domain;

/**
 * @author LQ
 * @create 2020-07-04 19:28
 */

/**
 * 用户bean
 */
public class User {
    private Integer id;
    private String username;// 用户名
    private String password;// 密码

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
