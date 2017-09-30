package com.chinaopensource.apiserver.system.user.controller;

import javax.validation.Valid;

import com.chinaopensource.apiserver.system.user.data.SaveUserReqData;
import com.chinaopensource.apiserver.system.user.data.UpdateUserReqData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chinaopensource.apiserver.common.controller.BaseResponse;
import com.chinaopensource.apiserver.common.exception.BaseException;
import com.chinaopensource.apiserver.system.user.data.UserData;
import com.chinaopensource.apiserver.system.user.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户相关接口
 */
@RestController
@RequestMapping("/system/user/")
@Api(description = "用户管理")
public class UserController {

	@Autowired
	private UserService userService;
	
	@ApiOperation(value="保存用户信息", notes="添加用户信息")
	@RequestMapping(value = "saveUser", method = RequestMethod.POST)
	public String saveUser(@Valid @RequestBody SaveUserReqData user) throws BaseException{
		this.userService.save(user);
		return BaseResponse.getSuccessJson();
	}
	
	@ApiOperation(value="修改用户信息", notes="修改用户信息")
	@RequestMapping(value = "updateUser", method = RequestMethod.PUT)
	public String updateUser(@Valid @RequestBody UpdateUserReqData user) throws BaseException{
		this.userService.update(user);
		return BaseResponse.getSuccessJson();
	}

	@ApiOperation(value="删除用户信息", notes="删除用户信息")
	@RequestMapping(value = "deleteUserById", method = RequestMethod.DELETE)
	public String deleteUserById(Integer id){
		this.userService.deleteUserById(id);
		return BaseResponse.getSuccessJson();
	}
	
	@ApiOperation(value="通过ID用户信息", notes="通过ID用户信息")
	@RequestMapping(value = "findUserById", method = RequestMethod.GET)
	public String findUserById(Integer id){
		return BaseResponse.getSuccessJson(this.userService.findUserById(id));
	}
	
	@ApiOperation(value="通过登录名获取用户信息", notes="通过登录名获取用户信息")
	@RequestMapping(value = "findUserByLoginName", method = RequestMethod.GET)
	public String findUserByLoginName(String loginName){
		return BaseResponse.getSuccessJson(this.userService.findUserByLoginName(loginName));
	}
	
	@ApiOperation(value="查找所有用户", notes="查找所有用户信息")
	@RequestMapping(value = "findAllUser", method = RequestMethod.GET)
	public String findAllUser(){
		return BaseResponse.getSuccessJson(this.userService.findAllUser());
	}
}
