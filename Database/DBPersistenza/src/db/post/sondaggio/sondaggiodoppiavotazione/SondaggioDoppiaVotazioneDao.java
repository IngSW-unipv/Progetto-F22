package db.post.sondaggio.sondaggiodoppiavotazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.commento.CommentoDB;
import db.connessione.DBConnection;
import db.post.PostDB;
import db.post.PostDao;

public class SondaggioDoppiaVotazioneDao extends PostDao {
private Connection conn;
private String schema; 
public SondaggioDoppiaVotazioneDao() {
	this.schema="socialnetwork";
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
			String query="SELECT * from sondaggiodoppiavotazione order by idSondaggio";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				SondaggioDoppiaVotazioneDB sdb = new SondaggioDoppiaVotazioneDB(rs1.getString(1), rs1.getDate(2), rs1.getTime(3), rs1.getString(4), rs1.getInt(5),rs1.getInt(6),rs1.getBoolean(7), rs1.getString(8), rs1.getString(9), rs1.getString(10),rs1.getInt(11),rs1.getInt(12));
				result.add(sdb);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
}

@Override
public boolean caricaPost(PostDB s) {
	conn=DBConnection.startConnection(conn,schema);
	PreparedStatement st1;
	boolean esito = true;

	try
	{
		String query="insert into sondaggiodoppiavotazione (idSondaggio,dataPubblicazione,oraPubblicazione,descrizione,numLike,numDislike,visibile,profilo) values (?,?,?,?,?,?,?,?)";

		st1 = conn.prepareStatement(query);
		st1.setString(1, s.getIdPost());
		st1.setDate(2, s.getDataPubblicazione());
		st1.setTime(3, s.getOraPubblicazione());
		st1.setString(4, s.getDescrizione());
		st1.setInt(5, s.getNumLike());
		st1.setInt(6, s.getNumDislike());
        st1.setBoolean(7, s.isVisibile());
        st1.setString(8, s.getProfilo());
        
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
		String query="update sondaggioDoppiaVotazione set primaScelta=?, secondaScelta=?, count1s=?,count2s=? where idSondaggio=?";

		st1 = conn.prepareStatement(query);
		st1.setString(1, s[0]);
		st1.setString(2, s[1]);
		st1.setInt(3, 0);
		st1.setInt(4, 0);
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
public boolean eliminaPost(PostDB p) {
	conn=DBConnection.startConnection(conn,schema);
	PreparedStatement st1;
	
	boolean esito=true;

	try
	{
		String query="delete from sondaggiodoppiavotazione where idSondaggio=? ";
		st1 = conn.prepareStatement(query);
        st1.setString(1, p.getIdPost());
		
		st1.executeUpdate();

	}catch (Exception e){
		e.printStackTrace();
		esito=false;
	}

	DBConnection.closeConnection(conn);
	return esito;
}
@Override
public PostDB cercaPost(PostDB s) {

	conn=DBConnection.startConnection(conn,schema);
	PreparedStatement st1;
	ResultSet rs1;

	try
	{
		String query="SELECT * FROM sondaggiodoppiavotazione WHERE idSondaggio=?";

		st1 = conn.prepareStatement(query);
		st1.setString(1, s.getIdPost());

		rs1=st1.executeQuery();

		while(rs1.next())
		{
			SondaggioDoppiaVotazioneDB sdb = new SondaggioDoppiaVotazioneDB(rs1.getString(1), rs1.getDate(2), rs1.getTime(3), rs1.getString(4), rs1.getInt(5),rs1.getInt(6),rs1.getBoolean(7), rs1.getString(8), rs1.getString(9), rs1.getString(10),rs1.getInt(11),rs1.getInt(12));

			DBConnection.closeConnection(conn);
            return sdb;
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
		String query="SELECT idSondaggio,percorso FROM sondaggiodoppiavotazione WHERE profilo=? order by dataPubblicazione,oraPubblicazione";

		st1 = conn.prepareStatement(query);
		st1.setString(1, idProfilo);

		rs1=st1.executeQuery();

		while(rs1.next())
		{
            	result.add(rs1.getString("idSondaggio"));
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
		String query="SELECT * FROM commento WHERE idSDV=? order by dataCommento,oraCommento";

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
			String query="SELECT testo FROM commento WHERE idSDV=? order by dataCommento, oraCommento";

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
		String query="update sondaggiodoppiavotazione set visibile=? where idSondaggio=?";
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
		String query="SELECT visibile FROM sondaggiodoppiavotazione WHERE idSondaggio=?";

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
		String query="SELECT numLike FROM sondaggiodoppiavotazione WHERE idSondaggio=?";

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
		String query="update sondaggiodoppiavotazione set numLike=? where idSondaggio=?";
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
		String query="SELECT numDislike FROM sondaggiodoppiavotazione WHERE idSondaggio=?";

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
		String query="update sondaggiodoppiavotazione set numDislike=? where idSondaggio=?";
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

public int vediCount1s(PostDB p) {
	conn=DBConnection.startConnection(conn,schema);
	PreparedStatement st1;
	ResultSet rs1;

	try
	{
		String query="SELECT count1s FROM sondaggiodoppiavotazione WHERE idSondaggio=?";

		st1 = conn.prepareStatement(query);
		st1.setString(1, p.getIdPost());

		rs1=st1.executeQuery();

		while(rs1.next())
		{
			int i = rs1.getInt("count1s");
			DBConnection.closeConnection(conn);
			return i;
		
		}
	}catch (Exception e){e.printStackTrace();}
	return -1;
}

public boolean modificaCount1s(PostDB p, int n) {
	conn=DBConnection.startConnection(conn,schema);
	PreparedStatement st1;
	boolean esito = true;

	try
	{
		String query="update sondaggiodoppiavotazione set count1s=? where idSondaggio=?";
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

public int vediCount2s(PostDB p) {
	conn=DBConnection.startConnection(conn,schema);
	PreparedStatement st1;
	ResultSet rs1;

	try
	{
		String query="SELECT count2s FROM sondaggiodoppiavotazione WHERE idSondaggio=?";

		st1 = conn.prepareStatement(query);
		st1.setString(1, p.getIdPost());

		rs1=st1.executeQuery();

		while(rs1.next())
		{
			int i = rs1.getInt("count2s");
			DBConnection.closeConnection(conn);
			return i;
		
		}
	}catch (Exception e){e.printStackTrace();}
	return -1;
}
public boolean modificaCount2s(PostDB p, int n) {
	conn=DBConnection.startConnection(conn,schema);
	PreparedStatement st1;
	boolean esito = true;

	try
	{
		String query="update sondaggiodoppiavotazione set count2s=? where idSondaggio=?";
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
public boolean modificaTempoCancellazione(PostDB m, int t) {
	return false;
}
@Override
public boolean modificaIsStory(PostDB m, boolean b) {
	return false;
}


}
