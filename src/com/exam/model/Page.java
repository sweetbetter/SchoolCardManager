package com.exam.model;

import java.sql.SQLException;
import java.util.List;

import com.exam.dao.UserDao;
import com.exam.dao.impl.UserDaoImpl;

public class Page {
	private int currentPage;//当前页
	private int totalPage;//总页数
	private int pageSize;//每页记录数
	private int totalSize;//总的记录数
	private List<User> users;//当前页的用户集合
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Page(int currentPage, int totalPage, int pageSize, int totalSize, List<User> users) {
		super();
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.pageSize = pageSize;
		this.totalSize = totalSize;
		this.users = users;
	}
	

	
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Page [currentPage=" + currentPage + ", totalPage=" + totalPage + ", pageSize=" + pageSize
				+ ", totalSize=" + totalSize + ", users=" + users + "]";
	}

}
