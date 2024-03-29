package JDBC;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class DBDemo {
	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?characterEncoding=utf8";
		String userName = "root";
		String password = "Srikanth9640@";
		java.sql.Connection con;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded!");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Cannot find the driver in the classpath", e);
		}
		listDrivers();

		try {
			System.out.println("Connecting to database: " + jdbcURL);
			con = DriverManager.getConnection(jdbcURL, userName, password);
			System.out.println("Connection is successfull!!!" + con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void listDrivers() {
		Enumeration<Driver> driverList = DriverManager.getDrivers();
		while (driverList.hasMoreElements()) {
			Driver driverClass = (Driver) driverList.nextElement();
			System.out.println(" " + driverClass.getClass().getName());
		}

	}
}
