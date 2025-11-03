package com.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.dao.OrdersDao;
import com.ssm.domain.Orders;
import com.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author j
 * @Date 2019/9/8 11:47
 * @Version 1.0
 */
@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;
    @Override
    public List<Orders> list() {
        List<Orders> orders = ordersDao.list();
        return orders;
    }

    @Override
    public int add(Orders orders) {
        int count = ordersDao.add(orders);
        return count;
    }

    @Override
    public PageInfo<Orders> pageList(int page, int size) {
        //第一个参数是开始的行号
        //第二个参数是获取的记录数
        PageHelper.startPage(page, size);
        //查询所有
        List<Orders> list    = ordersDao.list();
        //根据查询结果创建分页信息并且返回
        PageInfo<Orders> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
