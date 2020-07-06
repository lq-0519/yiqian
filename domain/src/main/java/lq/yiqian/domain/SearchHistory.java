package lq.yiqian.domain;

import java.util.Date;

/**
 * @author LQ
 * @create 2020-06-24 15:50
 */

/**
 * 存储每一次的搜索记录
 */
public class SearchHistory {
    private Integer id;//唯一id
    private String ip;//查询者的ip地址
    private Date searchTime;//查询的时间
    private String bookName;//查询的书名
    private Integer result;//查询到的结果数目

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(Date searchTime) {
        this.searchTime = searchTime;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
