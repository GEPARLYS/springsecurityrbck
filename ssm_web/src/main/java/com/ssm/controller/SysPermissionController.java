package com.ssm.controller;

import com.ssm.domain.SysPermission;
import com.ssm.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author j
 * @Date 2019/9/8 20:09
 * @Version 1.0
 */
@Controller
@RequestMapping("/permission")
public class SysPermissionController {

    @Autowired
    private SysPermissionService sysPermissionService;

    @RequestMapping("/list")
    public String list(Model model){
        List<SysPermission> pList = sysPermissionService.getList();
        model.addAttribute("pList",pList);
        return "permission-list";
    }

    @RequestMapping("/initAdd")
    public String initAdd(){
        return "permission-add";
    }

    @RequestMapping("/add")
    public String add(SysPermission sysPermission){

        int count = sysPermissionService.add(sysPermission);
        return "redirect:/permission/list";
    }
}
