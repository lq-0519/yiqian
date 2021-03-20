package lq.yiqian.domain;

/**
 * @author LQ
 * @create 2020-06-29 18:49
 */

import lombok.Data;

/**
 * 存储session中的键值对数据
 */
@Data
public class Variable {
    private Integer id;// 唯一id
    private String name;// 变量的名字
    private String value;// 变量的值
}
