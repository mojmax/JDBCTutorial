package com.derby.tutorial.jdbc;

import java.io.Serializable;

public class NomeCognome implements Serializable {
	
	private String Nome=null;
	private String Cognome=null;
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
	}

}
