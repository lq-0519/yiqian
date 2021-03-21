package lq.yiqian.domain;

/**
 * @author LQ
 * @create 2020-06-29 18:49
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 存储session中的键值对数据
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Variable {
    private Integer id;// 唯一id
    private String name;// 变量的名字
    private String value;// 变量的值
}
