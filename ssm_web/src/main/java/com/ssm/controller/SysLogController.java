package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.domain.Orders;
import com.ssm.domain.SysLog;
import com.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @Author j
 * @Date 2019/9/10 15:52
 * @Version 1.0
 */
@Controller
@RequestMapping("/log")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/list")
    public String getList(Model model,
                          @RequestParam(value = "page",defaultValue = "1",required = false) int page,
                          @RequestParam(value = "size",defaultValue = "5",required = false) int size
    ){
        PageInfo<SysLog> pageInfo = sysLogService.pageList(page,size);

        model.addAttribute("pageInfo",pageInfo);
        return "syslog-list";
    }
}
