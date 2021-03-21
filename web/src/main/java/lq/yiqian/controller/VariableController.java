package lq.yiqian.controller;

import lq.yiqian.domain.Variable;
import lq.yiqian.service.IVariableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;

/**
 * @author LQ
 * @create 2020-07-04 12:16
 */
@Controller
@RequestMapping("/variable")
public class VariableController {
    @Autowired
    private ServletContext servletContext;
    @Autowired
    private IVariableService variableService;

    /**
     * 更新公告
     * <p>
     * 更新ServletContext里面的session
     * 更新数据库
     *
     * @param variable
     * @return
     */
    @RequestMapping("/updateNotice")
    public ModelAndView updateNotice(Variable variable) {
        ModelAndView modelAndView = new ModelAndView();
        servletContext.setAttribute(variable.getName(), variable.getValue());// 先更新servletContext里面的session
        variableService.updateByName_value(variable.getName(), variable.getValue());// 更新数据库
        modelAndView.setViewName("pages/admin/notice");
        return modelAndView;
    }

    /**
     * 更新页脚信息
     */
    @RequestMapping("/updateFooterInfo")
    public ModelAndView updateFooterInfo(String qqGroup, String adminQQ) {
        ModelAndView modelAndView = new ModelAndView();
        servletContext.setAttribute("qqGroup", qqGroup);// 先更新servletContext里面的session
        servletContext.setAttribute("adminQQ", adminQQ);// 先更新servletContext里面的session
        variableService.updateFooterInfo(qqGroup, adminQQ);// 更新数据库
        modelAndView.setViewName("pages/admin/other");
        return modelAndView;
    }
}
