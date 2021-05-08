package lq.yiqian.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import lq.yiqian.service.IBookListService;
import lq.yiqian.utils.es.pojo.Book;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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
    @Resource
    private UtilsService utilsService;

    /**
     * 根据书名查询书单
     */
    @Override
    public PageInfo<Book> findByBookName(String bookName, int page, int size) {
        AggregatedPage<Book> books = utilsService.findByBookName(bookName, page, size);
        PageInfo<Book> pageInfo = new PageInfo<>(books.getContent());
        System.out.println("pageInfo = " + JSON.toJSONString(pageInfo));
        pageInfo.setPageNum(page);
        pageInfo.setTotal(books.getTotalElements());
        pageInfo.setPages(books.getTotalPages());
        pageInfo.setList(books.getContent());
        pageInfo.setNavigatepageNums(this.getNavigatePageNums(books, page));
        System.out.println("封装后的pageInfo = " + JSON.toJSONString(pageInfo));
        return pageInfo;
    }

    /**
     * 添加新书
     */
    @Override
    public void save(String bookName, String path) {
        utilsService.save(bookName, path);
    }

    private int[] getNavigatePageNums(AggregatedPage<Book> books, int page) {
        int totalPages = books.getTotalPages();
        if (totalPages == 0) {
            return null;
        }

        if (totalPages < 8) {
            int[] a = new int[totalPages];
            for (int i = 1; i <= totalPages; i++) {
                a[i - 1] = i;
            }
            return a;
        }

        int[] ints = new int[8];
        if (page <= 4) {
            for (int i = 0; i < 8; i++) {
                ints[i] = i + 1;
            }
            return ints;
        }

        if (totalPages - page <= 3) {
            for (int i = 0; i < 8; i++) {
                ints[i] = totalPages - (7 - i);
            }
            return ints;
        }

        int i = page - 3;
        for (int j = 0; j < 8; j++) {
            ints[j] = i + j;
        }
        return null;
    }

}
