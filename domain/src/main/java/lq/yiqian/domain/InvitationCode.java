package lq.yiqian.domain;

import java.util.Date;

/**
 * @author LQ
 * @create 2020-06-24 15:39
 */

/**
 * 存储每一个邀请码信息
 */
public class InvitationCode {
    private String invitationCode;//邀请码, 也作为主键
    private String username;//用户名, 管理员自己填写的
    private String userId;//唯一标识, 可以使用这个userId来找到这个用户
    private String accountType;//用户名的账户类型, 可以是qq wx tb
    private Date createDate;//邀请码的创建时间
    private Integer sum;//当前邀请码进行缺书登记的总次数
    private Integer last;//当前邀请码今天剩余的登记次数

    @Override
    public String toString() {
        return "InvitationCode{" +
                "invitationCode='" + invitationCode + '\'' +
                ", username='" + username + '\'' +
                ", userId='" + userId + '\'' +
                ", accountType='" + accountType + '\'' +
                ", createDate=" + createDate +
                ", sum=" + sum +
                ", last=" + last +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getLast() {
        return last;
    }

    public void setLast(Integer last) {
        this.last = last;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
}
