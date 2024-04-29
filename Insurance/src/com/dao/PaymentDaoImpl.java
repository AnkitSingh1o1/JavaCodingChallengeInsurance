package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.Payment;
import com.utility.DBConnection;

public class PaymentDaoImpl implements PaymentDao{

	@Override
	public int save(Payment payment) throws SQLException {
		Connection con = DBConnection.dbConnect();

		String sql = "insert into payment(payment_id, payment_date, payment_amount, client_id) values "
				+ "(?, ?, ?, ?);";

		// prepare statement
		PreparedStatement pstmt = con.prepareStatement(sql);

		// attach the data
		pstmt.setInt(1, payment.getPaymentId());
		pstmt.setString(2, payment.getPaymenyDate());
		pstmt.setDouble(3, payment.getPaymentAmount());
		
		// execute the query
		int status = pstmt.executeUpdate();

		// close db connection
		DBConnection.dbClose();

		return status;
	}

}
