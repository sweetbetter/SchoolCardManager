package com.exam.service;

import java.sql.SQLException;

import com.exam.model.Page;
import com.exam.model.SchoolCard;
import com.exam.model.User;

public interface AdminService {
	public User checkLoing(String stunumber,String password,int identity)throws SQLException;//登陆
	public int addUser(User u)throws SQLException;//管理员--添加用户
	public int addCard(SchoolCard card,String password,String idcard,String name)throws SQLException;//管理员--添加账号
	public Long checkUnameExist(String uname) throws SQLException;
	public Long checkCardExist(String uname) throws SQLException;
	public User selectAllInfo(int id,String stunumber,String name,String passWord,String idcard,String phone)throws SQLException; //管理员---通过任意信息查询用户信息和卡号信息
	public int deleteUserInfo(String stunumber) throws SQLException ;//删除
	public Page selectByPage(int currentPage) throws SQLException ;
}
