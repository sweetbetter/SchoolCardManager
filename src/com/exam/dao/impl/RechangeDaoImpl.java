package com.exam.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.exam.dao.RechangeDao;
import com.exam.util.JdbcUtil;

public class RechangeDaoImpl implements RechangeDao{
	@Override
	public int rechange(String cardid,double money) throws SQLException {	
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.GetDataSource()); 	
		return queryRunner.update("update schoolcard set money=money+?,lastadd=? where cardid=?",money,money,cardid);
	}

	

	//充值员 ----  查询卡号 为充值做准备
	/*@Override
	public List<SchoolCard> selectCard(String name,String stunumber) throws SQLException {
	String sql="select * from schoolcard where 1=1";
	List<String> list = new ArrayList<String> ();
	//如果都空 1=2
	if(CheckUtil.isEmpty(name)&&CheckUtil.isEmpty(stunumber))
	{
		sql=sql+" and 1=2";
	}
	if(!CheckUtil.isEmpty(name))
	{
		sql=sql+" and name=?";
		list.add(name);
	}
	if(!CheckUtil.isEmpty(stunumber))
	{
		sql=sql+" and stunumber=?";
		list.add(stunumber);
	}
	System.out.println(sql);
	return queryRunner.query(sql, new BeanListHandler<SchoolCard>(SchoolCard.class),list.toArray());
	}*/

}
