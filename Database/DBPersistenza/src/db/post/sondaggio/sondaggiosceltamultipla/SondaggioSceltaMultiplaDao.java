package db.post.sondaggio.sondaggiosceltamultipla;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.connessione.DBConnection;
import db.post.PostDB;
import db.post.PostDao;
public class SondaggioSceltaMultiplaDao extends PostDao{

	private Connection conn;
	private String schema; 
	public SondaggioSceltaMultiplaDao() {
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
			String query="SELECT * from sondaggiosceltamultipla order by idSondaggio";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				SondaggioSceltaMultiplaDB sdb = new SondaggioSceltaMultiplaDB(rs1.getString(1), rs1.getDate(2), rs1.getTime(3), rs1.getString(4), rs1.getBoolean(5), rs1.getBoolean(6), rs1.getString(7), rs1.getString(8), rs1.getString(9), rs1.getString(10), rs1.getString(11));
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
			String query="insert into sondaggiosceltamultipla (idSondaggio,dataPubblicazione,oraPubblicazione,descrizione,visibile,condivisibile,profilo) values (?,?,?,?,?,?,?)";

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
			String query="update sondaggioSceltaMultipla set primaScelta=?, secondaScelta=?, terzaScelta=?, quartaScelta=? where idSondaggio=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, s[0]);
			st1.setString(2, s[1]);
			st1.setString(3, s[2]);
			st1.setString(4, s[3]);
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
	public PostDB cercaPost(PostDB s) {
		

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM sondaggiosceltamultipla WHERE idSondaggio=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, s.getIdPost());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				SondaggioSceltaMultiplaDB sdb = new SondaggioSceltaMultiplaDB(rs1.getString(1), rs1.getDate(2), rs1.getTime(3), rs1.getString(4), rs1.getBoolean(5), rs1.getBoolean(6), rs1.getString(7), rs1.getString(8), rs1.getString(9), rs1.getString(10), rs1.getString(11));

				DBConnection.closeConnection(conn);

				return sdb;
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return null;
	}

}