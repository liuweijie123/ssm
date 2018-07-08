package com.lwj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwj.bean.User;
import com.lwj.mapping.UserMapper;

@Service("userService")
public class UserService{
	
	@Autowired
	private UserMapper userMapper;

	public User getUserById(int userId) {
		return userMapper.selectByPrimaryKey(userId);
	}
	
	@Transactional
	public void deleteById(){
		userMapper.deleteByPrimaryKey(1);
		int i = 2/0;
	}

	public List<User> list() {
		return userMapper.selectAll();
	}
	
}
