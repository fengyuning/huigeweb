package com.pirate.form.basketball.controller;

import com.pirate.form.basketball.entity.ResultVO;
import com.pirate.form.basketball.entity.UserPO;
import com.pirate.form.basketball.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("test")
    public String test() {
        return "冯誉宁测试网页";
    }

    @GetMapping("user/{id}")
    public ResultVO<UserPO> getUserById(@PathVariable(value = "id") Integer id) {
        return ResultVO.success(userService.getUserById(id));
    }


    @GetMapping("test/user")
    public ResultVO<UserPO> getUserById() {
        UserPO user = new UserPO();
        user.setId(222);
        user.setName("无敌海贼222");
        return ResultVO.success(user);
    }
}
