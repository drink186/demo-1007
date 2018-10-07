package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
	private UserDao userDao;
	@Override
	public User findByAccount(String account) {
		return userDao.findByAccount(account);
	}

}
