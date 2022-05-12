package db.post.sondaggio.sondaggiosceltamultipla;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.connessione.DBConnection;
import db.post.PostDB;
import db.post.PostDao;
public class SondaggioSceltaMultiplaDao extends PostDao implements ISondaggioSceltaMultiplaDao{

	private Connection conn;
	private String schema; 
	public SondaggioSceltaMultiplaDao() {
		this.schema="socialnetwork";
	}
	
	@Override
	public ArrayList<SondaggioSceltaMultiplaDB> selectAll() {
		ArrayList<SondaggioSceltaMultiplaDB> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		Statement st1;
		ResultSet rs1;

		try
		{
			st1 = conn.createStatement();
			String query="SELECT * from sondaggiosceltamultipla order by idSondaggio";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
			SondaggioSceltaMultiplaDB s = new SondaggioSceltaMultiplaDB(rs1.getString(1), rs1.getDate(2), rs1.getTime(3), rs1.getString(4), rs1.getInt(5), rs1.getInt(6), rs1.getBoolean(7), rs1.getBoolean(8), rs1.getString(9), rs1.getString(10), rs1.getString(11), rs1.getString(12), rs1.getString(13));
				result.add(s);
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
			String query="insert into sondaggiosceltamultipla (idSondaggio,dataPubblicazione,oraPubblicazione,descrizione,numLike,numDislike,visibile,condivisibile,profilo) values (?,?,?,?,?,?,?,?,?)";

			st1 = conn.prepareStatement(query);
			st1.setString(1, s.getIdPost());
			st1.setDate(2, s.getDataPubblicazione());
			st1.setTime(3, s.getOraPubblicazione());
			st1.setString(4, s.getDescrizione());
			st1.setInt(5, s.getNumLike());
	        st1.setInt(6, s.getNumDislike());
	        st1.setBoolean(7, s.isVisibile());
	        st1.setBoolean(8, s.isCondivisibile());
	        st1.setString(9, s.getProfilo());
	        
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
			String query="delete from sondaggiosceltamultipla where idSondaggio=? ";
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
	public ArrayList<SondaggioSceltaMultiplaDB> cerca(String s) {
		ArrayList<SondaggioSceltaMultiplaDB> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM sondaggiosceltamultipla WHERE idSondaggio=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, s);

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				SondaggioSceltaMultiplaDB sdb = new SondaggioSceltaMultiplaDB(rs1.getString(1), rs1.getDate(2), rs1.getTime(3), rs1.getString(4), rs1.getInt(5), rs1.getInt(6), rs1.getBoolean(7), rs1.getBoolean(8), rs1.getString(9), rs1.getString(10), rs1.getString(11), rs1.getString(12), rs1.getString(13));

				result.add(sdb);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}

}
