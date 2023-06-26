package it.betacom.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import it.betacom.connection.DBHandler;
import java.util.ArrayList;
import java.util.List;
public class EsercizioLibri {
	
	 public void autoriEta(String nazione) throws SQLException {
		 List <Autore> autori = new ArrayList<>();
		 DBHandler con = DBHandler.getInstance();
		 Connection conn = con.getConnection();
		 try {
		 CallableStatement cs = conn.prepareCall("{CALL test.get_age_autori_nazione(?)}");
		 cs.setString(1,nazione);
		 cs.execute();
		 ResultSet resultSet = cs.getResultSet();
		
		// Stampa i risultati
         while (resultSet.next()) {
           Autore autore = new Autore();
           autore.nome= resultSet.getString("nome");
           autore.cognome=  resultSet.getString("cognome");
           autore.eta= resultSet.getInt("eta");
           autori.add(autore);
         }
     } catch (SQLException e) {
         e.printStackTrace();
     }
		 for (Autore autore : autori) {
	            System.out.println(autore.getNome() + " " + autore.getCognome()+" "+ autore.getEta());
	        }
	 }
}
