package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.domain.SysRole;
import com.ssm.domain.SysUser;
import com.ssm.service.SysRoleService;
import com.ssm.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author j
 * @Date 2019/9/8 18:51
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping("/pageList")
    public String pageList(@RequestParam(value = "page",defaultValue = "1",required = false) int page,
                           @RequestParam(value = "size",defaultValue = "5",required = false) int size,
                           Model model){

        PageInfo<SysUser> pageInfo = sysUserService.pageList(page,size);

        model.addAttribute("pageInfo",pageInfo);
        return "user-list";
    }

    @RequestMapping("/initAdd")
    public String initAdd(){
        return "user-add";
    }

    @RequestMapping("/add")
    public String add(SysUser sysUser){
        int count = sysUserService.add(sysUser);
        return "redirect:/user/pageList";

    }

    @RequestMapping("/show")
    public String show(Integer id,Model model){
        SysUser sysUser = sysUserService.getById(id);
        model.addAttribute("user",sysUser);
        return "user-show";

    }

    @RequestMapping("/role/modify")
    public String  modifyRole(@RequestParam(value = "userId") Integer userId, @RequestParam(value = "ids") List<Integer> ids){
        int count = sysUserService.updateRoles(userId,ids);
        return "redirect:/user/pageList";

    }
    @RequestMapping("/role/initModify")
    public String initModify(Integer id,Model model){
        //角色信息
        List<SysRole> roleList = sysRoleService.getList();
        SysUser user = sysUserService.getById(id);
        List<SysRole> userRoles = user.getRoles();
        StringBuilder stringBuffer = new StringBuilder();
        if (userRoles != null && !userRoles.isEmpty()) {
            for (SysRole userRole : userRoles) {
                stringBuffer.append(userRole.getRoleName()+"");
            }
        }

        model.addAttribute("rolenames",stringBuffer.toString());
        model.addAttribute("roleList",roleList);
        model.addAttribute("user",user);
        return "user-role-add";
    }
}
