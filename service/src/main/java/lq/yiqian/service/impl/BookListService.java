package lq.yiqian.service.impl;

import com.github.pagehelper.PageHelper;
import lq.yiqian.dao.BookListDao;
import lq.yiqian.domain.Book;
import lq.yiqian.service.IBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author LQ
 * @create 2020-06-24 15:57
 */

/**
 * 查询书单的service层
 */
@Service
@Transactional
public class BookListService implements IBookListService {
    @Autowired
    private BookListDao bookListDao;

    public List<Book> findAll() {
        return bookListDao.findAll();
    }

    /**
     * 根据书名查询书单
     */
    @Override
    public List<Book> findByBookName(String bookName, int page, int size) {
        PageHelper.startPage(page, size);//设置分页的条件
        return bookListDao.findByBookName("%" + bookName + "%");
    }

    /**
     * 添加新书
     */
    @Override
    public void save(String bookName, String path) {
        bookListDao.save(bookName, path);
    }

}
