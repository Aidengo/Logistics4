package com.logistics4.ssm.mapper;

import com.logistics4.ssm.pojo.Warehouse;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WarehouseMapper {

    @Select("select * from warehouse")
    List<Warehouse> queryWarehouse();

    @Insert("insert into warehouse values (#{area},#{name},#{size},#{linkman},#{phonenumber})")
    int addWarehouse(@Param("area") String area,@Param("name") String name, @Param("size") double size,
                           @Param("linkman") String linkman, @Param("phonenumber")  String phonenumber);

    @Delete("delete from warehouse where name=#{name}")
    int deleteWarehouse(@Param("name") String name);

}
