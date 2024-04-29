package com.service;

import java.sql.SQLException;

import com.dao.PaymentDao;
import com.dao.PaymentDaoImpl;
import com.model.Payment;

public class PaymentService {

	PaymentDao dao = new PaymentDaoImpl();
	public int save(Payment p) throws SQLException {
		return dao.save(p);
	}

}
