package db.post.testo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.commento.CommentoDB;
import db.connessione.DBConnection;
import db.post.PostDB;
import db.post.PostDao;

public class TestoDao extends PostDao {

	private Connection conn;
	private String schema;
	public TestoDao() {
		this.schema = "socialnetwork";
	}
	@Override
	public ArrayList<PostDB> selectAll() {
		 ArrayList<PostDB> result = new ArrayList<>();

			conn=DBConnection.startConnection(conn,schema);
			Statement st1;
			ResultSet rs1;

			try
			{
				st1 = conn.createStatement();
				String query="SELECT * from testo order by idTesto";
				rs1=st1.executeQuery(query);

				while(rs1.next())
				{
					TestoDB tdb =new TestoDB(rs1.getString(1), rs1.getDate(2), rs1.getTime(3), rs1.getString(4), rs1.getInt(5),rs1.getInt(6),rs1.getBoolean(7), rs1.getBoolean(8), rs1.getString(9),rs1.getString(10),rs1.getString(11));                                     

					result.add(tdb);
				}
			}catch (Exception e){e.printStackTrace();}

			DBConnection.closeConnection(conn);
			return result;
	}
	@Override
	public boolean caricaPost(PostDB t) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="insert into testo (idTesto,dataPubblicazione,oraPubblicazione,descrizione,visibile,condivisibile,profilo) values (?,?,?,?,?,?,?)";

			st1 = conn.prepareStatement(query);
			st1.setString(1, t.getIdPost());
			st1.setDate(2, t.getDataPubblicazione());
			st1.setTime(3, t.getOraPubblicazione());
			st1.setString(4, t.getDescrizione());
		    st1.setBoolean(5, t.isVisibile());
		    st1.setBoolean(6, t.isCondivisibile());
		    st1.setString(7, t.getProfilo());
		    
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
	
	@Override
	public boolean inserisciChiavi(PostDB p, String[] s, int i, boolean b) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="update testo set font=?, titolo=? where idTesto=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, s[0]);
			st1.setString(2, s[1]);
			st1.setString(3, p.getIdPost());
			
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
	
	@Override
	public boolean eliminaPost(PostDB t) {
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
	public PostDB cercaPost(PostDB t) {

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM testo WHERE idTesto=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, t.getIdPost());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				TestoDB tdb =new TestoDB(rs1.getString(1), rs1.getDate(2), rs1.getTime(3), rs1.getString(4), rs1.getInt(5),rs1.getInt(6),rs1.getBoolean(7), rs1.getBoolean(8), rs1.getString(9),rs1.getString(10),rs1.getString(11));                                     

				DBConnection.closeConnection(conn);

				return tdb;
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return null;
	}
	@Override
	public String ottieniPercorso(PostDB m) {
		return null;
	}
	
	@Override
	public ArrayList<String> ritornaPostDiUnProfilo(String idProfilo) {
		ArrayList<String> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT idTesto,percorso FROM testo WHERE profilo=? order by dataPubblicazione,oraPubblicazione";

			st1 = conn.prepareStatement(query);
			st1.setString(1, idProfilo);

			rs1=st1.executeQuery();

			while(rs1.next())
			{
                	result.add(rs1.getString("idTesto"));
                	result.add(rs1.getString("percorso"));
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}
	@Override
	public ArrayList<CommentoDB> mostraCommentiSottoPost(PostDB c) {
		ArrayList<CommentoDB> result = new ArrayList<>();
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;
		
		try
		{
			String query="SELECT * FROM commento WHERE idTesto=? order by dataCommento,oraCommento";

			st1 = conn.prepareStatement(query);
			st1.setString(1, c.getIdPost());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				CommentoDB com = new CommentoDB(rs1.getString(1), rs1.getTime(2),rs1.getDate(3),rs1.getString(4),rs1.getString(5),rs1.getString(6),rs1.getString(7),rs1.getString(8),rs1.getString(9),rs1.getString(10));
				result.add(com);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
		
	}
	@Override
	public ArrayList<String> mostraTestoCommentiPost(PostDB c) {
		ArrayList<String> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

			try
			{
				String query="SELECT testo FROM commento WHERE idTesto=? order by dataCommento, oraCommento";

				st1 = conn.prepareStatement(query);
				st1.setString(1, c.getIdPost());

				rs1=st1.executeQuery();

				while(rs1.next())
				{
	                	result.add(rs1.getString("testo"));
				}
			}catch (Exception e){e.printStackTrace();}

			DBConnection.closeConnection(conn);
			return result;
	}

}
