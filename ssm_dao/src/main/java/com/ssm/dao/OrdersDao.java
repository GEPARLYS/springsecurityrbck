package com.ssm.dao;

import com.ssm.domain.Orders;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author j
 * @Date 2019/9/8 11:49
 * @Version 1.0
 */
public interface OrdersDao {
    @Select("select o.id as oid,o.orderNum,o.orderTime,o.peopleCount,o.orderDesc,o.payType,o.orderStatus,p.* from orders o,product p where o.productId = p.id")
    @Results(value = {
            @Result(id = true, property = "id", column = "oid"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "product.id", column = "id"),
            @Result(property = "product.productNum", column = "productNum"),
            @Result(property = "product.productName", column = "productName"),
            @Result(property = "product.cityName", column = "cityName"),
            @Result(property = "product.departureTime", column = "departureTime"),
            @Result(property = "product.productPrice", column = "productPrice"),
            @Result(property = "product.productDesc", column = "productDesc"),
            @Result(property = "product.productStatus", column = "productStatus")
    })
    List<Orders> list();

    @Insert("insert into orders (id,orderNum,orderTime,peopleCount,orderDesc,payType,orderStatus,productId) values (ORDERS_SEQ.NEXTVAL,#{orderNum},#{orderTime},#{peopleCount},#{orderDesc},#{payType},#{orderStatus},#{product.id})")
    int add(Orders orders);
}
