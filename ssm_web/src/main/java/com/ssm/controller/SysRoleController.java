package com.ssm.controller;


import com.ssm.domain.SysRole;
import com.ssm.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @Author j
 * @Date 2019/9/8 19:48
 * @Version 1.0
 */
@Controller
@RequestMapping("/role") //todo
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @RolesAllowed("ADMIN")
    @RequestMapping("/list")
    public String list(Model model){
        List<SysRole> roleList = sysRoleService.roleList();
        model.addAttribute("roleList",roleList);
        return "role-list";
    }
}
