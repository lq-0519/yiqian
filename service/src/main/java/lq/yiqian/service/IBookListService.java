package lq.yiqian.service;

import lq.yiqian.domain.Book;

import java.util.List;

/**
 * @author LQ
 * @create 2020-06-24 15:56
 */
public interface IBookListService {
    public List<Book> findAll();

    List<Book> findByBookName(String bookName, int page, int size);

    void save(String bookName, String path);
}
