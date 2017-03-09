package com.derby.tutorial.jdbc;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestBeanDeserialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		XMLDecoder decoder = null;
		ProvaBean bean = null;
		try {
			decoder = new XMLDecoder(
				    new BufferedInputStream(
				    new FileInputStream("Beanarchive.xml")));
			 bean = (ProvaBean) decoder.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (decoder != null ) {
				System.out.println("Close decoder");
				decoder.close();
			}
		}
		System.out.println("Eta :" + bean.getEta());
		NomeCognome n =  bean.getNomeCognome();
		System.out.println("Nome :" + n.getNome());
		System.out.println("Cognome :" + bean.getNomeCognome().getCognome());

			
			

	}

}
