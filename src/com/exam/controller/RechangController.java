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

import com.exam.model.SchoolCard;
import com.exam.model.User;
import com.exam.service.RechangeService;
import com.exam.service.UserService;
import com.exam.service.impl.RechangeServiceImpl;
import com.exam.service.impl.UserServiceImpl;

@WebServlet("*.work")
public class RechangController extends HttpServlet{
	RechangeService  rs= new RechangeServiceImpl();
	UserService  us= new UserServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		//System.out.println("请求的路径是："+servletPath);
		String methodName=servletPath.substring(1, servletPath.length()-5);
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
	
	//查找
	protected void selectCard(HttpServletRequest request, HttpServletResponse response)
	{
		List<SchoolCard> list;
		String name=(String) request.getParameter("name");
		//String id=(String) request.getParameter("id");
		String stunumber=(String) request.getParameter("stunumber");
	//	System.out.println("传入姓名："+name+""+stunumber);
	
		try {
			list=us.selectCard(name, stunumber);
			if(list==null)
			{
				request.setAttribute("result",0);
				request.getRequestDispatcher("RechangeView/findCards.jsp").forward(request, response);
				return;
			}else if(list.size()==0)
			{
				request.setAttribute("result",1);
				request.getRequestDispatcher("RechangeView/findCards.jsp").forward(request, response);
				return;
			}else
			{
				request.setAttribute("card", list);
				request.setAttribute("searchMessage1",name);
				request.setAttribute("searchMessage2",stunumber);
				request.getRequestDispatcher("RechangeView/findCards.jsp").forward(request, response);
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
	
	
	//充值
	protected void rechange(HttpServletRequest request, HttpServletResponse response)
	{
		int result;
		String cardid=(String) request.getParameter("cardid");
		double money=Double.parseDouble(request.getParameter("money"));
		//System.out.println(cardid+""+money);
		try {
			result=rs.rechangeMoney(cardid, money);		
			if(result!=0)
			{	//跳转到查询那个卡号的
				request.setAttribute("rechangeMessage",1);
				//request.getRequestDispatcher("selectCard.work?cardid="+cardid).forward(request, response);
				request.getRequestDispatcher("RechangeView/findCards.jsp").forward(request, response);
				return;
			}else {
				request.setAttribute("rechangeMessage",0);
				request.getRequestDispatcher("RechangeView/findCards.jsp").forward(request, response);
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
