package com.hj.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hj.pojo.Users;


@Repository
public interface UserDao extends JpaRepository<Users, Integer> {

	
	
	//根据ID获取用户
	Users getUserById(Integer id);
}