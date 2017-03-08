package com.derby.tutorial.jdbc;

import com.oracle.tutorial.jdbc.CoffeesTable;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyProvaDerby {
	
	public static void main(String[] args) {
		MyConnectionURL connURL = null;
		Connection conn = null;
				
		try {
			connURL = new MyConnectionURL();
			System.out.println("URL" + connURL.getConnectionURL());
			
			
			try {
				conn = DriverManager.getConnection(connURL.getConnectionURL());
				System.out.println("Connected to database " + connURL.getDBName());
				CoffeesTable cof = new CoffeesTable(conn , connURL.getDBName(), connURL.getDbms());
				//cof.dropTable();
				cof.createTable();
				cof.populateTable();
				CoffeesTable.viewTable(conn);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	   
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if ( conn != null) {
				try {
					System.out.println("close database " + connURL.getDBName());
					conn.close();					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
