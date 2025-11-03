package com.ssm.dao;


import com.ssm.domain.Product;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * @Author j
 * @Date 2019/9/7 19:17
 * @Version 1.0
 */
public interface ProductDao {


    @Select("select * from product")
    @Results({
            @Result(column = "departureTime", property = "departureTime",jdbcType = JdbcType.TIMESTAMP)
    })
    List<Product> getList();

    /**
     * 使用序列自增
     * @param product
     * @return
     */
    @SelectKey(statement = "select PRODUCT_SEQ.NEXTVAL from dual",keyProperty = "id",before = true,resultType = Integer.class)
    @Insert("insert into product(id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)values(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    int add(Product product);

    @Update("update product set productNum = #{productNum},productName=#{productName},cityName=#{cityName},departureTime=#{departureTime},productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus} where id = #{id}")
    int update(Product product);

    @Select("select * from product where id = #{id}")
    Product getById(Integer id);

    @Delete("delete from product where id = #{id}")
    int delete(Integer id);

    @Select("select count(1) from product")
    int getCount();

    @Select("select t.* from (select rownum rn,p.* from product p where rownum <= #{end}) t where t.rn >= #{start}")
    //@Select("select t.* from (select rownum rn,t.* from (select p.* from product p order by p.PRODUCTPRICE desc ) t where rownum <= #{end} ) t2 where t2.rn>= #{start}")
    List<Product> pageList(@Param("start") int start, @Param("end") int end);
}
