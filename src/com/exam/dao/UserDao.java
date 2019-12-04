package com.exam.dao;

import java.sql.SQLException;
import java.util.List;

import com.exam.model.SchoolCard;
import com.exam.model.User;



public interface UserDao {

	//用户登陆操作
	public int updataPassword(int id,String newpwd) throws SQLException;//修改登陆信息（改密码）-----通过旧密码更改  完成
	//修改个人信息--------------同上管理员修改用户信息操作   完成
    public List<SchoolCard> selectCardById(int id)throws SQLException; //查询个人账户信息（帐户余额、今日消费、末次充值情况） ------------同上充值员操作   完成
}
