package lq.yiqian.controller;

import com.github.pagehelper.PageInfo;
import lq.yiqian.domain.InvitationCode;
import lq.yiqian.domain.RegiBook;
import lq.yiqian.service.IInvitationCodeService;
import lq.yiqian.service.IRegiBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author LQ
 * @create 2020-06-24 17:37
 */

/**
 * 邀请码相关的控制层
 */
@Controller
@RequestMapping("/invitationCode")
public class InvitationCodeController {
    @Autowired
    private IInvitationCodeService invitationCodeService;
    @Autowired
    private IRegiBookService regiBookService;

    /**
     * 展示邀请码
     * <p>
     * 可根据传过来的条件来查询, 条件为空就默认查询所有
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                @RequestParam(name = "condition", defaultValue = "") String condition) {
        ModelAndView modelAndView = new ModelAndView();
        List<InvitationCode> invitationCodes = invitationCodeService.findByCondition(condition, page, 40);// 分页查询
        PageInfo pageInfo = new PageInfo(invitationCodes);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.addObject("condition", condition);// 将查询条再返回回去, 用于分页查询
        // 返回查询信息
        if (condition != null && condition.length() > 0) {
            modelAndView.addObject("msgSearch", "你搜索的是: <strong>" + condition + "</strong><br>");
        } else {
            modelAndView.addObject("msgSearch", "");
        }
        modelAndView.setViewName("pages/admin/invitationCode");
        return modelAndView;
    }

    /**
     * 根据id删除邀请码
     * <p>
     * 可以将关联的外键置空
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    public String deleteById(@RequestParam(name = "id") String id) {
        invitationCodeService.deleteById(id);
        return "redirect:findAll";
    }

    /**
     * 添加邀请码
     * <p>
     * 添加邀请码之前要先看看这个邀请码是否已经存在
     *
     * @param username
     * @param userId
     * @param accountType
     * @param session
     * @return
     */
    @RequestMapping("/addInvitationCode")
    public String addInvitationCode(@RequestParam(name = "username") String username,
                                    @RequestParam(name = "userId") String userId,
                                    @RequestParam(name = "accountType", defaultValue = "3") Integer accountType,
                                    HttpSession session) {
        // 产生邀请码
        String invitationCode = invitationCodeService.createInvitationCode();
        // 添加邀请码
        invitationCodeService.save(invitationCode, username, userId, accountType);
        // 将邀请码放进session里
        session.setAttribute("invitationCodeMsg", "邀请码为: " + invitationCode + " , 请牢记, 以后都是使用这个邀请码进行缺书登记! <br>");
        return "redirect:findAll";
    }

    /**
     * 显示邀请码的详细信息
     * <p>
     * 还要显示这个邀请码登记过的书
     *
     * @param id
     * @param page
     * @return
     */
    @RequestMapping("/showInvitationCodeDetials")
    public ModelAndView showInvitationCodeDetials(@RequestParam(name = "id") String id,
                                                  @RequestParam(name = "page", defaultValue = "1") Integer page) {
        ModelAndView modelAndView = new ModelAndView();
        // 查出该邀请码的详细信息
        InvitationCode invitationCode = invitationCodeService.findById(id);
        // 查出该邀请码登记过的书
        List<RegiBook> regiBooks = regiBookService.findAllByInvitationCode(id, page, 10);
        PageInfo pageInfo = new PageInfo(regiBooks);
        modelAndView.addObject("invitationCode", invitationCode);// 存储查出来的邀请码的详细信息
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("/pages/admin/invitationCodeDetial");
        return modelAndView;
    }

    /**
     * 更新邀请码
     *
     * @param invitationCode
     * @return
     */
    @RequestMapping("/updateInvitationCodeDetials")
    public String updateInvitationCodeDetials(InvitationCode invitationCode) {
        invitationCodeService.updateInvitationCodeDetials(invitationCode);
        return "redirect:findAll";
    }
}
