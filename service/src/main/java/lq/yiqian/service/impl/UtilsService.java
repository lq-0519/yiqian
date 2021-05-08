package lq.yiqian.service.impl;

import lq.yiqian.service.IUtilsService;
import lq.yiqian.utils.es.pojo.Book;
import lq.yiqian.utils.es.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author LQ
 * @create 2021-05-06 21:05
 */
@Service
public class UtilsService implements IUtilsService {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Resource
    private BookRepository bookRepository;

    @Override
    public void addAll() {

    }

    @Override
    public void createIndex() {
        elasticsearchTemplate.createIndex(Book.class);
        elasticsearchTemplate.putMapping(Book.class);
    }

    @Override
    public void testES() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("123", "234"));
        books.add(new Book("qwe", "wer"));
        books.add(new Book("asd", "sdf"));
        books.add(new Book("zxc", "xcv"));
        bookRepository.saveAll(books);
    }
}
