package lq.yiqian.domain;

import java.util.Date;

/**
 * @author LQ
 * @create 2020-06-24 15:43
 */

/**
 * 存储缺书登记的每一个信息
 */
public class RegiBook {
    private Integer id;//唯一id
    private String bookName;//登记的书名
    private String author;//登记的作者
    private String invitationCodeId;//登记时使用的邀请码
    private String remarks;//登记时留下都备注
    private Integer isFund;//是否被处理, 0代表未处理, 1代表已处理
    private String result;//找书结果, 可以填 '未找到' or '书库中要'
    private Date regiDate;//登记日期
    private String email;//登记使用的邮箱, 用于发送找书结果通知

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private InvitationCode invitationCode;

    @Override
    public String toString() {
        return "RegiBook{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", invitationCodeId='" + invitationCodeId + '\'' +
                ", remarks='" + remarks + '\'' +
                ", isFund=" + isFund +
                ", result='" + result + '\'' +
                ", regiDate=" + regiDate +
                ", invitationCode=" + invitationCode +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getInvitationCodeId() {
        return invitationCodeId;
    }

    public void setInvitationCodeId(String invitationCodeId) {
        this.invitationCodeId = invitationCodeId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getIsFund() {
        return isFund;
    }

    public void setIsFund(Integer isFund) {
        this.isFund = isFund;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getRegiDate() {
        return regiDate;
    }

    public void setRegiDate(Date regiDate) {
        this.regiDate = regiDate;
    }

    public InvitationCode getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(InvitationCode invitationCode) {
        this.invitationCode = invitationCode;
    }
}
