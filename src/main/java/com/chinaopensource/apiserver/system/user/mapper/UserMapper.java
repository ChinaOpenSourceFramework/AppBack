package com.chinaopensource.apiserver.system.user.mapper;

import com.chinaopensource.apiserver.system.user.data.UserData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {

	int save(UserData user);

	int update(UserData user);

	void delete(Integer id);

	UserData findUserById(Integer id);

	UserData findUserByLoginName(String loginName);

	List<UserData> findAllUser();

}
