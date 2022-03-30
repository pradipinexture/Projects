package com.mvc.util;
import java.sql.*;

public class ConnectionClass {

	private static ConnectionClass instance = null;

	private static final String USERNAME = "root";
	private static final String PASSWORD = "99097@Pradip";
	private  static String DATABASENAME="project";
	private static final String URL = "jdbc:mysql:// localhost:3306/" +DATABASENAME;

	private Connection conn = null;

	// we make constructor private for singleton concept
	private ConnectionClass() {}

	// Below code for return instance of class
	public static ConnectionClass getInstance() {
		if (instance == null) {
			instance = new ConnectionClass();
		}
		return instance;
	}

	public void setDatabaseName(String DATABASENAME) {
		this.DATABASENAME = DATABASENAME;
	}

	private boolean openConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			return true;
		}
		catch (SQLException | ClassNotFoundException e) {
			System.err.println("There is error : "+e);
			return false;
		}
	}

	public Connection getConnection() {
		if (conn == null) {
			if (openConnection()) {
				System.out.println("Connection opened");
				return conn;
			} else {
				return null;
			}
		}
		return conn;
	}


	public void close() {
		System.out.println("Closing connection");
		try {
			conn.close();
			conn = null;
		} catch (Exception e) {
		}
	}
}
