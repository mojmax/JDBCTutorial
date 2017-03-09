package com.derby.tutorial.jdbc;

import java.io.Serializable;

public class ProvaBean implements Serializable {
	private int eta = 0;
	private NomeCognome nomeCognome = new NomeCognome() ;
	public void setEta(int eta) {
		this.eta = eta;
	}
	public int getEta() {
		return this.eta;
	}
	public NomeCognome getNomeCognome() {
		return nomeCognome;
	}
	public void setNomeCognome(NomeCognome nomeCognome) {
		this.nomeCognome = nomeCognome;
	}

}
