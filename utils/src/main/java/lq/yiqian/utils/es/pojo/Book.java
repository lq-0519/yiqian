package lq.yiqian.utils.es.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @author LQ
 * @create 2021-05-06 20:36
 */
@Document(indexName = "book", type = "book", shards = 1, replicas = 0)
public class Book implements Serializable {
    @Id
    @Field
    private Long id;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String bookName;//书名

    @Field(index = false, type = FieldType.Text)
    private String path;//书在百度网盘中的位置

    public Book() {
    }

    public Book(String bookName, String path) {
        this.bookName = bookName;
        this.path = path;
    }

    public Book(Long id, String bookName, String path) {
        this.id = id;
        this.bookName = bookName;
        this.path = path;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
