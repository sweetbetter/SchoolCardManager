package com.exam.dao;

import java.sql.SQLException;

public interface RechangeDao {
	//充值员登陆操作
	//public List<SchoolCard> selectCard(String name,String stunumber) throws SQLException;//查询用户账户 通过用户的账号查找开的卡号   没用。。写错了
	public int rechange(String cardid,double money) throws SQLException;//通过校园卡号完成充值 操作  完成充值操作充值操作 完成
}
