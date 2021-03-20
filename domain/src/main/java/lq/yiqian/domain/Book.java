package lq.yiqian.domain;

/**
 * @author LQ
 * @create 2020-06-24 15:36
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 存储书的信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {
    private Integer id;//唯一id
    private String bookName;//书名
    private String path;//书在百度网盘中的位置

}
