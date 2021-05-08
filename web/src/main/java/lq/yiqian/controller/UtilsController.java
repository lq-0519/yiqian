package lq.yiqian.controller;

import lq.yiqian.service.IUtilsService;
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

    /**
     * 将数据库中所有的数据迁移到es中
     */
    public void addAll() {
        utilsService.addAll();
    }

    /**
     * 创建索引
     */
    @RequestMapping("createIndex")
    public void createIndex() {
        utilsService.createIndex();
    }

    /**
     * 测试
     */
    @RequestMapping("testES")
    public void testES() {
        utilsService.testES();
    }

    /**
     * 数据转移
     */
    @RequestMapping("dataTransferToES")
    public void dataTransferToES() {
        utilsService.dataTransferToES();
    }
}
