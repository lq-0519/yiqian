package lq.yiqian.controller;

import lq.yiqian.service.IUtilsService;
import lq.yiqian.service.impl.UtilsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author LQ
 * @create 2021-05-06 21:04
 */
@Controller
@RequestMapping("utils")
public class UtilsController {
    @Resource
    private IUtilsService utilsService;

    public void addAll() {
        utilsService.addAll();
    }

    @RequestMapping("createIndex")
    public void createIndex() {
        utilsService.createIndex();
    }

    @RequestMapping("testES")
    public void testES() {
        utilsService.testES();
    }
}
