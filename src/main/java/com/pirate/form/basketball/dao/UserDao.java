package com.pirate.form.basketball.dao;

import com.pirate.form.basketball.entity.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

    UserPO getUserById(@Param("id") Integer id);
}
