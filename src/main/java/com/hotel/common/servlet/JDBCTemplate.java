package com.hotel.common.servlet;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.omg.PortableInterceptor.SUCCESSFUL;

import com.hotel.DTO.HotelDetailsdto;
import com.mysql.fabric.xmlrpc.base.Data;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class JDBCTemplate {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/hotel_management";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "madhav";

	public boolean verfiyUser(String username, String password) {
		Connection conn = null;
		Statement stmt = null;
		boolean success = false;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			stmt = (Statement) conn.createStatement();
			String sql = "Select * from login where username='" + username
					+ "' and password='" + password + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				// Retrieve by column name

				String usernamedb = rs.getString("username");

				if (username.equals(usernamedb)) {
					success = true;
				}

			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}// do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try

		return success;
	}

	public List availability(String check_out_date,int category,int type) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ArrayList<HotelDetailsdto> list=new ArrayList<HotelDetailsdto>();
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			String sql = "select * from booking_details as b1 JOIN room_category r1 ON b1.room_id=r1.room_id "
					+ "where type=? and category=? and available=1" ;

			stmt = (PreparedStatement) conn.prepareStatement(sql);
			stmt.setInt(1,type );
			stmt.setInt(2,category );
			//stmt.setDate(3,java.sql.Date.valueOf(check_out_date));

			System.out.println(type+"----------"+category);
			ResultSet rs = stmt.executeQuery();
		
			
			while (rs.next()) {
				// Retrieve by column name
				HotelDetailsdto hotel=new HotelDetailsdto();
				hotel.setRoomId(rs.getInt("room_id"));
				hotel.setRcPrice(rs.getInt("rc_price"));
				hotel.setRcFloor(rs.getInt("rc_floor"));
				list.add(hotel);
				
				
				//S rs.getString("username");

				}
         
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}// do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try

		return list;
	}
	public boolean registerUser(String firstname, String lastname,
			String email, String password, String streetaddress, String city,
			String state, int zipcode, int mobile, String username) {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean success = false;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			String sql = "Insert into customer(cust_fname,cust_lname, cust_street_name, cust_mobile , cust_email,  cust_city, cust_state ,cust_zip_code) values(?,?,?,?,?,?,?,?)";

			stmt = (PreparedStatement) conn.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, firstname);
			stmt.setString(2, lastname);
			stmt.setString(3, streetaddress);
			stmt.setInt(4, mobile);
			stmt.setString(5, email);
			stmt.setString(6, city);
			stmt.setString(7, state);
			stmt.setInt(8, zipcode);

			int update = stmt.executeUpdate();
			if (update == 1) {
				success = true;
				ResultSet generatedKeys = stmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					long cust_id = generatedKeys.getLong(1);
					System.out.println(cust_id);
					String sql1 = "Insert into login(password,customer_id,username)values (?,?,?)";
					stmt = (PreparedStatement) conn.prepareStatement(sql1);
					stmt.setString(1, password);
					stmt.setLong(2, cust_id);
					stmt.setString(3, username);
					stmt.executeUpdate();
				}
			} else
				success = false;
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}// do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try

		return success;
	}
}
