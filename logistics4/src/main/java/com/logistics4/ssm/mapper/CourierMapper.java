package com.logistics4.ssm.mapper;

import com.logistics4.ssm.pojo.Courier;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface CourierMapper {

    @Select("select * from courier")
    List<Courier> queryAllCourier();

    @Insert("insert into courier values (#{name},#{sex},#{age},#{phonenumber})")
    int addCourier(@Param("name") String name,@Param("sex")String sex ,@Param("age")Integer age,@Param("phonenumber")String phonenumber);

    @Delete("delete from courier where name=#{name}")
    int deleteCourierByName(@Param("name") String name);

    @Update("update courier set name=#{newname},sex=#{sex},age=#{age},phonenumber=#{phonenumber} where name=#{name}")
    int updateCourierInfo(@Param("newname") String newname,@Param("sex")  String sex,@Param("age")  int age,
                           @Param("phonenumber") String phonenumber,@Param("name") String name);
}
