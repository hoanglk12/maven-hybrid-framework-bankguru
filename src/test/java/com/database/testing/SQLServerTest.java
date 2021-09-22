package com.database.testing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbcConnection.SQLServerConnUtils;

public class SQLServerTest {

	public static void main(String[] args) throws SQLException {
		Connection conn = SQLServerConnUtils.getSQLServerConnection();
//		String selectQuery = "SELECT *FROM [automationfc].[dbo].[BRANCH]";
//		String deleteQuery = "DELETE FROM BRANCH WHERE NAME='Honda';";
		String selectQuery = "select *from employee where title like ? and DEPT_ID = ?";
//		Statement statement = conn.createStatement();
		PreparedStatement prepareStatement = conn.prepareStatement(selectQuery);
		prepareStatement.setString(1, "%Teller");
		prepareStatement.setInt(2, 1);
		//statement.execute(deleteQuery);
//		ResultSet result = statement.executeQuery(selectQuery);
		ResultSet result = prepareStatement.executeQuery();
		while (result.next()) {
			System.out.println(result.getInt("DEPT_ID"));
			System.out.println(result.getString("TITLE"));
//			System.out.println(result.getString("CITY"));
//			System.out.println(result.getString("NAME"));
//			System.out.println(result.getString("STATE"));
//			System.out.println(result.getString("ZIP_CODE"));
		}
		conn.close();
	}
}
