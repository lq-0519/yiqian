package lq.yiqian.domain;

/**
 * @author LQ
 * @create 2020-09-17 20:06
 */
public class TopSearch {
    private String bookName;// 书名
    private Integer numberOfSearches;// 搜索次数

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getNumberOfSearches() {
        return numberOfSearches;
    }

    public void setNumberOfSearches(Integer numberOfSearches) {
        this.numberOfSearches = numberOfSearches;
    }

    @Override
    public String toString() {
        return "TopSearch{" +
                "bookName='" + bookName + '\'' +
                ", numberOfSearches=" + numberOfSearches +
                '}';
    }
}
