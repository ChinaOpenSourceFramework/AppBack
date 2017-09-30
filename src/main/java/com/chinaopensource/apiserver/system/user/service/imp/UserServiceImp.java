package com.chinaopensource.apiserver.system.user.service.imp;

import java.util.List;

import com.chinaopensource.apiserver.system.user.data.SaveUserReqData;
import com.chinaopensource.apiserver.system.user.data.UpdateUserReqData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinaopensource.apiserver.common.exception.BaseException;
import com.chinaopensource.apiserver.common.exception.HasException;
import com.chinaopensource.apiserver.common.exception.NoHasException;
import com.chinaopensource.apiserver.common.util.encryption.EncryptionUtil;
import com.chinaopensource.apiserver.system.user.data.UserData;
import com.chinaopensource.apiserver.system.user.mapper.UserMapper;
import com.chinaopensource.apiserver.system.user.service.UserService;

@Component("userService")
public class UserServiceImp implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void save(SaveUserReqData user) throws BaseException {
		this.noExistValidate(user.getLoginName());
		UserData userData = new UserData();
		userData.setAddress(user.getAddress());
		userData.setAge(user.getAge());
		userData.setEmail(user.getEmail());
		userData.setLoginName(user.getLoginName());
		userData.setUserName(user.getUserName());
		//进行加密
		userData.setPassword(EncryptionUtil.getHash(user.getPassword(),"MD5"));
		userData.setPhone(user.getPhone());
		userData.setPhoto(user.getPhoto());
		userMapper.save(userData);
	}

	@Override
	public void update(UpdateUserReqData user) throws BaseException {
		UserData userData = new UserData();
		userData.setId(user.getId());
		userData.setAddress(user.getAddress());
		userData.setAge(user.getAge());
		userData.setEmail(user.getEmail());
		userData.setUserName(user.getUserName());
		userData.setPhone(user.getPhone());
		userData.setPhoto(user.getPhoto());
		userMapper.update(userData);
	}
	
	@Override
	public void deleteUserById(Integer id) {
		userMapper.delete(id);
	}

	@Override
	public UserData findUserById(Integer id) {
		return userMapper.findUserById(id);
	}

	@Override
	public UserData findUserByLoginName(String loginName) {
		return userMapper.findUserByLoginName(loginName);
	}

	@Override
	public List<UserData> findAllUser() {
		return userMapper.findAllUser();
	}

	@Override
	public boolean loginValidate(String loginName, String password) {
		String pwd = this.findUserByLoginName(loginName).getPassword();
		return EncryptionUtil.getHash(password, "MD5").equals(pwd);
	}

	/*
	 * 登录名不存在抛出异常
	 * loginName   登录名
	 */
	private void existValidate(String loginName) throws BaseException{
		UserData u= this.findUserByLoginName(loginName);
		if(u==null){
			throw new NoHasException(loginName);
		}
	}
	/*
	 * 登录名存在抛出异常
	 * loginName   登录名
	 */
	private void noExistValidate(String loginName) throws BaseException{
		//登录名是否存在
		UserData u= this.findUserByLoginName(loginName);
		if(u!=null){
			throw new HasException(loginName);
		}
	}

}
