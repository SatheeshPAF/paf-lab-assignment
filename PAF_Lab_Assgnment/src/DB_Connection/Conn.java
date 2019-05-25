/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author SATHEESH
 */
public class Conn {

	private static Conn conn;
	public static Connection c;

	public static Connection getMyConnection() {
		try {
			if (c == null) {
//            System.out.println("Database Connection creating first time");
				Class.forName("com.mysql.jdbc.Driver");
				c = DriverManager.getConnection(
						"jdbc:mysql://localhost:3307/paf_lab_assignment?autoReconnect=true&useSSL=false", "root", "123");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
//        System.out.println("Using created Database Connection");
		return c;
	}

	public static Conn getInstance() {
		if (conn == null) {
			conn = new Conn();
		}
		return conn;
	}
}
