package com.hj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.hj.pojo.ResObject;
import com.hj.pojo.Users;
import com.hj.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;








@Api(value = "users", description = "the users API")
@RestController
public class UserController {
 
	//通过byType形式，用来给指定的字段或方法注入所需的外部资源。
	@Autowired
	UserService userService;
	
	// static Map<Long, Users> users = Collections.synchronizedMap(new HashMap<Long, Users>());
	/*
	 * 新建用户 2019.4.10
	 */
	@ApiOperation(value = "新建用户" ,  notes="新建用户")
	@ApiResponses(value = { 
		        @ApiResponse(code = 200, message = "成功添加用户", response = Users.class),
		        @ApiResponse(code = 400, message = "错误", response = Error.class) })
    @RequestMapping(value= "/users",method=RequestMethod.POST, produces = { "application/json" })
	
	ResponseEntity<?> usersPost(
	    		@ApiParam(value = "sex,address不能为空，必须为有效字符"   ) @RequestBody Users user){
		
		try {
			Users u= null;
			u=userService.createUser(user);
			return new ResponseEntity<Users>(u,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	/*
	 * 删除用户 2019.4.11
	 */
	@ApiOperation(value = "删除用户", notes = "删除用户(测试)", response = Void.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功删除用户", response = Void.class),
			@ApiResponse(code = 400, message = "错误", response = Error.class),
			@ApiResponse(code = 500, message = "服务端内部错误", response = Error.class) })
	@RequestMapping(value = "/users/{id}", produces = { "application/json" }, method = RequestMethod.DELETE)

	ResponseEntity<?> usersIdDelete(@ApiParam(value = "用户ID", required = true) @PathVariable("id") Integer id) {
		try {
			userService.delUser(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/*
	 * 更新用户 2019.4.12
	 */
	
	@ApiOperation(value = "更新用户", notes = "更新用户 ", response = Users.class)
	  
	  @ApiResponses(value = {
	  
	  @ApiResponse(code = 200, message = "成功更新用户", response = Users.class),
	  
	  @ApiResponse(code = 400, message = "错误", response = Error.class) })
	  
	  @RequestMapping(value = "/users/{id}", produces = { "application/json" },
	  consumes = { "application/json" }, method = RequestMethod.PUT)
	  ResponseEntity<?> usersIdPut(
	  
		  @ApiParam(value = "用户ID",required=true ) @PathVariable("id") Integer id,
		  
		  @ApiParam(value = "" ,required=true ) @RequestBody Users user){ 
		try{
    		Users uOld = null;
    		uOld=userService.getUserById(id);
			
    		uOld.updateByObj(user);    			
			Users uNew = userService.updateUser(uOld);
			return new ResponseEntity<Users>(uNew,HttpStatus.OK);  			
				
    	}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
    	}
	  }
	/*
	 * 根据id获取单个用户信息 2019.4.12
	 */
	
	  @ApiOperation(value = "获取单个用户", notes = "得到指定用户的具体信息 ", response = Users.class)
	    @ApiResponses(value = { 
	        @ApiResponse(code = 200, message = "成功获取用户", response = Users.class),
	        @ApiResponse(code = 400, message = "没找到指定对象或错误", response = Error.class) })
	    @RequestMapping(value = "/users/{id}",
	        produces = { "application/json" }, 
	        method = RequestMethod.GET)
	    ResponseEntity<?> usersIdGet(
	@ApiParam(value = "用户ID",required=true ) @PathVariable("id")  Integer id){
			try {
				Users u = null;
				u = userService.getUserById(id);
				
				return new ResponseEntity<Users>(u, HttpStatus.OK);
				
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
			}    	
	    }
	  /*
		 * 获取用户列表 2019.4.12
		 *responseContainer	这些对象是有效的 "List", "Set" or "Map".，其他无效
		 */
	  @ApiOperation(value = "获取用户列表", notes = "获取所有用户 ", response = Users.class, responseContainer = "List")
	    @ApiResponses(value = { 
	        @ApiResponse(code = 200, message = "资源列表", response = Users.class),
	        @ApiResponse(code = 400, message = "错误", response = Error.class),
	        @ApiResponse(code = 500, message = "服务端内部错误", response = Error.class) })
	    @RequestMapping(value = "/users",produces = { "application/json" },   method = RequestMethod.GET)
	    ResponseEntity<?> usersGet(){
	    	try{
	    		return new ResponseEntity<List<Users>>(userService.listAllUser(),HttpStatus.OK);
	    	}catch(Exception e){    		
	    		e.printStackTrace();
				return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
	    	}
	    }
}
