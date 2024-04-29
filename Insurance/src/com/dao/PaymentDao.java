package com.dao;

import java.sql.SQLException;

import com.model.Payment;

public interface PaymentDao {

	public int save(Payment payment) throws SQLException;
}
