package com.chinaopensource.apiserver.system.user.service;

import com.chinaopensource.apiserver.system.user.data.SaveUserReqData;
import com.chinaopensource.apiserver.system.user.data.UpdateUserReqData;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chinaopensource.apiserver.ApiServerApplicationTests;
import com.chinaopensource.apiserver.common.exception.BaseException;

public class UserServiceTest extends ApiServerApplicationTests{

	@Autowired
	private UserService userService;
	
	//保存用户信息  添加用户
	@Test
	public void testSave() throws BaseException {
		SaveUserReqData user = new SaveUserReqData();
		user.setAddress("中国安徽亳州涡阳");
		user.setAge(25);
		user.setEmail("2452403243@qq.com");
		user.setLoginName("liqiwei1");
		user.setPhone("18356095840");
		user.setPhoto("c:/photo/a.jep");
		user.setUserName("李其伟");
		user.setPassword("123456");
		this.userService.save(user);
	}
	
	//保存用户信息  修改用户
	@Test
	public void testUpdate()  throws BaseException {
		UpdateUserReqData user = new UpdateUserReqData();
		user.setAddress("中国安徽亳州涡阳");
		user.setAge(5);
		user.setEmail("2452403243@qq.com");
		user.setPhone("18356095840");
		user.setPhoto("c:/photo/a.jep");
		user.setUserName("李其伟");
		user.setId(1);
		this.userService.update(user);
	}

	// 通过用户ID删除用户信息
	@Test
	public void testDeleteUserById() {
		Assert.assertNotNull(this.userService.findUserById(1));
		this.userService.deleteUserById(1);
		Assert.assertNull(this.userService.findUserById(1));
	}

	// 通过用户ID查找用户
	@Test
	public void testFindUserById() {
		Assert.assertEquals("liqiwei", this.userService.findUserById(1).getLoginName());
	}

	// 通过登录名查找用户
	@Test
	public void testFindUserByLoginName() {
		Assert.assertEquals("liqiwei", this.userService.findUserByLoginName("liqiwei").getLoginName());
	}

	// 查找所有用户
	@Test
	public void testFindAllUser() {
		Assert.assertEquals(1, this.userService.findAllUser().size());
	}

	// 登录人密码验证
	@Test
	public void testLoginValidate() {
		Assert.assertTrue(userService.loginValidate("liqiwei", "123456"));
	}

}
