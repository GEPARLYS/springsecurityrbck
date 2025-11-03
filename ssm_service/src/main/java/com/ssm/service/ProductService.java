package com.ssm.service;

import com.ssm.domain.Product;
import com.ssm.util.PageBean;

import java.util.List;

/**
 * @Author j
 * @Date 2019/9/7 19:21
 * @Version 1.0
 */
public interface ProductService {
    List<Product> getList();

    int add(Product product);

    int update(Product product);

    /**
     * 数据回显
     * @param id
     * @return
     */
    Product getById(Integer id);

    int delete(Integer id);


    PageBean<Product> pageList(int page, int size);
}
