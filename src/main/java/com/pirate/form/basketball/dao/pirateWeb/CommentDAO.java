package com.pirate.form.basketball.dao.pirateWeb;

import com.pirate.form.basketball.entity.CommentPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface CommentDAO {

    @Transactional(propagation = Propagation.SUPPORTS)
    CommentPO getCommentById(@Param("id") Integer id);
}
