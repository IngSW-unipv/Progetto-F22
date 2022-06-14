package db.post.multimedia.foto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.commento.CommentoDB;
import db.connessione.DBConnection;
import db.post.PostDB;
import db.post.PostDao;
import db.post.multimedia.MultimediaDB;

public class FotoDao extends PostDao {

	private Connection conn;
	private String schema;
	public FotoDao() {
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
			String query="select idFoto from foto f, follow fo where f.profilo = fo.profiloSeguito and profiloPersonale=?";
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
	public ArrayList<String> caricaStorieProfiliSeguiti(String profilo) {
		ArrayList<String> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;

		ResultSet rs1;

		try
		{
			String query="select idFoto, percorso from foto f, follow fo where f.profilo = fo.profiloSeguito and profiloPersonale=? and f.isStory = 1";
			st1 = conn.prepareStatement(query);
			st1.setString(1, profilo);
			rs1=st1.executeQuery();

			while(rs1.next())
			{
				String idNuovo=rs1.getString(1);
				String percorsoNuovo=rs1.getString(2);

				result.add(idNuovo);
				result.add(percorsoNuovo);
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
			String query="SELECT * from foto order by idFoto";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				FotoDB fdb=new FotoDB(rs1.getString(1),rs1.getDate(2),rs1.getTime(3), rs1.getString(4),rs1.getInt(5),rs1.getInt(6), rs1.getBoolean(7), rs1.getString(8),rs1.getInt(9), rs1.getString(10),rs1.getBoolean(11), rs1.getBoolean(12));                                     

				result.add(fdb);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}
	
	@Override
	public boolean caricaPost(PostDB f) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;
		
		System.out.println(((MultimediaDB) f).isStory);

		try
		{
			String query="insert into foto (idFoto,dataPubblicazione,oraPubblicazione,descrizione,numLike,numDislike,visibile,profilo,isStory) values (?,?,?,?,?,?,?,?,?)";

			st1 = conn.prepareStatement(query);
			st1.setString(1, f.getIdPost());
			st1.setDate(2, f.getDataPubblicazione());
			st1.setTime(3, f.getOraPubblicazione());
		    st1.setString(4, f.getDescrizione());
			st1.setInt(5, f.getNumLike());
			st1.setInt(6, f.getNumDislike());
			st1.setBoolean(7, true);
		    st1.setString(8, f.getProfilo());
		    st1.setBoolean(9, ((MultimediaDB) f).isStory());
		 
		    
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		
		return esito;
	}
	
	
	@Override
	public boolean inserisciChiavi(PostDB p, String [] s, int i, boolean b) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="update foto set tempoCancellazione=?, percorso=?, isStory=?, isHd=? where idFoto=?";

			st1 = conn.prepareStatement(query);
			st1.setInt(1, 0);
			st1.setString(2, s[0]);
			st1.setBoolean(3, false);
			st1.setBoolean(4, b);
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
	public boolean eliminaPost(PostDB f) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;

		boolean esito=true;

		try
		{
			String query="delete from foto where idFoto=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, f.getIdPost());
           
			st1.executeUpdate();

		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
	
	@Override
	public PostDB cercaPost(PostDB p) {

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM foto WHERE idFoto=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, p.getIdPost());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				FotoDB fdb=new FotoDB(rs1.getString(1),rs1.getDate(2),rs1.getTime(3), rs1.getString(4),rs1.getInt(5),rs1.getInt(6), rs1.getBoolean(7), rs1.getString(8),rs1.getInt(9), rs1.getString(10),rs1.getBoolean(11), rs1.getBoolean(12));                                     

				DBConnection.closeConnection(conn);

				return fdb;
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
			String query="SELECT percorso FROM foto WHERE idFoto=?";

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
	public ArrayList<String> ritornaPostDiUnProfilo(String idprofilo) {
		ArrayList<String> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT idFoto, percorso FROM foto WHERE profilo=? order by dataPubblicazione,oraPubblicazione";

			st1 = conn.prepareStatement(query);
			st1.setString(1, idprofilo);

			rs1=st1.executeQuery();

			while(rs1.next())
			{
                	result.add(rs1.getString("idFoto"));
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
			String query="SELECT * FROM commento WHERE idFoto=? order by dataCommento,oraCommento";

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
				String query="SELECT testo FROM commento WHERE idFoto=? order by dataCommento, oraCommento";

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
			String query="update foto set visibile=? where idFoto=?";
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
			String query="SELECT visibile FROM foto WHERE idFoto=?";

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
			String query="SELECT numLike FROM foto WHERE idFoto=?";

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
			String query="update foto set numLike=? where idFoto=?";
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
			String query="SELECT numDislike FROM foto WHERE idFoto=?";

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
			String query="update foto set numDislike=? where idFoto=?";
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
	public boolean modificaTempoCancellazione(PostDB m, int n) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="update foto set tempoCancellazione=? where idFoto=?";
			st1 = conn.prepareStatement(query);
			st1.setInt(1, n);
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
			String query="update foto set isStory=? where idFoto=?";
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
}
