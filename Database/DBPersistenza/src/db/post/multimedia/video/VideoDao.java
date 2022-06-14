package db.post.multimedia.video;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.commento.CommentoDB;
import db.connessione.DBConnection;
import db.post.PostDB;
import db.post.PostDao;


public class VideoDao  extends PostDao{

	private Connection conn;
	private String schema;
	public VideoDao() {
		this.schema = "socialnetwork";
	}
	
	@Override
	public ArrayList<String> caricaPostProfiliSeguiti(String profilo) {
		ArrayList<String> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;

		ResultSet rs1;

		try
		{
			String query="select idVideo from video f, follow fo where f.profilo = fo.profiloSeguito and profiloPersonale=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, profilo);
			rs1=st1.executeQuery();

			while(rs1.next())
			{
				String idNuovo=rs1.getString(1);
				result.add(idNuovo);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		
		return result;
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
				String query="SELECT * from video order by idVideo";
				rs1=st1.executeQuery(query);

				while(rs1.next())
				{
					VideoDB vdb =new VideoDB(rs1.getString(1), rs1.getDate(2), rs1.getTime(3), rs1.getString(4),rs1.getInt(5),rs1.getInt(6), rs1.getBoolean(7), rs1.getString(8), rs1.getInt(9),rs1.getString(10),rs1.getBoolean(11), rs1.getInt(12));                                     

					result.add(vdb);
				}
			}catch (Exception e){e.printStackTrace();}

			DBConnection.closeConnection(conn);
			return result;
	}
	
	@Override
	public boolean caricaPost(PostDB v) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="insert into video (idVideo,dataPubblicazione,oraPubblicazione,descrizione,numLike,numDislike,visibile,profilo) values (?,?,?,?,?,?,?,?)";

			st1 = conn.prepareStatement(query);
			st1.setString(1, v.getIdPost());
			st1.setDate(2, v.getDataPubblicazione());
			st1.setTime(3, v.getOraPubblicazione());
		    st1.setString(4, v.getDescrizione());
			st1.setInt(5, v.getNumLike());
			st1.setInt(6, v.getNumDislike());
			st1.setBoolean(7, true);
		    st1.setString(8, v.getProfilo());
		    
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
			String query="update video set tempoCancellazione=?, percorso=?, isStory=?, durataInSecondi=? where idVideo=?";

			st1 = conn.prepareStatement(query);
			st1.setInt(1, 0);
			st1.setString(2, s[0]);
			st1.setBoolean(3, false);
			st1.setInt(4, i);
			st1.setString(5, p.getIdPost());
			
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
		
	}
	
	@Override
	public boolean eliminaPost(PostDB v) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;

		boolean esito=true;

		try
		{
			String query="delete from video where idVideo=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, v.getIdPost());
			
			st1.executeUpdate();

		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
	@Override
	public PostDB cercaPost(PostDB v) {

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM video WHERE idVideo=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, v.getIdPost());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				VideoDB vdb =new VideoDB(rs1.getString(1), rs1.getDate(2), rs1.getTime(3), rs1.getString(4),rs1.getInt(5),rs1.getInt(6), rs1.getBoolean(7), rs1.getString(8), rs1.getInt(9),rs1.getString(10),rs1.getBoolean(11), rs1.getInt(12));                                     
				DBConnection.closeConnection(conn);

				return vdb;
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return null;
	}
	@Override
	public String ottieniPercorso(PostDB m) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT percorso FROM video WHERE idVideo=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, m.getIdPost());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				String s = rs1.getString("percorso");
				DBConnection.closeConnection(conn);
				return s;
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
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
			String query="SELECT idVideo,percorso FROM video WHERE profilo=? order by dataPubblicazione,oraPubblicazione";

			st1 = conn.prepareStatement(query);
			st1.setString(1, idProfilo);

			rs1=st1.executeQuery();

			while(rs1.next())
			{
                	result.add(rs1.getString("idVideo"));
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
			String query="SELECT * FROM commento WHERE idVideo=? order by dataCommento,oraCommento";

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
				String query="SELECT testo FROM commento WHERE idVideo=? order by dataCommento, oraCommento";

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
	@Override
	public boolean modificaVisibile(PostDB p, boolean b) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="update video set visibile=? where idVideo=?";
			st1 = conn.prepareStatement(query);
			st1.setBoolean(1, b);
			st1.setString(2, p.getIdPost());
		
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
	@Override
	public boolean vediVisibilita(PostDB p) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT visibile FROM video WHERE idVideo=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, p.getIdPost());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				boolean b = rs1.getBoolean("visibile");
				DBConnection.closeConnection(conn);
				return b;
			
			}
		}catch (Exception e){e.printStackTrace();}
		System.out.println("Si è verificato un errore, ritorno false");
		return false;
	}
	@Override
	public int vediNumLike(PostDB p) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT numLike FROM video WHERE idVideo=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, p.getIdPost());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				int i = rs1.getInt("numLike");
				DBConnection.closeConnection(conn);
				return i;
			
			}
		}catch (Exception e){e.printStackTrace();}
		return -1;
	}
	@Override
	public boolean modificaNumLike(PostDB p, int n) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="update video set numLike=? where idVideo=?";
			st1 = conn.prepareStatement(query);
			st1.setInt(1, n);
			st1.setString(2, p.getIdPost());
		
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
	@Override
	public int vediNumDislike(PostDB p) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT numDislike FROM video WHERE idVideo=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, p.getIdPost());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				int i = rs1.getInt("numDislike");
				DBConnection.closeConnection(conn);
				return i;
			
			}
		}catch (Exception e){e.printStackTrace();}
		return -1;
	}
	@Override
	public boolean modificaNumDislike(PostDB p, int n) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="update video set numDislike=? where idVideo=?";
			st1 = conn.prepareStatement(query);
			st1.setInt(1, n);
			st1.setString(2, p.getIdPost());
		
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
	@Override
	public boolean modificaTempoCancellazione(PostDB m, int tempo) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="update video set tempoCancellazione=? where idVideo=?";
			st1 = conn.prepareStatement(query);
			st1.setInt(1, tempo);
			st1.setString(2, m.getIdPost());
		
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
	@Override
	public boolean modificaIsStory(PostDB m, boolean b) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="update video set isStory=? where idVideo=?";
			st1 = conn.prepareStatement(query);
			st1.setBoolean(1, b);
			st1.setString(2, m.getIdPost());
		
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}

	@Override
	public ArrayList<String> caricaStorieProfiliSeguiti(String profilo) {
		return null;
	}

}
