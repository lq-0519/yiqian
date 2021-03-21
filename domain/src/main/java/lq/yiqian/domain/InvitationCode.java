package lq.yiqian.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author LQ
 * @create 2020-06-24 15:39
 */

/**
 * 存储每一个邀请码信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvitationCode {
    private String invitationCode;//邀请码, 也作为主键
    private String username;//用户名, 管理员自己填写的
    private String userId;//唯一标识, 可以使用这个userId来找到这个用户
    private String accountType;//用户名的账户类型, 可以是qq wx tb
    private Date createDate;//邀请码的创建时间
    private Integer sum;//当前邀请码进行缺书登记的总次数
    private Integer last;//当前邀请码今天剩余的登记次数

}
