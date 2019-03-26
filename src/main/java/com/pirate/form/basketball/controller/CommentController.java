package com.pirate.form.basketball.controller;

import com.pirate.form.basketball.entity.ResultVO;
import com.pirate.form.basketball.entity.UserPO;
import com.pirate.form.basketball.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("comment/{id}")
    public ResultVO<UserPO> getCommentById(@PathVariable(value = "id") Integer id) {
        return ResultVO.success(commentService.getCommentById(id));
    }
}
