package lq.yiqian.service;

import com.github.pagehelper.PageInfo;
import lq.yiqian.utils.es.pojo.Book;

import java.util.List;

/**
 * @author LQ
 * @create 2020-06-24 15:56
 */
public interface IBookListService {
    PageInfo<Book> findByBookName(String bookName, int page, int size);

    void save(String bookName, String path);
}
