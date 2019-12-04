package com.exam.controller;

import java.io.IOException;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.model.Page;
import com.exam.model.SchoolCard;
import com.exam.model.User;
import com.exam.service.AdminService;
import com.exam.service.UserService;
import com.exam.service.impl.AdminServiceImpl;
import com.exam.service.impl.UserServiceImpl;



@WebServlet("*.do")
public class AdminController extends HttpServlet {
	UserService  us= new UserServiceImpl();
	AdminService  as= new AdminServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取想要请求的servlet
		String servletPath = request.getServletPath();
		//System.out.println("请求的路径是："+servletPath);
		String methodName=servletPath.substring(1, servletPath.length()-3);
		System.out.println("处理的对应的方法是："+methodName);	
		try {
			//根据methodName调用对应的函数
			//使用反射获取并调用方法
			Method method=getClass().getDeclaredMethod(methodName,  HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this,request, response);
		} catch (Exception e) {
			e.printStackTrace();	
		}	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	/*登陆账户
	 * 1.管理员登陆
	 * 2.用户登陆
	 * 3.充值员登陆 
	 * 一个单选按钮选择登陆模式 传入idtentiy
	 */
	/*学到的：
	 * request.getParameter 返回的都是String
	 * */
	protected void login(HttpServletRequest request, HttpServletResponse response)
	{		
			User result;
			HttpSession hs=request.getSession();
			String stunumber=request.getParameter("stunumber");
			String password=request.getParameter("password");
			int identity=Integer.parseInt( request.getParameter("identity"));
			//调用数据库查找
			try {
				result=as.checkLoing(stunumber, password, identity);
				if(result!=null)
				{
					//id传入session中  作为查询的其他东西
					hs.setAttribute("id",result.getId());
					hs.setAttribute("name",result.getName());
					//System.out.println(result.getName());
					if(identity==1) {		
					response.sendRedirect("AdminView/administrator.jsp");
					System.out.println("页面跳转管理员界面");
					}
					else if(identity==2)
					{
						response.sendRedirect("RechangeView/rechangeMain.jsp");
						System.out.println("页面跳转");	
					}
					else if(identity==3)
					{
						response.sendRedirect("UserView/user.jsp");
						System.out.println("页面跳转到用户界面");	
					}	
				}else
				{
					request.setAttribute("loginmessage",0);
					request.getRequestDispatcher("AdminView/login.jsp").forward(request, response);
					return;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
				
	}

	// 注销操作
	public void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate(); // 销毁session
		response.sendRedirect("/schoolCardManager/AdminView/login.jsp");
	}
	
	//注册账户
	protected void register(HttpServletRequest request, HttpServletResponse response)
	{
		int result;
		User u;
		String stunumber=request.getParameter("stunumber");
		String password=request.getParameter("password");
		int identity=Integer.parseInt(request.getParameter("identity"));
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String nation=request.getParameter("nation");
		String phone=request.getParameter("phone");
		String idcard=request.getParameter("idcard");
		u=new User(0,stunumber,password,name,sex,nation,phone,idcard,identity);
		try {
			result=as.addUser(u);		
			if(result!=0)
			{
				request.setAttribute("result", 1);
				request.getRequestDispatcher("AdminView/welcome.jsp").forward(request, response);
				return;
			}
			else
			{
				request.setAttribute("registermessage", 0);
				request.getRequestDispatcher("/schoolCardManager/AdminView/register.jsp").forward(request, response);
				return;
			}

		} catch (Exception e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//添加卡号
	protected void addCard(HttpServletRequest request, HttpServletResponse response)
	{
		int result;
		SchoolCard card;
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String idcard=request.getParameter("idcard");
		String cardid= request.getParameter("cardid");
		double money=Double.parseDouble(request.getParameter("money"));
		card=new SchoolCard(cardid,money);
		try {
			result=as.addCard(card,password, idcard,name);
			//System.out.println("控制层是否成功："+result);
			if(result!=0)
			{
				request.setAttribute("result", 1);
				request.getRequestDispatcher("AdminView/welcome.jsp").forward(request, response);
				return;
			}else
			{
				request.setAttribute("result", 0);
				request.getRequestDispatcher("AdminView/welcome.jsp").forward(request, response);
				return;
			}
		} catch (Exception e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	protected void selectAllInfo(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String, String> message = new HashMap<String, String>();
		User u=null;
		String name=(String)request.getParameter("name");
		String stunumber=(String)request.getParameter("stunumber");
		String idcard=(String)request.getParameter("idcard");
		String phone=(String)request.getParameter("phone");
		message.put("name", name);  
		message.put("stunumber", stunumber); 
		message.put("idcard", idcard); 
		message.put("phone", phone); 
		try {
			u=as.selectAllInfo(0, stunumber, name, null, idcard, phone);
			if(u!=null)
			{
				//不等于空查询成功
				request.setAttribute("message", message);
				request.setAttribute("user", u);
				//System.out.println("管理员查询某用户的所有信息"+u.toString());
				request.getRequestDispatcher("AdminView/selectInfo.jsp").forward(request, response);
				return;
			}
			if(u==null)
			{
				//查询条件有误..alert....
				request.setAttribute("failure", "1");
				request.getRequestDispatcher("AdminView/selectInfo.jsp").forward(request, response);
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
	protected void deleteUser(HttpServletRequest request, HttpServletResponse response)
	{
		int result;
		String stunumber=(String) request.getParameter("stunumber");
		System.out.println("获得的删除学号:"+stunumber);
		try {
			result=as.deleteUserInfo(stunumber);
			if(result==0)
			{
				request.setAttribute("result","0" );
				request.getRequestDispatcher("AdminView/deleteUser.jsp").forward(request, response);
				return;
			}else
			{
				request.setAttribute("result","1" );
				request.getRequestDispatcher("AdminView/deleteUser.jsp").forward(request, response);
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
	
	
	protected void selectUser(HttpServletRequest request, HttpServletResponse response)
	{	
		User u;
		String stunumber=(String)request.getParameter("updatestunumber");
		try {
			u=us.selectUser(stunumber);
			if(u!=null) {
			request.setAttribute("user",u);
			request.setAttribute("result", 3);
			request.getRequestDispatcher("AdminView/updateUser.jsp").forward(request, response);
			return;
			}
			else {
				request.setAttribute("result", 4);
				request.getRequestDispatcher("AdminView/updateUser.jsp").forward(request, response);
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
	
	protected void updateUser(HttpServletRequest request, HttpServletResponse response)
	{
 		int id=Integer.parseInt(request.getParameter("id"));
 		//System.out.println(id);
		String stunumber=request.getParameter("stunumber");
		String name=request.getParameter("name");	
		String sex=request.getParameter("sex");
		String nation=request.getParameter("nation");
		String phone=request.getParameter("phone");
		String idcard=request.getParameter("idcard");
		User u=new User(id,stunumber,name,sex,nation,phone,idcard);
		int result;
		try {
			result=us.updataInfo(u);
			if(result!=0)
			{
				//更新成功！
				request.setAttribute("result", 3);
				request.getRequestDispatcher("AdminView/deleteUser.jsp").forward(request, response);
				return;
			}else
			{
				request.setAttribute("result", 4);
				request.getRequestDispatcher("AdminView/deleteUser.jsp").forward(request, response);
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
	public void selectByPage(HttpServletRequest request, HttpServletResponse response)
	{
		int currentPage=Integer.parseInt(request.getParameter("currentPage"));
		System.out.println("当前页是："+currentPage);
		Page page=null;
		try {
			page=as.selectByPage(currentPage);
			if(page!=null)
			{
				System.out.println(page.toString());
				request.setAttribute("page", page);
				request.getRequestDispatcher("AdminView/selectAll.jsp").forward(request, response);
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
	
	protected void checkIsExist(HttpServletRequest request, HttpServletResponse response)
	{
		String stunumber=request.getParameter("stunumber");
		System.out.println(stunumber);
		Long result;
		try {
			 result=as.checkUnameExist(stunumber);
			 if(result==1)
			 {
				 response.getWriter().println(1);  //存在用户名 
			 }
			 else response.getWriter().println(0); //不存在
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	protected void checkCardIsExist(HttpServletRequest request, HttpServletResponse response)
	{
		String cardid=request.getParameter("cardid");
		System.out.println(cardid);
		Long result;
		try {
			 result=as.checkCardExist(cardid);
			 if(result==1)
			 {
				 response.getWriter().println(1);  //存在用户名 
			 }
			 else response.getWriter().println(0); //不存在
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
