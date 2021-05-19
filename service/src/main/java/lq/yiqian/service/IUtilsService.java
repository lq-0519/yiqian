package lq.yiqian.service;

import lq.yiqian.utils.es.pojo.Book;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;

/**
 * @author LQ
 * @create 2021-05-06 21:04
 */
public interface IUtilsService {
    void addAll();

    void createIndex();

    void testES();

    AggregatedPage<Book> findByBookName(String bookName, int page, int size);

    void save(String bookName, String path);

    void dataTransferToES();

    void updateSearchNum();
}
