package lq.yiqian.service;

import lq.yiqian.domain.RegiBook;

import java.util.List;

/**
 * @author LQ
 * @create 2020-06-24 17:50
 */
public interface IRegiBookService {
    void save(RegiBook regiBook);

    List<RegiBook> findByIsFund(Integer fund, Integer page, Integer size);

    RegiBook findById(Integer id);

    void updateById_bookName_author_remarks(RegiBook regiBook);

    void updateById_result_isFund(Integer id, String result);

    List<RegiBook> findAllByInvitationCode(String id, Integer page, int size);

    void delById(String id);
}
