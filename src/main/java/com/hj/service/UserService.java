package com.hj.service;

import java.util.List;

import com.hj.pojo.Users;


public interface UserService {
	
	Users createUser(Users user);
	void delUser(Integer id);
	Users getUserById(Integer id);
	Users updateUser(Users user);
	List<Users> listAllUser();
}
