package com.exam.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.exam.dao.AdminDao;
import com.exam.dao.UserDao;
import com.exam.dao.impl.AdminDaoImpl;
import com.exam.dao.impl.UserDaoImpl;
import com.exam.model.Page;
import com.exam.model.SchoolCard;
import com.exam.model.User;
import com.exam.service.UserService;
import com.exam.util.CheckUtil;


public class UserServiceImpl implements UserService {
	UserDao ud=new UserDaoImpl();
	AdminDao ad=new AdminDaoImpl();
	
	//根据id查信息
	@Override
	public List<User> selectUserInfo(int id) throws SQLException {
		return ad.selectUser(id, null, null, null, null, null);
	}
	//更新信息 和管理员操作一样
	@Override
	public int updataInfo(User u) throws SQLException {
		return ad.updataUserInfo(u);
	}
	//修改密码
	@Override
	public int updatePwd(int id,String oldpwd, String newpwd1, String newpwd2) throws SQLException {
		int result;
		if(!newpwd1.equals(newpwd2))
		{
			//2表示两次密码不一致
			result=2;
			return result;
		}
		List<User> list=ad.selectUser(id, null, null, oldpwd, null, null);
		if(list.size()==0)
		{
			//0表示旧密码输入错误
			result=0;
			return result;
		}
		//1表示修改成功
		return 	ud.updataPassword(id, newpwd1);
	}
	
	//用户---查询账号信息
	@Override
	public List<SchoolCard> selectCardById(int id) throws SQLException {	
		return ud.selectCardById(id);
	}
	@Override
	public List<SchoolCard> selectCard(String name, String stunumber) throws SQLException {
		List<User> users=ad.selectUser(0, stunumber, name, null, null, null);
		if(CheckUtil.isEmpty(name)&&CheckUtil.isEmpty(stunumber))
		{
			return null;
		}
		if(users.size()==0) {
			return	null;	
		}
		else return selectCardById(users.get(0).getId());	
	}
	
	
	//根据学号查询用户。。。
	@Override
	public User selectUser(String stunumber) throws SQLException {
		List<User> users=ad.selectUser(0, stunumber, null, null, null, null);
		if(users.size()!=0)
		{
			return users.get(0);
		}else
			return null;
	
	}
	


	

}
