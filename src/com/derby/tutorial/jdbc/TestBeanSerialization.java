package com.derby.tutorial.jdbc;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class TestBeanSerialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProvaBean bean = new ProvaBean();
		NomeCognome nomCogn = new NomeCognome();
		nomCogn.setNome("Massimo");
		nomCogn.setCognome("Mojetta");
		
		bean.setEta(22);
		bean.setNomeCognome(nomCogn);
		XMLEncoder encoder = null;
		try {
			encoder = new XMLEncoder(
			           new BufferedOutputStream(
			           new FileOutputStream("Beanarchive.xml")));
			encoder.writeObject(bean);
			System.out.println("Object ProvaBean Serialized");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if ( encoder != null ) {
				encoder.close(); 
			}
		}

		
		

	}

}
