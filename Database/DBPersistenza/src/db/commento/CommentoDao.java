package db.commento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.connessione.DBConnection;

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
			String query="insert into commento (idCommento,oraCommento,dataCommento,testo,post) values (?,?,?,?,?)";

			st1 = conn.prepareStatement(query);
			st1.setString(1, c.getIdCommento());
			st1.setTime(2, c.getOraCommento());
			st1.setDate(3, c.getDataCommento());
			st1.setString(4, c.getTesto());
			st1.setString(5, c.getPost());
		
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
	public ArrayList<CommentoDB> mostraCommentiSottoPost(CommentoDB c) {
		ArrayList<CommentoDB> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM commento WHERE post=? order by IdCommento";

			st1 = conn.prepareStatement(query);
			st1.setString(1, c.getPost());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				CommentoDB com = new CommentoDB(rs1.getString(1), rs1.getTime(2),rs1.getDate(3),rs1.getString(4),rs1.getString(5));
				result.add(com);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}

	@Override
	public ArrayList<CommentoDB> cercaCommento(String c) {
		ArrayList<CommentoDB> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM commento WHERE idCommento=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, c);

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				CommentoDB com = new CommentoDB(rs1.getString(1), rs1.getTime(2),rs1.getDate(3),rs1.getString(4),rs1.getString(5));

				result.add(com);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}
}
