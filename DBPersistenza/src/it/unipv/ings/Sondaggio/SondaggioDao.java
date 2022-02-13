package it.unipv.ings.Sondaggio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.ings.connessione.DBConnection;

public class SondaggioDao implements ISondaggioDao{
private Connection conn;
private String schema; 
public SondaggioDao() {
	this.schema="socialnetwork";
}
@Override
public ArrayList<Sondaggio> selectAll() {
	 ArrayList<Sondaggio> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		Statement st1;
		ResultSet rs1;

		try
		{
			st1 = conn.createStatement();
			String query="SELECT * from sondaggio";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				Sondaggio s=new Sondaggio(rs1.getString(1), rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getString(5),rs1.getString(6));                                     

				result.add(s);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
}
@Override
public boolean pubblicaSondaggio(Sondaggio s) {
	conn=DBConnection.startConnection(conn,schema);
	PreparedStatement st1;
	boolean esito = true;

	try
	{
		String query="insert into sondaggio (idSondaggio,primaScelta,secondaScelta,terzaScelta,quartaScelta) values (?,?,?,?,?)";

		st1 = conn.prepareStatement(query);
		st1.setString(1, s.getIdSondaggio());
		st1.setString(2, s.getPrimaScelta());
		st1.setString(3, s.getSecondaScelta());
		st1.setString(4, s.getTerzaScelta());
		st1.setString(5, s.getQuartaScelta());

	
		st1.executeUpdate();


	}catch (Exception e){
		e.printStackTrace();
		esito=false;
	}

	DBConnection.closeConnection(conn);
	return esito;
}
@Override
public boolean inserisciChiavi(Sondaggio s) {
	conn=DBConnection.startConnection(conn,schema);
	PreparedStatement st1;
	boolean esito = true;

	try
	{
		String query="update sondaggio set post=? where idSondaggio=?";
		st1 = conn.prepareStatement(query);
		st1.setString(1, s.getPost());
		st1.setString(2, s.getIdSondaggio());
		
		st1.executeUpdate();


	}catch (Exception e){
		e.printStackTrace();
		esito=false;
}
	DBConnection.closeConnection(conn);
	return esito;
}
@Override
public boolean rimuoviSondaggio(Sondaggio s) {
	conn=DBConnection.startConnection(conn,schema);
	PreparedStatement st1;

	boolean esito=true;

	try
	{
		String query="delete from sondaggio where idSondaggio=? and post=?";
		st1 = conn.prepareStatement(query);
		st1.setString(1, s.getIdSondaggio());
        st1.setString(2, s.getPost());
		
		st1.executeUpdate();

	}catch (Exception e){
		e.printStackTrace();
		esito=false;
	}

	DBConnection.closeConnection(conn);
	return esito;
}


}
