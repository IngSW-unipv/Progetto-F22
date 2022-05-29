package db.LikeDislike.LikeMap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.connessione.DBConnection;

public class LikeMapDao implements ILikeMapDao{

	private Connection conn;
	private String schema;
	public LikeMapDao() {
		super();
		this.schema = "socialnetwork";
	}
	@Override
	public boolean carica(String profilo, String post) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="insert into likemap (profilo,post) values (?,?)";

			st1 = conn.prepareStatement(query);
			st1.setString(1, profilo);
			st1.setString(2, post);
			
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}

	@Override
	public boolean rimuovi(String profilo, String post) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;

		boolean esito=true;

		try
		{
			String query="delete from likemap where profilo=? and post=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, profilo);
            st1.setString(2, post);
			
			st1.executeUpdate();

		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
	@Override
	public ArrayList<String> cerca(String profilo, String post) {
		ArrayList<String> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT profilo,post FROM likemap WHERE profilo=? and post=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, profilo);
			st1.setString(2, post);

			rs1=st1.executeQuery();

			while(rs1.next())
			{
                	result.add(rs1.getString("profilo"));
                	result.add(rs1.getString("post"));
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
		
	}

}
