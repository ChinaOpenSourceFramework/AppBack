package com.chinaopensource.apiserver.system.login.controller;

import com.chinaopensource.apiserver.common.controller.BaseResponse;
import com.chinaopensource.apiserver.system.login.data.SignInReqData;
import com.chinaopensource.apiserver.system.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 用户登录相关操作
 */
@RestController
@RequestMapping("/system/login/")
@Api(description = "登录管理")
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	@ApiOperation(value="获取token", notes="登录系统获取token值")
	@RequestMapping(value = "signIn", method = RequestMethod.POST)
	public String signIn(@Valid @RequestBody SignInReqData signInReqData){
		if(userService.loginValidate(signInReqData.getLoginName(), signInReqData.getPassword())){
			LOGGER.info("用户{}登陆成功",signInReqData.getLoginName());
			return BaseResponse.getSuccessJson();
		}else{
			LOGGER.info("用户{}登陆失败",signInReqData.getLoginName());
			return BaseResponse.getErrorJson(1);
		}
	}
	
	@ApiOperation(value="删除token", notes="退出系统删除token")
	@RequestMapping(value = "signOut", method = RequestMethod.POST)
	public String signOut(String loginName){
		LOGGER.info("用户{}退出成功",loginName);
		return BaseResponse.getSuccessJson();
	}
	
}
