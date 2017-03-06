package com.derby.tutorial.jdbc;

import java.io.FileNotFoundException;
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

	InputStream inputStream;
	private static final String DRIVER = "driver";
	private static final String DRIVER_TYPE = "drivertype";
	private static final String DBMS = "dbms";
	private static final String SERVER = "server";
	private static final String PORT = "port";
	private static final String DATABASE = "database";
	private static final String PROTOCOL = "protocol";

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
			protocol = p.getProperty(PROTOCOL);
			dbms = p.getProperty(DBMS);
			dbname = p.getProperty(DATABASE);
			System.out.println(DRIVER + " : " + p.getProperty(DRIVER));
			System.out.println(DRIVER_TYPE + " : " + p.getProperty(DRIVER_TYPE));
			System.out.println(PROTOCOL + " : " + protocol);
			System.out.println(DBMS + " : " + dbms);
			if (p.getProperty(DRIVER_TYPE).equals(DriverType.EMBEDDED.getCodice())) {
				System.out.println("Il driver e' embedded");
				connectionURL = protocol + ":" + dbms + ":" + dbname + ";create=true;";
			} else {
				server = p.getProperty(SERVER);
				port = p.getProperty(PORT);
				connectionURL = protocol + ":" + dbms + "://" + server + ":" + port + "/" + dbname + ";create=true;";
				System.out.println("Il driver e' client");
			}

			System.out.println(DATABASE + " : " + dbname);
			System.out.println("Connection URL " + connectionURL);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			inputStream.close();
		}
	}

	public String getConnectionURL() {
		return connectionURL;
	}

	public String getDBName() {
		return dbname;
	}

}
