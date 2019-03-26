package com.pirate.form.basketball.service.impl;

import com.pirate.form.basketball.dao.userDb.UserDao;
import com.pirate.form.basketball.entity.UserPO;
import com.pirate.form.basketball.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserPO getUserById(Integer id) {
        return userDao.getUserById(id);
    }
}
