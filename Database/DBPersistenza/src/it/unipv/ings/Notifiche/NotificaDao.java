package it.unipv.ings.Notifiche;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.ings.Sondaggio.SondaggioDB;
import it.unipv.ings.connessione.DBConnection;

import notifiche.Notifica;

public class NotificaDao {

	private Connection conn;
	private String schema;
	
	public NotificaDao() {
		this.schema = "social network";
	}
	
	public ArrayList<Notifica> SelectAll() {
	
		ArrayList<Notifica> result = new ArrayList<>();
		
		conn = DBConnection.startConnection(conn, schema);
		Statement st1;
		ResultSet rs1;
		
		try
		{
			st1 = conn.createStatement();
			String query="SELECT * from notifica"; //per davide: notifica va aggiunta al database
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				Notifica n= new Notifica(rs1.getString(1), rs1.getDate(2),rs1.getTime(3));                                     

				result.add(n);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		
		return result;
	}
}
