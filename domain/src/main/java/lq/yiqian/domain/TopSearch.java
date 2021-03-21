package lq.yiqian.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LQ
 * @create 2020-09-17 20:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopSearch {
    private String bookName;// 书名
    private Integer numberOfSearches;// 搜索次数
}
