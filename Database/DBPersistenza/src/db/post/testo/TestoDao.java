package db.post.testo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
	public ArrayList<TestoDB> selectAll() {
		 ArrayList<TestoDB> result = new ArrayList<>();

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
					TestoDB t=new TestoDB(rs1.getString(1), rs1.getDate(2), rs1.getTime(3), rs1.getString(4), rs1.getInt(5), rs1.getInt(6), rs1.getBoolean(7), rs1.getBoolean(8), rs1.getString(9),rs1.getString(10),rs1.getString(11));                                     

					result.add(t);
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
			String query="insert into testo (idTesto,dataPubblicazione,oraPubblicazione,descrizione,numLike,numDislike,visibile,condivisibile,profilo) values (?,?,?,?,?,?,?,?,?)";

			st1 = conn.prepareStatement(query);
			st1.setString(1, t.getIdPost());
			st1.setDate(2, t.getDataPubblicazione());
			st1.setTime(3, t.getOraPubblicazione());
			st1.setString(4, t.getDescrizione());
		    st1.setInt(5, t.getNumLike());
		    st1.setInt(6, t.getNumDislike());
		    st1.setBoolean(7, t.isVisibile());
		    st1.setBoolean(8, t.isCondivisibile());
		    st1.setString(9, t.getProfilo());
		    
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
	public ArrayList<TestoDB> cercaTesto(String t) {
		ArrayList<TestoDB> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM testo WHERE idTesto=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, t);

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				TestoDB tdb =new TestoDB(rs1.getString(1), rs1.getDate(2), rs1.getTime(3), rs1.getString(4), rs1.getInt(5), rs1.getInt(6), rs1.getBoolean(7), rs1.getBoolean(8), rs1.getString(9),rs1.getString(10),rs1.getString(11));                                     

				result.add(tdb);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}
	
}
