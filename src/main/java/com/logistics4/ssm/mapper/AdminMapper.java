package com.logistics4.ssm.mapper;

import com.logistics4.ssm.pojo.Admin;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AdminMapper {

    @Select("select * from admin where account=#{account} and password=#{password}")
    Admin selectAdminByAP(@Param("account") String account, @Param("password") String password);

    @Insert("insert into admin values (#{account},#{password})")
    int addAdmin(@Param("account") String account, @Param("password") String password);


    @Update("update admin set password=#{password} where account=#{account}")
    int updateUserPassword(@Param("password") String password,@Param("account") String account);

    @Select("select * from manager where account=#{account} and password=#{password}")
    Admin selectManagerByAP(@Param("account") String account, @Param("password") String password);
}
