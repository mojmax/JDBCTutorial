package com.derby.tutorial.jdbc;

import com.oracle.tutorial.jdbc.CoffeesTable;
import com.oracle.tutorial.jdbc.JDBCTutorialUtilities;

import jdk.nashorn.internal.codegen.DumpBytecode;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyProvaDerby {
	
	public static void main(String[] args) {
		MyConnectionURL connURL = null;
		Connection conn = null;
				//
		try {
			connURL = new MyConnectionURL();
			System.out.println("URL" + connURL.getConnectionURL());
			try {
				conn = DriverManager.getConnection(connURL.getConnectionURL());
				System.out.println("Connected to database " + connURL.getDBName());		
				//cof.dropTable();
				//cof.createTable();
				//cof.populateTable();
				//								
				JDBCTutorialUtilities.cursorHoldabilitySupport(conn);
				CoffeesTable cof = new CoffeesTable(conn , connURL.getDBName(), connURL.getDbms());
				//cof.addRow("Pluto", 49, 22.0f, 0, 0);
				cof.viewTable(conn);
				//cof.doubePrices();
				//cof.viewTable(conn);
				PreparedStatement prep = null;
				String stringUpdateSales =
				        "update APP.COFFEES " +
				        "set SALES = ? where COF_NAME = ?";
				prep = conn.prepareStatement(stringUpdateSales);
				prep.setInt(1, 3);
				prep.setString(2, "Pluto");
				prep.executeUpdate();
				
				System.out.println("AutoCommit : " + conn.getAutoCommit() );
				
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
