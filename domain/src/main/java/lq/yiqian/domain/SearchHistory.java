package lq.yiqian.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author LQ
 * @create 2020-06-24 15:50
 */

/**
 * 存储每一次的搜索记录
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchHistory {
    private Integer id;//唯一id
    private String ip;//查询者的ip地址
    private Date searchTime;//查询的时间
    private String bookName;//查询的书名
    private Integer result;//查询到的结果数目

}
