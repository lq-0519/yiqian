package lq.yiqian.dao;

import lq.yiqian.domain.InvitationCode;
import lq.yiqian.domain.RegiBook;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author LQ
 * @create 2020-06-24 17:45
 */

/**
 * 缺书登记
 */
public interface RegiBookDao {
    /**
     * 缺书登记
     *
     * @param regiBook
     */
    @Insert("insert into regiBook(bookName, author, invitationCodeId, remarks, isFund, regiDate, email) " +
            " values(#{bookName}, #{author}, #{invitationCodeId}, #{remarks}, #{isFund}, #{regiDate}, #{email})")
    void save(RegiBook regiBook);

    /**
     * 根据isFund查询
     *
     * @param isFund
     * @return
     */
    @Select("select bookName, author, invitationCodeId, remarks, isFund, result, id, regiDate, email " +
            " from regiBook where isFund = #{isFund} order by regiDate desc")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "bookName", column = "bookName"),
            @Result(property = "author", column = "author"),
            @Result(property = "invitationCodeId", column = "invitationCodeId"),
            @Result(property = "remarks", column = "remarks"),
            @Result(property = "isFund", column = "isFund"),
            @Result(property = "email", column = "email"),
            @Result(property = "regiDate", column = "regiDate"),
            @Result(property = "result", column = "result"),
            @Result(property = "invitationCode", column = "invitationCodeId", javaType = InvitationCode.class,
                    one = @One(select = "lq.yiqian.dao.InvitationCodeDao.findById", fetchType = FetchType.LAZY))
    })
    List<RegiBook> findByIsFund(Integer isFund);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Select("select bookName, author, invitationCodeId, remarks, isFund, result, id, regiDate, email " +
            " from regiBook where id = #{id} ")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "bookName", column = "bookName"),
            @Result(property = "author", column = "author"),
            @Result(property = "invitationCodeId", column = "invitationCodeId"),
            @Result(property = "remarks", column = "remarks"),
            @Result(property = "isFund", column = "isFund"),
            @Result(property = "email", column = "email"),
            @Result(property = "regiDate", column = "regiDate"),
            @Result(property = "result", column = "result"),
            @Result(property = "invitationCode", column = "invitationCodeId", javaType = InvitationCode.class,
                    one = @One(select = "lq.yiqian.dao.InvitationCodeDao.findById", fetchType = FetchType.LAZY))
    })
    RegiBook findById(Integer id);

    /**
     * 更新书名和作者
     *
     * @param regiBook
     */
    @Update("update regiBook set bookName = #{bookName}, author = #{author}, remarks = #{remarks} where id = #{id}")
    void updateById_bookName_author_remarks(RegiBook regiBook);

    /**
     * 更新找书结果
     *
     * @param id
     * @param result
     */
    @Update("update regiBook set result = #{result}, isFund = 1 where id = #{id}")
    void updateById_result_isFund(@Param("id") Integer id, @Param("result") String result);

    /**
     * 根据邀请码查询登记过的书
     *
     * @param id
     * @return
     */
    @Select("select bookName, author, invitationCodeId, remarks, isFund, result, id, regiDate, email from regiBook " +
            "where invitationCodeId = #{id} order by regiDate desc")
    List<RegiBook> findAllByInvitationCode(String id);

    /**
     * 根据id删除
     *
     * @param id
     */
    @Delete("delete from regiBook where id = #{id}")
    void delById(String id);
}
