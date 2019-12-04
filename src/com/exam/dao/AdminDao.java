package com.exam.dao;

import java.sql.SQLException;
import java.util.List;

import com.exam.model.SchoolCard;
import com.exam.model.User;

public interface AdminDao {
		public User checkUser(String stunumber,String password,int indetity) throws SQLException;//登陆操作  完成
		//管理员登陆操作
		public int addUser(User u) throws SQLException;//增加用户信息  即注册用户    完成
		public int addSchoolCard(SchoolCard card)throws SQLException;//办理开卡业务 （即增加用户账户） 完成
		public int updataUserInfo(User u) throws SQLException;//修改用户信息   完成
		public int totalCount() throws SQLException;//查找总的用户数
		//根据任意条件（用户名，id，电话等等）查询对应用户信息（个人信息）  没有包括账户信息、需要要
		public List<User> selectUser(int id,String stunumber,String name,String passWord,String idcard,String phone)throws SQLException;
		
		public List<User> selectAll() throws SQLException;//查询所用用户信息和对应账户信息（进行分页）
		public List<User> selectStudentByPage(int currentPage)throws SQLException;
		public int deleteUserInfo(int id,String stunumber) throws SQLException ;//删除用户信息  通过表格中的id传过来的  或者直接输入学号 然后删除~
		public Long checkUnameExist(String uname) throws SQLException;
		public Long checkCardExist(String uname) throws SQLException;
}
