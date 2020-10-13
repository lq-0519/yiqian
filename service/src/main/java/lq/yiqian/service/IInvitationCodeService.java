package lq.yiqian.service;

import lq.yiqian.domain.InvitationCode;

import java.util.List;

/**
 * @author LQ
 * @create 2020-06-24 17:36
 */
public interface IInvitationCodeService {
    List<InvitationCode> findAll();

    InvitationCode findById(String invitationCodeId);

    void updateById_sum_last(String invitationCodeId);

    List<InvitationCode> findByCondition(String condition, Integer page, int size);

    void deleteById(String id);

    String createInvitationCode();

    void save(String invitationCode, String username, String userId, Integer accountType);

    void updateInvitationCodeDetials(InvitationCode invitationCode);
}
