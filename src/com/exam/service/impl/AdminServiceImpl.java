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
import com.exam.service.AdminService;

public class AdminServiceImpl implements AdminService {
	AdminDao ad=new AdminDaoImpl();
	UserDao ud=new UserDaoImpl();
	@Override
	public User checkLoing(String stunumber, String password, int identity) throws SQLException {
		return 	ad.checkUser(stunumber, password, identity);
	}
	@Override
	public int addUser(User u) throws SQLException {
		return 	ad.addUser(u);
	}
	
	@Override
	public int addCard(SchoolCard card, String password, String idcard,String name) throws SQLException {
		int result;
		//0表示输入信息有误 1表示插入成功
		//通过查找idcard和password和name查出对应的id
		List<User> list=ad.selectUser(0,null, name, password, idcard, null);
		//System.out.println("开卡时是否找到"+list.size());
		//将id设置给card
		if(list.size()==0) 
		{
			result=0;
			return result;
		}
		if(list.size()!=0)
		for(User u:list)
		{
			card.setId(u.getId()); 
		}	
		//插入Card
		result=ad.addSchoolCard(card);
		//System.out.println("添加卡号成功的DAO层："+result);
		return result;
	}
	
	//通过任意条件查询所有信息 管理员	
		@Override
		public User selectAllInfo(int id,String stunumber,String name,String passWord,String idcard,String phone) throws SQLException {
			User u=null;
			List<SchoolCard> cards;
			List<User> users=ad.selectUser(id, stunumber, name, passWord, idcard, phone);
			//1.查询到对应的用户信息  id这里可能有问题 可能要设置为0	
			if(users.size()!=0)
			{
				u=users.get(0);	
			}
			//2.查到的user不为null  通过id查卡号
			if(u!=null)
			{
				cards=ud.selectCardById(u.getId());
				u.setCard(cards);
			}
			return u;
		}
		//管理员  删除信息
		@Override
		public int deleteUserInfo(String stunumber) throws SQLException{
			int id=0;
			List<User> users=ad.selectUser(0, stunumber, null, null, null, null);
			if(users.size()!=0)
			{
				id=users.get(0).getId();
				return	ad.deleteUserInfo(id,stunumber);
			}else {
				return 0;
			}
		 
		}
		@Override
		public Long checkUnameExist(String uname) throws SQLException {
			UserDao ud=new UserDaoImpl();	
			Long result= ad.checkUnameExist(uname);
			return result;
		}
		
		@Override
		public Long checkCardExist(String uname) throws SQLException {
			UserDao ud=new UserDaoImpl();	
			Long result= ad.checkCardExist(uname);
			return result;
		}
		/*
		 * 查询所用用户信息和对应账户信息。（进行分页）
			1.	查询用户信息ByPage List<User> 
			2.	用查到的List遍历里面的id 通过id查找账号信息 并封装到list User中…
			3.	创建PageBean…封装分页信息..
			4.	传过去 显示..
		 * */ 
		//分页显示~！
		@Override
		public Page selectByPage(int currentPage) throws SQLException {
			Page page=new Page();
			int pageSize=3;			//可修改---改的时候数据库也要修改
			page.setCurrentPage(pageSize);
			page.setCurrentPage(currentPage);
			List<User> users;
			List<SchoolCard> cards;
			users=ad.selectStudentByPage(currentPage);
			//遍历users 查对应的卡号
			for (User u : users) {
				cards=ud.selectCardById(u.getId());
				u.setCard(cards);
			}
			page.setUsers(users);
			//查找总的记录数
			int count=ad.totalCount();
			page.setTotalSize(count);
			//计算总的页数
			page.setTotalPage(count%pageSize==0?count/pageSize:(count/pageSize)+1);
			return page;
		}
		
}
