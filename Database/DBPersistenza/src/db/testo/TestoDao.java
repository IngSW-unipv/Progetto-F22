package db.testo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.connessione.DBConnection;
import post.Post;
import post.testo.Testo;

public class TestoDao implements ITestoDao{

	private Connection conn;
	private String schema;
	public TestoDao() {
		this.schema = "socialnetwork";
	}
	@Override
	public ArrayList<Post> selectAll() {
		 ArrayList<Post> result = new ArrayList<>();

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
					Testo t=new Testo(rs1.getString(1), rs1.getDate(2), rs1.getTime(3), rs1.getString(4), rs1.getInt(5), rs1.getInt(6), rs1.getBoolean(7), rs1.getBoolean(8), rs1.getString(9),rs1.getString(10),rs1.getString(11));                                     

					result.add(t);
				}
			}catch (Exception e){e.printStackTrace();}

			DBConnection.closeConnection(conn);
			return result;
	}
	@Override
	public boolean pubblicaTesto(Post t) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="insert into testo (idTesto,dataPubblicazione,oraPubblicazione,descrizione,numLike,numDislike,visibile,condivisibile,profilo) values (?,?,?,?,?,?,?,?,?)";

			st1 = conn.prepareStatement(query);
			st1.setString(1, t.getIdPost());
			st1.setDate(2, t.getDataPubblicazione());
			st1.setTime(3, t.getOraPubblicazione());
			st1.setString(4, t.getDescrizione());
		    st1.setInt(5, t.getNumLike());
		    st1.setInt(6, t.getNumDislike());
		    st1.setBoolean(7, t.isVisibile());
		    st1.setBoolean(8, t.isCondivisibile());
		    st1.setString(9, t.getProfilo());
		    
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
	@Override
	public boolean rimuoviTesto(Post t) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;

		boolean esito=true;

		try
		{
			String query="delete from testo where idTesto=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1,t.getIdPost());

			st1.executeUpdate();

		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
	@Override
	public boolean aggiungiCaratteristiche(Post p, String s1, String s2) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="update testo set font=?, titolo=? where idTesto=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, s1);
			st1.setString(2, s2);
			st1.setString(3, p.getIdPost());
			
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
	
	
}