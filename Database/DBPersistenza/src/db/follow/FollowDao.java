package db.follow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import db.connessione.DBConnection;

public class FollowDao implements IFollowDao{

	private Connection conn;
	private String schema;
	
	public FollowDao() {
		this.schema = "socialnetwork";
	}
	@Override
	public boolean carica(FollowDB f) {
		conn = DBConnection.startConnection(conn, schema);
		PreparedStatement st1;
		boolean esito = true;
		
		String query = "insert into follow (profiloPersonale,profiloSeguito) values(?,?)";
		try {
			st1 = conn.prepareStatement(query);
			st1.setString(1, f.getProfiloPersonale());
			st1.setString(2, f.getProfiloSeguito());
			st1.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			esito = false;
		}
		DBConnection.closeConnection(conn);
		return esito;
		
	}
	@Override
	public boolean rimuovi(FollowDB f) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;

		boolean esito=true;

		try
		{
			String query="delete from follow where profiloPersonale=? and profiloSeguito=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, f.getProfiloPersonale());
			st1.setString(2, f.getProfiloSeguito());

			st1.executeUpdate();

		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
	@Override
	public ArrayList<FollowDB> selectAll() {
		ArrayList<FollowDB> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		Statement st1;
		ResultSet rs1;

		try
		{
			st1 = conn.createStatement();
			String query="SELECT * from follow order by profiloPersonale";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				FollowDB f=new FollowDB(rs1.getString(1), rs1.getString(2));                                     

				result.add(f);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}
	
	@Override
	public ArrayList<String> cercaProfSeguito(String s1) {
		ArrayList<String> res = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT profiloSeguito FROM follow WHERE profiloPersonale=? order by profiloSeguito";

			st1 = conn.prepareStatement(query);
			st1.setString(1, s1);

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				res.add(rs1.getString(1));
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return res;
	}
	
	@Override
	public FollowDB cerca(FollowDB fdb) {

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM follow WHERE profiloPersonale=? and profiloSeguito=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, fdb.getProfiloPersonale());
            st1.setString(2, fdb.getProfiloSeguito());
			
			rs1=st1.executeQuery();

			while(rs1.next())
			{
				FollowDB com = new FollowDB(rs1.getString(1),rs1.getString(2));

				DBConnection.closeConnection(conn);
				return com;
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return null;
	}

}
