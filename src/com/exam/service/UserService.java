package com.exam.service;

import java.sql.SQLException;
import java.util.List;

import com.exam.model.Page;
import com.exam.model.SchoolCard;
import com.exam.model.User;

public interface UserService {
	
	
	public List<User> selectUserInfo(int id)throws SQLException;//用户---通过id查询信息
	public int updataInfo(User u)throws SQLException;//用户---更新信息
	public int updatePwd(int id,String oldpwd, String newpwd1, String newpwd2)throws SQLException;//用户--管理员---更改密码
	public List<SchoolCard>  selectCardById(int id )throws SQLException;//用户---查询账号信息
	public List<SchoolCard>  selectCard(String name,String stunumber)throws SQLException;
	public User selectUser(String stunumber) throws SQLException ;//更新用户信息


}
