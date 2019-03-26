package com.pirate.form.basketball.dao.pirateWeb;

import com.pirate.form.basketball.entity.CommentPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommentDAO {

    CommentPO getCommentById(@Param("id") Integer id);
}
