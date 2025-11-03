package com.ssm.controller;

import com.ssm.domain.Product;
import com.ssm.service.ProductService;
import com.ssm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author j
 * @Date 2019/9/7 19:27
 * @Version 1.0
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 查询所有
     * @param model
     * @return
     */
    @RequestMapping("/pageList")
    public String list(@RequestParam(value = "page",defaultValue = "1",required = false) int page,
                       @RequestParam(value = "size",defaultValue = "5",required = false) int size,
                       Model model){
//      List<Product> products =  productService.getList();
       PageBean<Product> pageInfo = productService.pageList(page,size);
        model.addAttribute("pageInfo",pageInfo);
      return "product-list";

    }

    @RequestMapping("/initAdd")
    public String initAdd(){
        //单独一个请求方法是为了方便权限控制
        return "product-add";
    }

    @RequestMapping("/add")
    public String add(Product product){
        System.out.println(product);
        int count =  productService.add(product);

        //重定向
        return "redirect:/product/pageList";
    }

    @RequestMapping("/update")
    public String update(Product product){
        int count = productService.update(product);
        return "redirect:/product/pageList";
    }

    @RequestMapping("/initUpdate")
    public String initUpdate(Integer id,Model model){
        Product product = productService.getById(id);
         model.addAttribute("product", product);
        return "product-update";
    }

    @RequestMapping("/delete")
    public String delete(Integer id){
        int count = productService.delete(id);
        return "redirect:/product/pageList";
    }
}