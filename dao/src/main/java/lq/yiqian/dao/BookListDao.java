package lq.yiqian.dao;

import lq.yiqian.domain.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LQ
 * @create 2020-06-24 15:57
 */

/**
 * 操作BookList表
 */
public interface BookListDao {
    /**
     * 查询所有
     *
     * @return
     */
    @Select("select id, bookName, path from bookList")
    public List<Book> findAll();

    /**
     * 根据书名查询
     *
     * @param bookName
     * @return
     */
    @Select("select id, bookName, path from bookList where bookName like #{bookName}")
    List<Book> findByBookName(String bookName);

    /**
     * 添加新书
     *
     * @param bookName
     * @param path
     */
    @Insert("insert into bookList(bookName, path) values(#{bookName}, #{path})")
    void save(@Param("bookName") String bookName, @Param("path") String path);
}
