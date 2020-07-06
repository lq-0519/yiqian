package lq.yiqian.domain;

/**
 * @author LQ
 * @create 2020-06-24 15:36
 */

/**
 * 存储书的信息
 */
public class Book {
    private Integer id;//唯一id
    private String bookName;//书名
    private String path;//书在百度网盘中的位置

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
}
