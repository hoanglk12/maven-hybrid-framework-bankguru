package com.database.testing;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbcConnection.MySQLConnUtils;

public class MySQLTest {

	public static void main(String[] args) throws SQLException {
		Connection conn = MySQLConnUtils.getMySQLConnection();
		String query = "select *from customer;";
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(query);
		while (result.next()) {
			System.out.println(result.getInt("CUST_ID"));
			System.out.println(result.getString("ADDRESS"));
			System.out.println(result.getString("CITY"));
		}
		conn.close();
	}
}
