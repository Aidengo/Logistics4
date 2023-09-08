package com.logistics4.ssm.mapper;

import com.logistics4.ssm.pojo.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface OrderMapper {

    @Insert("insert into orderinfo values (#{shipments},#{shipnumber},#{path},#{consignee},#{consnumber},#{itemname})")
    int addOrder(@Param("shipments") String shipments,@Param("shipnumber") String shipnumber, @Param("path") String path,
                 @Param("consignee") String consignee, @Param("consnumber") String consnumber,@Param("itemname") String itemname);

    @Update("update orderinfo set path = concat(`path`, '->', #{path}) where `shipments` = #{shipments} and `consignee` = #{consignee}")
    int updatePath(@Param("path") String path,@Param("shipments") String shipments,@Param("consignee") String consignee);

    @Select("select * from orderinfo")
    List<Order> queryAllOrder();

    @Select("select * from orderinfo where shipments=#{shipments}")
    List<Order> queryAllOrderByaccount(@Param("shipments") String shipments);

    @Delete("delete from orderinfo where shipments=#{shipments} and consignee=#{consignee} and itemname=#{itemname}")
    int deleteOrder(@Param("shipments") String shipments, @Param("consignee") String consignee, @Param("itemname") String itemname);

}
