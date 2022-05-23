package db.post.sondaggio.sondaggiodoppiavotazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
				SondaggioDoppiaVotazioneDB sdb = new SondaggioDoppiaVotazioneDB(rs1.getString(1), rs1.getDate(2), rs1.getTime(3), rs1.getString(4), rs1.getBoolean(5), rs1.getBoolean(6), rs1.getString(7), rs1.getString(8), rs1.getString(9));
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
		String query="insert into sondaggiodoppiavotazione (idSondaggio,dataPubblicazione,oraPubblicazione,descrizione,visibile,condivisibile,profilo) values (?,?,?,?,?,?,?)";

		st1 = conn.prepareStatement(query);
		st1.setString(1, s.getIdPost());
		st1.setDate(2, s.getDataPubblicazione());
		st1.setTime(3, s.getOraPubblicazione());
		st1.setString(4, s.getDescrizione());
        st1.setBoolean(5, s.isVisibile());
        st1.setBoolean(6, s.isCondivisibile());
        st1.setString(7, s.getProfilo());
        
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
		String query="update sondaggioDoppiaVotazione set primaScelta=?, secondaScelta=? where idSondaggio=?";

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
			SondaggioDoppiaVotazioneDB sdb = new SondaggioDoppiaVotazioneDB(rs1.getString(1), rs1.getDate(2), rs1.getTime(3), rs1.getString(4), rs1.getBoolean(5), rs1.getBoolean(6), rs1.getString(7), rs1.getString(8), rs1.getString(9));

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
		String query="SELECT idSondaggio FROM sondaggiodoppiavotazione WHERE profilo=? order by dataPubblicazione,oraPubblicazione";

		st1 = conn.prepareStatement(query);
		st1.setString(1, idProfilo);

		rs1=st1.executeQuery();

		while(rs1.next())
		{
            	result.add(rs1.getString("idSondaggio"));
		}
	}catch (Exception e){e.printStackTrace();}

	DBConnection.closeConnection(conn);
	return result;
}



}
