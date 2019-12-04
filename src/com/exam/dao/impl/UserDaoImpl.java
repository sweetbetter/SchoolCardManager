package com.exam.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.jws.soap.SOAPBinding.Use;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.exam.dao.UserDao;
import com.exam.model.SchoolCard;
import com.exam.model.User;
import com.exam.util.CheckUtil;
import com.exam.util.JdbcUtil;
import com.sun.xml.internal.bind.v2.model.runtime.RuntimeNonElementRef;

import java.sql.Connection;


public class UserDaoImpl implements UserDao{
	


	

	
	//用户管理---->修改个人密码
	@Override
	public int updataPassword(int id,String newpwd) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.GetDataSource()); 	
		return queryRunner.update("update user set password=? where id=?", newpwd,id);
	}

	//用户管理---->通过ID查卡w
	@Override
	public List<SchoolCard> selectCardById(int id) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.GetDataSource()); 	
		List<SchoolCard> cards;
		cards=queryRunner.query("select * from schoolcard where id=?", new BeanListHandler<SchoolCard>(SchoolCard.class), id);
		if(cards.size()==0)
		{
			return null;
		}else
		return cards;
	}

	
	
}
