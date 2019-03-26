package com.pirate.form.basketball.service.impl;

import com.pirate.form.basketball.dao.pirateWeb.CommentDAO;
import com.pirate.form.basketball.entity.CommentPO;
import com.pirate.form.basketball.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public CommentPO getCommentById(Integer id) {
        return commentDAO.getCommentById(id);
    }
}
