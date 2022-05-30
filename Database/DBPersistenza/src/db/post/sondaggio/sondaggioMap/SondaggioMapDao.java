package db.post.sondaggio.sondaggioMap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.connessione.DBConnection;

public class SondaggioMapDao implements ISondaggioMapDao{

	private Connection conn;
	private String schema;
	public SondaggioMapDao() {
		super();
		this.schema = "socialnetwork";
	}
	@Override
	public boolean carica(String profilo, String sondaggio) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="insert into sondaggiomap (profilo,sondaggio) values (?,?)";

			st1 = conn.prepareStatement(query);
			st1.setString(1, profilo);
			st1.setString(2, sondaggio);
			
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
	@Override
	public ArrayList<String> cerca(String profilo, String sondaggio) {
		ArrayList<String> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT profilo,sondaggio FROM sondaggiomap WHERE profilo=? and sondaggio=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, profilo);
			st1.setString(2, sondaggio);

			rs1=st1.executeQuery();

			while(rs1.next())
			{
                	result.add(rs1.getString("profilo"));
                	result.add(rs1.getString("sondaggio"));
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}
}
