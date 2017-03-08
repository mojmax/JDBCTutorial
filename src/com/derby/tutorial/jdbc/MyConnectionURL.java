package com.derby.tutorial.jdbc;

import java.io.FileNotFoundException;
import com.derby.tutorial.jdbc.ConfigDb;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyConnectionURL {
	private String protocol = null;
	private String dbms = null;
	private String dbname = null;
	private String server = null;
	private String port = null;
	private String connectionURL = null;
	private String driverType = null;
	private String driver = null;

	InputStream inputStream;

	public  MyConnectionURL() throws IOException {
		connectionURL = null;
		Properties p = new Properties();
		String propFileName = "config.properties";
		try {
			
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			if (inputStream != null)
				p.load(inputStream);
			else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			
			driverType = p.getProperty(ConfigDb.DRIVER_TYPE);
			driver = p.getProperty(ConfigDb.DRIVER);
			protocol = p.getProperty(ConfigDb.PROTOCOL);
			dbms = p.getProperty(ConfigDb.DBMS);
			server = p.getProperty(ConfigDb.SERVER);
			port = p.getProperty(ConfigDb.PORT);
			dbname = p.getProperty(ConfigDb.DATABASE);
			
			if (p.getProperty(ConfigDb.DRIVER_TYPE).equals(DriverType.EMBEDDED.getCodice())) {				
				connectionURL = protocol + ":" + dbms + ":" + dbname + ";";
			} else {				
				connectionURL = protocol + ":" + dbms + "://" + server + ":" + port + "/" + dbname + ";create=true;";
			}			
			printConnection();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			inputStream.close();
		}
	}
	
	private void printConnection() {
		System.out.println(ConfigDb.DRIVER + " : " + driver );
		System.out.println(ConfigDb.DRIVER_TYPE + " : " + driverType);
		System.out.println(ConfigDb.DBMS + " : " + dbms);
		System.out.println(ConfigDb.PROTOCOL + " : " + protocol);		
		System.out.println(ConfigDb.DATABASE + " : " + dbname);
		System.out.println("Connection URL " + connectionURL);		
	};
	
	public String getConnectionURL() {
		printConnection();
		return connectionURL;
	}

	public String getDBName() {
		printConnection();
		System.out.println(ConfigDb.DATABASE + " : " + dbname );
		return dbname;
	}
	public String getDbms() {
		System.out.println(ConfigDb.DBMS + " : " + dbms);
		return dbms;
	}

}
