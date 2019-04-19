package com.hj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hj.dao.UserDao;
import com.hj.pojo.Users;



@Service
public  class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	//新增用户
	@Transactional
	@Override
	public Users createUser(Users user) {
		// TODO Auto-generated method stub
		userDao.save(user);
		return user;
	}
	//删除用户
	@Transactional
	@Override
	public void delUser(Integer id) {
		// TODO Auto-generated method stub
		
		userDao.deleteById(id);
	}
	//根据id获取用户
	@Transactional
	@Override
	public Users getUserById(Integer id) {
		// TODO Auto-generated method stub
		Users u =userDao.getUserById(id);
		return u;
	}
	//更新用户
	@Override
	public Users updateUser(Users user) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}
	//查询所有用户
	@Override
	public List<Users> listAllUser() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}
	
	
	

}
