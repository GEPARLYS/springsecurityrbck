package com.ssm.service;

import com.github.pagehelper.PageInfo;
import com.ssm.domain.Orders;

import java.util.List;

/**
 * @Author j
 * @Date 2019/9/8 11:46
 * @Version 1.0
 */
public interface OrdersService {
    List<Orders> list();

    int add(Orders orders);

    PageInfo<Orders> pageList(int page, int size);
}
