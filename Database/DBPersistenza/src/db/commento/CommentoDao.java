package db.commento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.connessione.DBConnection;
import db.profilo.ProfiloDB;



public class CommentoDao implements ICommentoDao{

	private Connection conn;
	private String schema;
	
	public CommentoDao() {
		this.schema = "socialnetwork";
	}

	@Override
	public boolean scriviCommento(CommentoDB c) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="insert into commento (idCommento,oraCommento,dataCommento,testo,profilo,idFoto,idVideo,idSDV,idSSM,idTesto) values (?,?,?,?,?,?,?,?,?,?)";

			st1 = conn.prepareStatement(query);
			st1.setString(1, c.getIdCommento());
			st1.setTime(2, c.getOraCommento());
			st1.setDate(3, c.getDataCommento());
			st1.setString(4, c.getTesto());
		    st1.setString(5, c.getProfilo());
		    st1.setString(6, c.getIdFoto());
		    st1.setString(7, c.getIdVideo());
		    st1.setString(8, c.getIdSDV());
		    st1.setString(9, c.getIdSSM());
		    st1.setString(10, c.getIdTesto());
		   
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
	}

		DBConnection.closeConnection(conn);
		return esito;
	}

	@Override
	public boolean rimuoviCommento(CommentoDB c) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;

		boolean esito=true;

		try
		{
			String query="delete from commento where idCommento=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, c.getIdCommento());

			st1.executeUpdate();

		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}

	
	@Override
	public ArrayList<String> ProfiloNickCommento(ProfiloDB p) {
		ArrayList<String> res = new ArrayList<>();
		
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="select c.profilo,p.nickname, c.testo from commento c, profilo p where c.profilo = p.idProfilo and p.idProfilo = ?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, p.getIdProfilo());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				String s1 = rs1.getString("profilo");
				String s2 = rs1.getString("nickname");
				String s3 = rs1.getString("testo");
				res.add(s1);
				res.add(s2);
				res.add(s3);
				
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return res;
	}

	
	

	
	
	@Override
	public CommentoDB cercaCommento(CommentoDB c) {

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM commento WHERE idCommento=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, c.getIdCommento());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				CommentoDB com = new CommentoDB(rs1.getString(1), rs1.getTime(2),rs1.getDate(3),rs1.getString(4),rs1.getString(5),rs1.getString(6),rs1.getString(7),rs1.getString(8),rs1.getString(9),rs1.getString(10));

				DBConnection.closeConnection(conn);
				return com;
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return null;
	}

	
}
