package com.exam.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.exam.dao.AdminDao;
import com.exam.model.SchoolCard;
import com.exam.model.User;
import com.exam.util.CheckUtil;
import com.exam.util.JdbcUtil;

public class AdminDaoImpl implements AdminDao {
	@Override
	public User checkUser(String stunumber, String password, int identity) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.GetDataSource()); 	
		User result=null;
		result= queryRunner.query("select * from user where stunumber = ? and password=? and identity=? ", 
				new BeanHandler<User>(User.class),stunumber,password,identity);
	//	System.out.println("登陆的结果："+result.toString());
		return result;
	}	
	
	@Override
	public int addUser(User u) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.GetDataSource()); 	
		return queryRunner.update("insert into user value(?,?,?,?,?,?,?,?,?)",null,u.getStunumber(),u.getPassword(),u.getName(),u.getSex(),u.getNation(),u.getPhone(),u.getIdcard(),u.getIdentity());

	}
	
	@Override
	public List<User> selectAll() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.GetDataSource()); 	
		String sql="select * from user,schoolcard where user.id=schoolcard.id";
		//queryRunner.query(sql, rsh)
		List<User> users=  queryRunner.query(sql,new ResultSetHandler<List<User>>() {
			@Override
			public List<User> handle(ResultSet arg0) throws SQLException {
			
				return null;
			}
			
		});
		return null;
	}

	

	@Override
	public int deleteUserInfo(int id,String stunumber) throws SQLException  {
		Connection conn=JdbcUtil.getConn();
		conn.setAutoCommit(false);
		QueryRunner queryRunner = new QueryRunner(); 	
		int result=1;
		String sql="delete from user where stunumber=?";
		String sql2="delete from schoolcard where id=?";
		try {
			queryRunner.update(conn,sql,stunumber);
			queryRunner.update(conn,sql2,id);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			result=0;
		}
		return result;
	}


	@Override
	public int addSchoolCard(SchoolCard card) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.GetDataSource()); 	
		return 	queryRunner.update("insert into schoolcard value(?,?,?,?,?)",card.getId(),card.getCardid(),card.getMoney(),card.getLastadd(),card.getConsume());
	}

	//分页查询 可能要修改... 3
	@Override
	public List<User> selectStudentByPage(int currentPage) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.GetDataSource()); 		
		return queryRunner.query("select * from user limit ? offset ?", new BeanListHandler<User>(User.class),3,(currentPage-1)*3);
	}
	//模糊查询 根据不同条件查询
		@Override
		public List<User> selectUser(int id,String stunumber, String name,String passWord, String idcard, String phone) throws SQLException {
			QueryRunner queryRunner = new QueryRunner(JdbcUtil.GetDataSource()); 	
			String sql = "select * from user where 1=1 ";
			List<String> list = new ArrayList<String> ();
			List<User> users=null;
			if(id!=0){
				sql = sql + " and id = ?";
				list.add(""+id);
			}
			if(!CheckUtil.isEmpty(stunumber)){
				sql = sql + " and stunumber = ?";
				list.add(stunumber);
			}
			if(!CheckUtil.isEmpty(name)){
			/*	sql = sql + " and name like ?";
				list.add("%"+name+"%");*/
				sql = sql + " and name = ?";
				list.add(name);
			}
			if(!CheckUtil.isEmpty(passWord)){
				sql = sql + " and passWord= ?";
				list.add(passWord);
			}
			if(!CheckUtil.isEmpty(idcard)){
				sql = sql + " and idcard = ?";
				list.add(idcard);
			}
			if(!CheckUtil.isEmpty(phone)){
				sql = sql + " and phone = ?";
				list.add(phone);
			}
			users=queryRunner.query(sql , new BeanListHandler<User>(User.class),list.toArray());	
			System.out.println("users"+users);
			return users;
		}

		@Override
		public int updataUserInfo(User u ) throws SQLException {
			QueryRunner queryRunner = new QueryRunner(JdbcUtil.GetDataSource()); 	
			return queryRunner.update("update user set stunumber=?,name=?,sex=?,nation=?,phone=?,idcard=? where id=?",u.getStunumber(),u.getName(),u.getSex(),u.getNation(),u.getPhone(),u.getIdcard(),u.getId());
		}
		@Override
		public Long checkUnameExist(String uname) throws SQLException {
			QueryRunner queryRunner = new QueryRunner(JdbcUtil.GetDataSource()); //查询单个对象
			Long result= (Long)queryRunner.query("select count(*) from user where stunumber = ? ", new ScalarHandler(),uname);
			//System.out.println(u.getUid()+"---"+u.getPwd());
			return result;
			
		}
		@Override
		public Long checkCardExist(String uname) throws SQLException {
			QueryRunner queryRunner = new QueryRunner(JdbcUtil.GetDataSource()); //查询单个对象
			Long result= (Long)queryRunner.query("select count(*) from schoolcard where cardid = ? ", new ScalarHandler(),uname);
			//System.out.println(u.getUid()+"---"+u.getPwd());
			return result;
			
		}
		// 查找总的用户数
		@Override
		public int totalCount() throws SQLException {
			QueryRunner queryRunner = new QueryRunner(JdbcUtil.GetDataSource()); 
			Long result=(long) 0;
			result=(Long)queryRunner.query("select count(*) from user", new ScalarHandler());
			return result.intValue();
		}
		
}
