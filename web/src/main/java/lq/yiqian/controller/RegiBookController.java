package lq.yiqian.controller;

import com.github.pagehelper.PageInfo;
import lq.yiqian.domain.InvitationCode;
import lq.yiqian.domain.RegiBook;
import lq.yiqian.service.IBookListService;
import lq.yiqian.service.IInvitationCodeService;
import lq.yiqian.service.IRegiBookService;
import lq.yiqian.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author LQ
 * @create 2020-06-25 17:57
 */

/**
 * 缺书登记
 */
@Controller
@RequestMapping("/regiBook")
public class RegiBookController {
    @Autowired
    private IBookListService bookListService;
    @Autowired
    private IRegiBookService regiBookService;
    @Autowired
    private IInvitationCodeService invitationCodeService;

    /**
     * 用户进行缺书登记
     * <p>
     * 需要做如下工作:
     * 1 检验邀请码是否存在
     * 2 检验该邀请码今天还有没有剩余登记次数(每个邀请码一天只能登记5个, 登记次数每天01:00刷新)
     *
     * @param regiBook
     * @return
     */
    @RequestMapping("/save")
    public ModelAndView save(RegiBook regiBook) {
        ModelAndView modelAndView = new ModelAndView();
        //先根据用户传来的邀请码去数据库查询邀请码是否存在, 不存在就返回
        String invitationCodeId = regiBook.getInvitationCodeId();
        InvitationCode invitationCode = invitationCodeService.findById(invitationCodeId);
        if (invitationCode != null) {
            //邀请码存在
            //判断当前的邀请码今天还有没有剩余的登记次数
            Integer last = invitationCode.getLast();
            if (last == 0) {
                //今天的登记次数已用完, 返回错误信息error=2 (error = 2 代表登记次数用完)
                modelAndView.addObject("error", 2);
            } else {
                //还有剩余次数
                regiBookService.save(regiBook);//存储进数据库
                invitationCodeService.updateById_sum_last(regiBook.getInvitationCodeId());//更新当前邀请码登记总数和今天剩余登记次数
                if (last == 1) {
                    //last=1代表使用的是今天最后一个登记机会
                    modelAndView.addObject("error", 3);//error=3 代表登记成功了,但是今天的登记次数已经用完了
                } else {
                    //今天还有>=1次的登记机会
                    modelAndView.addObject("invitationCode", invitationCodeId);//把邀请码传回去, 方便用户登记书
                    modelAndView.addObject("last", last - 1);// 传回剩余次数
                    modelAndView.addObject("error", 0);// error=0 代表登记成功
                    modelAndView.addObject("email", regiBook.getEmail());
                }
            }
        } else {
            //邀请码不存在
            modelAndView.addObject("error", 1);// error=1 代表邀请码不存在
            //将除了邀请码之外的信息再传回去, 方便用户填写
            modelAndView.addObject("bookName", regiBook.getBookName());
            modelAndView.addObject("author", regiBook.getAuthor());
            modelAndView.addObject("remarks", regiBook.getRemarks());
            modelAndView.addObject("email", regiBook.getEmail());
        }
        modelAndView.setViewName("pages/regiBook");
        return modelAndView;
    }

    /**
     * 展示找书结果
     * <p>
     * 使用分页, 查询已经处理的数据
     *
     * @param page
     * @return
     */
    @RequestMapping("/findByIsFund")
    public ModelAndView findByIsFund(@RequestParam(name = "page", defaultValue = "1") Integer page) {
//        int i = 1 / 0;  // 用于测试页面抛出异常
        ModelAndView modelAndView = new ModelAndView();
        List<RegiBook> regiBooks = regiBookService.findByIsFund(1, page, 40);// 默认页面大小为40
        PageInfo pageInfo = new PageInfo(regiBooks);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("pages/regiResult");
        return modelAndView;
    }

