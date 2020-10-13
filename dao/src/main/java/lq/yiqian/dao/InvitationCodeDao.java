package lq.yiqian.dao;

import lq.yiqian.domain.InvitationCode;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author LQ
 * @create 2020-06-24 17:35
 */

/**
 * 操作邀请码列表(invitationCodeList)的类
 */
public interface InvitationCodeDao {
    /**
     * 查询所有
     *
     * @return
     */
    @Select("select invitationCode, username, userId, accountType, createDate, sum, last  " +
            " from invitationCodeList  " +
            "order by createDate desc")
    List<InvitationCode> findAll();

    /**
     * @param condition
     * @return
     */
    @Select("select invitationCode, username, userId, accountType, createDate, sum, last  " +
            " from invitationCodeList where invitationCode like #{condition} or username like #{condition} " +
            "order by createDate desc")
    List<InvitationCode> findByCondition(String condition);

    /**
     * 根据邀请码查询
     *
     * @param invitationCodeId
     * @return
     */
    @Select("select invitationCode, username, userId, accountType, createDate, sum, last from invitationCodeList where invitationCode = #{invitationCodeId}")
    InvitationCode findById(String invitationCodeId);

    /**
     * 更新sum和last的值
     * <p>
     * sum++
     * last++
     *
     * @param invitationCodeId
     */
    @Update("update invitationCodeList set sum=sum+1, last=last-1 where invitationCode = #{invitationCodeId}")
    void updateById_sum_last(String invitationCodeId);

    /**
     * 根据id删除
     *
     * @param id
     */
    @Delete("delete from invitationCodeList where  invitationCode = #{id} ")
    void deleteById(String id);

    /**
     * 添加邀请码
     *
     * @param code
     */
    @Insert("insert into invitationCodeList(invitationCode, username, userId, accountType, createDate, sum, last) " +
            "values(#{invitationCode}, #{username}, #{userId}, #{accountType}, #{createDate}, #{sum}, #{last})")
    void save(InvitationCode code);

    /**
     * 更新邀请码
     * <p>
     * username accountType sum last
     *
     * @param invitationCode
     */
    @Update("update invitationCodeList set username=#{username}, userId=#{userId}, accountType=#{accountType}, sum=#{sum}, last=#{last}" +
            " where invitationCode = #{invitationCode}")
    void updateById_username_accountType_sum_last(InvitationCode invitationCode);
}
