package com.exam.service.impl;

import java.sql.SQLException;

import com.exam.dao.RechangeDao;
import com.exam.dao.UserDao;
import com.exam.dao.impl.RechangeDaoImpl;
import com.exam.dao.impl.UserDaoImpl;
import com.exam.service.RechangeService;

public class RechangeServiceImpl implements RechangeService{
	RechangeDao rd=new RechangeDaoImpl();
	//充值操作   充值员
		@Override
		public int rechangeMoney(String cardid, double money) throws SQLException {
			
			return rd.rechange(cardid, money);
		}
		
}