    /**
     * 查询未处理的缺书登记
     *
     * @return
     */
    @RequestMapping("/findByUntreated")
    public ModelAndView findByUntreated() {
        ModelAndView modelAndView = new ModelAndView();
        List<RegiBook> regiBooks = regiBookService.findByIsFund(0, 1, 300);
        PageInfo pageInfo = new PageInfo(regiBooks);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("pages/admin/regiBook");
        return modelAndView;
    }


    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        RegiBook regiBook = regiBookService.findById(id);
        modelAndView.addObject("regiBook", regiBook);
        modelAndView.setViewName("pages/admin/regiBookDetial");
        return modelAndView;
    }

    /**
     * 更新书名和作者
     *
     * @param regiBook
     * @return
     */
    @RequestMapping("/updateById_bookName_author_remarks")
    public String updateById_bookName_author_remarks(RegiBook regiBook) {
        regiBookService.updateById_bookName_author_remarks(regiBook);
        return "redirect:findByUntreated";
    }

    /**
     * 更新找书结果
     * <p>
     * 找到书了, 需要把找到的书添加到书单, 需要修改两个表, 一个是regiBook表, 另一个是bookList表
     * 没有找到就算了, 只需要更新一个regiBook表就行了
     *
     * @param id
     * @param regiBookResult 0代表找到了 1代表没找到 2代表书库中有
     * @param remarks        登记找书结果时的备注信息
     * @param regiDate       登记时的时间(格式:MMdd)
     * @param yearAndMonth   登记时的时间(格式:yyyyMM)
     * @return
     */
    @RequestMapping("/updateResult")
    public String updateResult(Integer id, String regiBookResult, String remarks, String regiDate, String yearAndMonth) {
        RegiBook regiBook = regiBookService.findById(id);// 查出相应的缺书登记
        String bookName = regiBook.getBookName();// 获取书名
        String author = regiBook.getAuthor();// 获取作者
        String email = regiBook.getEmail();// 获取邮箱
        String result = "";// 找书结果
        String emailResult = "登记书名: " + bookName + ",\n登记时间: " + regiDate + ",\n找书结果: ";// 要用邮箱发送的内容
        if ("0".equals(regiBookResult)) {
            // 新起一个线程去更新Redis缓存
            String appendBookName = bookName;
            new Thread(() -> bookListService.updateRedis(appendBookName)).start();
            // 求出path
            String path = "小书屋/06-后续更新/" + yearAndMonth + "/" + regiDate;
            // regiBookResult=0 代表找到了
            // 判断remarks是否为空
            if (remarks == null || remarks.length() == 0) {
                // remarks为空
                // 直接使用登记日期作为找书结果
                result = path;
            } else {
                // remarks不为空
                // 使用登记日期+备注作为找书结果
                result = path + "  (" + remarks + ")";
            }
            // 插入bookList表
            // 求出bookName
            // 判断author是否为空
            if (author != null && author.length() > 0) {
                // author不为空
                // bookList中的bookName就是用原来的bookName+" "+author
                bookName = bookName + " " + author;
            }
            // 插入bookList
            bookListService.save(bookName, path);
        } else if ("1".equals(regiBookResult)) {
            // regiBookResult=1 代表没找到
            // 判断remarks是否为空
            if (remarks == null || remarks.length() == 0) {
                // remarks为空
                // 直接使用"未找到"作为找书结果
                result = "未找到";
            } else {
                // remarks不为空
                // 使用"未找到+备注作为找书结果
                result = "未找到 (" + remarks + ")";
            }
        } else if ("2".equals(regiBookResult)) {
            // regiBookResult=2 代表登记的书书库中有
            // 更新regiBook表
            // 判断remarks是否为空
            if (remarks == null || remarks.length() == 0) {
                // remarks为空
                // 直接使用"书库中有"作为找书结果
                result = "书库中有";
            } else {
                // remarks不为空
                // 使用"书库中有"+备注作为找书结果
                result = "书库中有 (" + remarks + ")";
            }
        }
        // 发送找书结果的邮件
        if (email != null && email.length() > 0) {
            emailResult = emailResult + result + ",\n详情请访问: " +
                    "<a href='http://182.92.81.132/regiBook/findByIsFund'>找书结果</a> " +
                    "\n此邮件为自动发送, 请勿回复!";
            String finalEmailResult = emailResult;
            new Thread(() -> MailUtils.sendMail(email, finalEmailResult, "壹仟书库 找书结果")).start();
        }
        // 更新regiBook表
        regiBookService.updateById_result_isFund(id, result);
        return "redirect:findByUntreated";
    }

    /**
     * 查询已经处理过的缺书登记
     *
     * @param page
     * @return
     */
    @RequestMapping("/findByIsFundAdmin")
    public ModelAndView findByIsFundAdmin(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        ModelAndView modelAndView = new ModelAndView();
        List<RegiBook> regiBooks = regiBookService.findByIsFund(1, page, 40);// 默认页面大小为40
        PageInfo pageInfo = new PageInfo(regiBooks);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("pages/admin/regiBookHasFund");
        return modelAndView;
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @RequestMapping("/delById")
    public String delById(@RequestParam(name = "id") String id) {
        regiBookService.delById(id);
        return "redirect:findByUntreated";
    }
}
