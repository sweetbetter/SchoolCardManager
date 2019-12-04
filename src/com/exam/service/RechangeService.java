package com.exam.service;

import java.sql.SQLException;

public interface RechangeService {
	public int rechangeMoney(String cardid,double money) throws SQLException;//通过校园卡号完成充值 操作  完成充值操作充值操作
}
