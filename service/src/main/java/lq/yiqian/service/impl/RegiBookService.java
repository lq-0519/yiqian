package lq.yiqian.service.impl;

import com.github.pagehelper.PageHelper;
import lq.yiqian.dao.RegiBookDao;
import lq.yiqian.domain.RegiBook;
import lq.yiqian.service.IRegiBookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author LQ
 * @create 2020-06-24 17:51
 */

/**
 * 缺书登记
 */
@Service
@Transactional
public class RegiBookService implements IRegiBookService {
    @Resource
    private RegiBookDao regiBookDao;

    /**
     * 缺书登记
     */
    @Override
    public void save(RegiBook regiBook) {
        regiBook.setIsFund(0);//初始化isFund, isFund=0代表还没处理
        regiBook.setRegiDate(new Date());//记录登记的时间
        regiBookDao.save(regiBook);
    }

    /**
     * 根据是否被处理查询regiBook
     */
    @Override
    public List<RegiBook> findByIsFund(Integer fund, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return regiBookDao.findByIsFund(fund);
    }

    /**
     * 根据id查询
     */
    @Override
    public RegiBook findById(Integer id) {
        return regiBookDao.findById(id);
    }

    /**
     * 更新书名和作者
     */
    @Override
    public void updateById_bookName_author_remarks(RegiBook regiBook) {
        regiBookDao.updateById_bookName_author_remarks(regiBook);
    }

    /**
     * 更新找书结果
     */
    @Override
    public void updateById_result_isFund(Integer id, String result) {
        regiBookDao.updateById_result_isFund(id, result);
    }

    @Override
    public List<RegiBook> findAllByInvitationCode(String id, Integer page, int size) {
        PageHelper.startPage(page, size);
        return regiBookDao.findAllByInvitationCode(id);
    }

    /**
     * 根据ID删除
     */
    @Override
    public void delById(String id) {
        regiBookDao.delById(id);
    }
}
