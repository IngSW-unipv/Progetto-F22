package it.unipv.ings.Testo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.ings.connessione.DBConnection;

public class TestoDao implements ITestoDao{

	private Connection conn;
	private String schema;
	public TestoDao() {
		this.schema = "socialnetwork";
	}
	@Override
	public ArrayList<Testo> selectAll() {
		 ArrayList<Testo> result = new ArrayList<>();

			conn=DBConnection.startConnection(conn,schema);
			Statement st1;
			ResultSet rs1;

			try
			{
				st1 = conn.createStatement();
				String query="SELECT * from testo";
				rs1=st1.executeQuery(query);

				while(rs1.next())
				{
					Testo t=new Testo(rs1.getString(1), rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getString(5));                                     

					result.add(t);
				}
			}catch (Exception e){e.printStackTrace();}

			DBConnection.closeConnection(conn);
			return result;
	}
	@Override
	public boolean pubblicaTesto(Testo t) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="insert into testo (idTesto,descrizione,titolo,font) values (?,?,?,?)";

			st1 = conn.prepareStatement(query);
			st1.setString(1, t.getIdTesto());
			st1.setString(2, t.getDescrizione());
			st1.setString(3, t.getTitolo());
			st1.setString(4, t.getFont());
		
		
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
	@Override
	public boolean inserisciChiavi(Testo t) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="update testo set post=? where idTesto=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, t.getPost());
			st1.setString(2, t.getIdTesto());
			
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
	}
		DBConnection.closeConnection(conn);
		return esito;
	}
	@Override
	public boolean rimuoviTesto(Testo t) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;

		boolean esito=true;

		try
		{
			String query="delete from testo where idTesto=? and post=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1,t.getIdTesto());
			st1.setString(2,t.getPost());

			st1.executeUpdate();

		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
	
	
}
