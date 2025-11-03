package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.domain.Orders;
import com.ssm.domain.Product;
import com.ssm.service.OrdersService;
import com.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * @Author j
 * @Date 2019/9/8 11:39
 * @Version 1.0
 */

@Controller
@RequestMapping("/orders")
public class    OrdersController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public String list(Model model,
                       @RequestParam(value = "page",defaultValue = "1",required = false) int page,
                       @RequestParam(value = "size",defaultValue = "5",required = false) int size
                       ){
//        List<Orders> orders = ordersService.list();
        PageInfo<Orders> pageInfo = ordersService.pageList(page,size);
        model.addAttribute("pageInfo",pageInfo);
        return "order-list";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(Orders orders){
        int count = ordersService.add(orders);
        return "redirect:/orders/list";
    }
    @RequestMapping(value = "/initAdd",method = RequestMethod.GET)
    public String initAdd(Model model){
        //查询所有产品信息,下拉列表,Product注入进来
        List<Product> pList = productService.getList();
        model.addAttribute("pList",pList);
        return "order-add";

    }
}
