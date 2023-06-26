package it.betacom.main;

import java.sql.SQLException;

import it.betacom.model.EsercizioLibri;

public class EsercizioLibroMain {
	public static void main (String[] args) throws SQLException {
		
		EsercizioLibri test = new EsercizioLibri();	
		test.autoriEta("Italia");
		
	}
}
