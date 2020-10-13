package lq.yiqian.service.impl;

import com.github.pagehelper.PageHelper;
import lq.yiqian.dao.InvitationCodeDao;
import lq.yiqian.domain.InvitationCode;
import lq.yiqian.service.IInvitationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author LQ
 * @create 2020-06-24 17:36
 */

/**
 * 邀请码
 */
@Service
@Transactional
public class InvitationCodeService implements IInvitationCodeService {
    @Autowired
    private InvitationCodeDao invitationCodeDao;

    @Override
    public List<InvitationCode> findAll() {
        return invitationCodeDao.findAll();
    }

    /**
     * 根据邀请码查询
     *
     * @param invitationCodeId
     * @return
     */
    @Override
    public InvitationCode findById(String invitationCodeId) {
        return invitationCodeDao.findById(invitationCodeId);
    }

    /**
     * 更新总数和剩余次数
     *
     * @param invitationCodeId
     */
    @Override
    public void updateById_sum_last(String invitationCodeId) {
        invitationCodeDao.updateById_sum_last(invitationCodeId);
    }

    /**
     * 根据邀请码或者用户名查询
     * <p>
     * 模糊查询
     *
     * @param condition
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<InvitationCode> findByCondition(String condition, Integer page, int size) {
        PageHelper.startPage(page, size);
        return invitationCodeDao.findByCondition("%" + condition + "%");
    }

    /**
     * 根据id删除
     *
     * @param id
     */
    @Override
    public void deleteById(String id) {
        invitationCodeDao.deleteById(id);
    }

    /**
     * 产生一个可用的邀请码
     *
     * @return
     */
    @Override
    public String createInvitationCode() {
        // 产生邀请码
        String invitationCode = getRandomString(4);
        // 判断邀请码是否已经存在
        while (invitationCodeDao.findById(invitationCode) != null) {
            // 存在继续产生
            invitationCode = getRandomString(4);
        }
        // 不存在代表这个邀请码可用, 直接返回
        return invitationCode;
    }

    /**
     * 存储邀请码
     *
     * @param invitationCode
     * @param username
     * @param accountType
     */
    @Override
    public void save(String invitationCode, String username, String userId, Integer accountType) {
        String accountTypeStr = "";
        if (accountType == 0) {
            accountTypeStr = "QQ";
        } else if (accountType == 1) {
            accountTypeStr = "微信";
        } else if (accountType == 2) {
            accountTypeStr = "淘宝";
        } else if (accountType == 3) {
            accountTypeStr = "其他";
        }
        InvitationCode code = new InvitationCode();
        code.setInvitationCode(invitationCode);
        code.setUsername(username);
        code.setUserId(userId);
        code.setAccountType(accountTypeStr);
        code.setSum(0);
        code.setCreateDate(new Date());
        code.setLast(3);
        invitationCodeDao.save(code);
    }

    /**
     * 更新邀请码
     * <p>
     * 用户名 账户类型 登记总数 今日剩余登记数
     *
     * @param invitationCode
     */
    @Override
    public void updateInvitationCodeDetials(InvitationCode invitationCode) {
        invitationCodeDao.updateById_username_accountType_sum_last(invitationCode);
    }

    /**
     * 产生一个随机的邀请码
     *
     * @param length 控制邀请码的位数
     * @return
     */
    public String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(36);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
