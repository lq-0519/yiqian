package lq.yiqian.utils.es.repository;

import lq.yiqian.utils.es.pojo.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author LQ
 * @create 2021-05-06 20:42
 */
public interface BookRepository extends ElasticsearchRepository<Book, Long> {
}
