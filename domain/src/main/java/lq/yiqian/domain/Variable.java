package lq.yiqian.domain;

/**
 * @author LQ
 * @create 2020-06-29 18:49
 */

/**
 * 存储session中的键值对数据
 */
public class Variable {
    private Integer id;// 唯一id
    private String name;// 变量的名字
    private String value;// 变量的值

    @Override
    public String toString() {
        return "Variable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
