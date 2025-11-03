package com.ssm.service.impl;

import com.ssm.dao.ProductDao;
import com.ssm.domain.Product;
import com.ssm.service.ProductService;
import com.ssm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author j
 * @Date 2019/9/7 19:22
 * @Version 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> getList() {
        List<Product> list  = productDao.getList();
        return list;
    }

    @Override
    public int add(Product product) {
        int count = productDao.add(product);
        return count;
    }

    @Override
    public int update(Product product) {
       int count =  productDao.update(product);
        return count;
    }

    @Override
    public Product getById(Integer id) {
        Product product = productDao.getById(id);
        return product;
    }

    @Override
    public int delete(Integer id) {
        int count = productDao.delete(id);
        return count;
    }

    @Override
    public PageBean<Product> pageList(int page, int size) {
        PageBean<Product> pageBean = new PageBean<>();
        //设置每页显示的记录数
        pageBean.setPageSize(size);
        //当前页码
        pageBean.setPageCode(page);
        //获取总页数
        int total = productDao.getCount();
        //计算开始行
        pageBean.setTotalCount(total);
        int start = (page - 1) * size + 1;
        //计算结束行
        int end = page * size;
        //分页结果查询
        List<Product> products = productDao.pageList(page,size);
        //设置分页结果集
        pageBean.setBeanList(products);
        return pageBean;
    }
}
