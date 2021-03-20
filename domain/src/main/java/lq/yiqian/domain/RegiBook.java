package lq.yiqian.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author LQ
 * @create 2020-06-24 15:43
 */

/**
 * 存储缺书登记的每一个信息
 */
@Data
@SuppressWarnings("SpellCheckingInspection")
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
}
