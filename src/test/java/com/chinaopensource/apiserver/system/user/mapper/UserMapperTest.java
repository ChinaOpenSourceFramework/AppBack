package com.chinaopensource.apiserver.system.user.mapper;

import java.util.List;

import com.chinaopensource.apiserver.system.user.data.SaveUserReqData;
import com.chinaopensource.apiserver.system.user.data.UpdateUserReqData;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import com.chinaopensource.apiserver.ApiServerApplicationTests;
import com.chinaopensource.apiserver.common.util.encryption.EncryptionUtil;
import com.chinaopensource.apiserver.system.user.data.UserData;

public class UserMapperTest extends ApiServerApplicationTests{
	
	@Autowired  
    private UserMapper mapper;  
	
	//正常保存
	@Test
	public void testSave1() {
		UserData user = new UserData();
		user.setAddress("中国安徽亳州涡阳");
		user.setAge(25);
		user.setEmail("2452403243@qq.com");
		user.setLoginName("liqiwei1");
		user.setPhone("18356095840");
		user.setPhoto("c:/photo/a.jep");
		user.setUserName("李其伟");
		user.setPassword("123456");
		mapper.save(user);
	}
	/**
	 * 同名登录报异常
	 */
	@Test( expected = DuplicateKeyException.class )
	public void testSave2() {
		UserData user = new UserData();
		user.setAddress("中国安徽亳州涡阳");
		user.setAge(25);
		user.setEmail("2452403243@qq.com");
		user.setLoginName("liqiwei");
		user.setPhone("18356095840");
		user.setPhoto("c:/photo/a.jep");
		user.setUserName("李其伟");
		user.setPassword("123456");
		mapper.save(user);
	}
	
	/**
	 * 更新用户信息
	 */
	@Test
	public void testUpdate() {
		UserData user = new UserData();
		user.setId(1);
		user.setAddress("中国安徽亳州涡阳");
		user.setAge(5);
		user.setEmail("2452403243@qq.com");
		user.setPhone("18356095840");
		user.setPhoto("c:/photo/a.jep");
		user.setUserName("沙沙");
		mapper.update(user);
	}

	/**
	 * 通过用户ID删除
	 */
	@Test
	public void testDelete() {
		UserData user = mapper.findUserById(1);
		Assert.assertEquals(1, user.getId());
		Assert.assertNotNull(user);
		mapper.delete(1);
		user = mapper.findUserById(1);
		Assert.assertNull(user);
	}

	/**
	 * 通过用户Id查询用户信息
	 */
	@Test
	public void testFindUserById() {
		UserData user = mapper.findUserById(1);
		Assert.assertNotNull(user);
		Assert.assertEquals(1, user.getId());
	}

	/**
	 * 通过登录名查找用户
	 */
	@Test
	public void testFindUserByLoginName(){
		UserData user = mapper.findUserByLoginName("liqiwei");
		Assert.assertEquals("liqiwei", user.getLoginName()) ;
	}

	/**
	 * 查询所有用户信息
	 */
	@Test
	public void testFindAllUser() {
		List<UserData> userList = mapper.findAllUser();
		Assert.assertEquals(1, userList.size());
 	}

}
