package com.exam.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.exam.model.SchoolCard;
import com.exam.model.User;
import com.exam.service.UserService;
import com.exam.service.impl.UserServiceImpl;

import javafx.scene.control.Alert;

@WebServlet("*.go")
public class UserController extends HttpServlet {
	UserService  us= new UserServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		//System.out.println("请求的路径是："+servletPath);
		String methodName=servletPath.substring(1, servletPath.length()-3);
		//System.out.println("处理的对应的方法是："+methodName);	
		try {
			Method method=getClass().getDeclaredMethod(methodName,  HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this,request, response);
		} catch (Exception e) {
			e.printStackTrace();	
		}	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	//通过id查询用户信息
	protected void 	selectuser(HttpServletRequest request, HttpServletResponse response)
	{		
		List<User> list;
		HttpSession hs=request.getSession();
		int id=(int) hs.getAttribute("id");
		try {
			list=us.selectUserInfo(id);
			if(list.size()!=0)
			{
				request.setAttribute("info",list);
				request.getRequestDispatcher("UserView/userInfo.jsp").forward(request, response);
				return;
			}else
			{	
				request.setAttribute("result",0);
				request.getRequestDispatcher("/schoolCardManager/AdminView/welcome.jsp").forward(request, response);
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	protected void 	edit(HttpServletRequest request, HttpServletResponse response)
	{		
		List<User> list;
		HttpSession hs=request.getSession();
		int id=(int) hs.getAttribute("id");
		try {
			list=us.selectUserInfo(id);
			request.setAttribute("list",list);
			request.getRequestDispatcher("UserView/edit.jsp").forward(request, response);
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void 	update(HttpServletRequest request, HttpServletResponse response)
	{		
		HttpSession hs=request.getSession();
		int id=(int)hs.getAttribute("id");
		//System.out.println(id);
		String stunumber=request.getParameter("stunumber");
		String name=request.getParameter("name");	
		String sex=request.getParameter("sex");
		String nation=request.getParameter("nation");
		String phone=request.getParameter("phone");
		String idcard=request.getParameter("idcard");
		//System.out.println(nation);
		User u=new User(id,stunumber,name,sex,nation,phone,idcard);
		//System.out.println(u.toString());
		int result;
		try {
			
			result=us.updataInfo(u);
			if(result!=0)
			{
				request.setAttribute("result", 0);
				request.getRequestDispatcher("selectuser.go").forward(request, response);
				return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	protected void updatePwd(HttpServletRequest request, HttpServletResponse response)
	{		
		System.out.println("调用修改密码");
		HttpSession hs=request.getSession();
		int id=(int)hs.getAttribute("id");
		String oldpwd=request.getParameter("oldpwd");
		String newpwd1=request.getParameter("newpwd1");
		String newpwd2=request.getParameter("newpwd2");
		try {
			int result=us.updatePwd(id,oldpwd, newpwd1, newpwd2);
			if(result==1)
			{
				//System.out.println("修改密码成功！");
				request.setAttribute("result", 1);
				request.getRequestDispatcher("/AdminView/welcome.jsp").forward(request, response);
				return;
			}else {
				request.setAttribute("result", 0);
				request.getRequestDispatcher("/AdminView/welcome.jsp").forward(request, response);
				return;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	protected void selectCard(HttpServletRequest request, HttpServletResponse response)
	{		
		HttpSession hs=request.getSession();
		int id=(int)hs.getAttribute("id");
		List<SchoolCard> cards;
		try {
			cards=us.selectCardById(id);
			/*for(SchoolCard c:cards) {
				System.out.println(c.toString()); 
			}*/
			if(cards.size()==0)//没有卡号
			{
				request.setAttribute("result", 0);
				request.getRequestDispatcher("/UserView/selectCard.jsp").forward(request, response);
				return;
			}
			if(cards.size()!=0)
			{
				request.setAttribute("cards",cards);
				request.getRequestDispatcher("/UserView/selectCard.jsp").forward(request, response);
				return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
