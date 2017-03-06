package com.derby.tutorial.jdbc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public enum DriverType implements Serializable {
	
		EMBEDDED("embedded"),
		CLIENT("client");
				
		private String codice;
				
		/**
		 * @return the codice
		 */
		private DriverType(String codice) {
			this.codice = codice;			
		}
		/**
		 * @return the codice
		 */
		public String getCodice() {
			return codice;
		}
		
}
