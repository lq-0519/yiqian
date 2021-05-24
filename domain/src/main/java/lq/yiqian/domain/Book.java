package lq.yiqian.domain;

import java.io.Serializable;

/**
 * 存储书的信息
 * @author LQ
 * @create 2020-06-24 15:36
 */
public class Book implements Serializable {
    /**
     * id
     */
    private Integer id;
    /**
     * 书名
     */
    private String bookName;

    /**
     * 书在百度网盘中的位置
     */
    private String path;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
