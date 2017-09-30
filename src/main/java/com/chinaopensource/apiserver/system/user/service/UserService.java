package com.chinaopensource.apiserver.system.user.service;

import java.util.List;

import com.chinaopensource.apiserver.system.user.data.SaveUserReqData;
import com.chinaopensource.apiserver.system.user.data.UpdateUserReqData;
import org.springframework.transaction.annotation.Transactional;

import com.chinaopensource.apiserver.common.exception.BaseException;
import com.chinaopensource.apiserver.system.user.data.UserData;

@Transactional
public interface UserService {

	/**
	 * 保存用户
	 * @param user
	 * @return
	 * @throws BaseException 
	 */
	void save(SaveUserReqData user) throws BaseException;

	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 * @throws BaseException 
	 */
	void update(UpdateUserReqData user) throws BaseException;
	/**
	 * 通过ID删除用户
	 * @param id
	 */
	void deleteUserById(Integer id);
	
	/**
	 * 通过id查找用户
	 * @param id
	 * @return
	 */
	UserData findUserById(Integer id);

	/**
	 * 查找所有用户
	 * @return
	 */
	List<UserData> findAllUser();
	
	/**
	 * 登录用户验证
	 * @param loginName
	 * @param password
	 * @return
	 */
	boolean loginValidate(String loginName,String password);

	/**
	 * 通过登录名称查找用户信息
	 * @param loginName
	 * @return
	 */
	UserData findUserByLoginName(String loginName);
}
