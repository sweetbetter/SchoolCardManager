package com.exam.model;

public class SchoolCard {
	private int id;
	private String cardid;
	private double money;
	private double lastadd;
	private double consume;
	public SchoolCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "SchoolCard [id=" + id + ", cardid=" + cardid + ", money=" + money + ", lastadd=" + lastadd
				+ ", consume=" + consume + "]";
	}

	public SchoolCard(int id, String cardid, double money, double lastadd, double consume) {
		super();
		this.id = id;
		this.cardid = cardid;
		this.money = money;
		this.lastadd = lastadd;
		this.consume = consume;
	}
	
	public SchoolCard(String cardid, double money) {
		super();
		this.cardid = cardid;
		this.money = money;
	}

	public SchoolCard(int id, String cardid) {
		super();
		this.id = id;
		this.cardid = cardid;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public double getLastadd() {
		return lastadd;
	}
	public void setLastadd(double lastadd) {
		this.lastadd = lastadd;
	}
	public double getConsume() {
		return consume;
	}
	public void setConsume(double consume) {
		this.consume = consume;
	}
	
}
