package com.exam.model;

import java.util.List;

public class User {
	private int id;
	private String stunumber;
	private String password;
	private String name;
	private String sex;
	private String nation;
	private String phone;
	private String idcard;
	private int identity;
	private List<SchoolCard> card;
	
	public User(int id, String stunumber, String name, String sex, String nation, String phone, String idcard) {
		super();
		this.id = id;
		this.stunumber = stunumber;
		this.name = name;
		this.sex = sex;
		this.nation = nation;
		this.phone = phone;
		this.idcard = idcard;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", stunumber=" + stunumber + ", password=" + password + ", name=" + name + ", sex="
				+ sex + ", nation=" + nation + ", phone=" + phone + ", idcard=" + idcard + ", identity=" + identity
				+ ", card=" + card + "]";
	}

	public User(int id, String stunumber, String password, String name, String sex, String nation, String phone,
			String idcard, int identity) {
		super();
		this.id = id;
		this.stunumber = stunumber;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.nation = nation;
		this.phone = phone;
		this.idcard = idcard;
		this.identity = identity;
	}
	
	public User(int id, String stunumber, String password, String name, String sex, String nation, String phone,
			String idcard, int identity, List<SchoolCard> card) {
		super();
		this.id = id;
		this.stunumber = stunumber;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.nation = nation;
		this.phone = phone;
		this.idcard = idcard;
		this.identity = identity;
		this.card = card;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStunumber() {
		return stunumber;
	}
	public void setStunumber(String stunumber) {
		this.stunumber = stunumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public int getIdentity() {
		return identity;
	}
	public void setIdentity(int identity) {
		this.identity = identity;
	}
	public List<SchoolCard> getCard() {
		return card;
	}
	public void setCard(List<SchoolCard> card) {
		this.card = card;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
