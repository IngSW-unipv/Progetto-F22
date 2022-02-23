package it.unipv.ings.Video;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.ings.connessione.DBConnection;

public class VideoDao implements IVideoDao{

	private Connection conn;
	private String schema;
	public VideoDao() {
		this.schema = "socialnetwork";
	}
	@Override
	public ArrayList<Video> selectAll() {
		 ArrayList<Video> result = new ArrayList<>();

			conn=DBConnection.startConnection(conn,schema);
			Statement st1;
			ResultSet rs1;

			try
			{
				st1 = conn.createStatement();
				String query="SELECT * from video";
				rs1=st1.executeQuery(query);

				while(rs1.next())
				{
					Video v=new Video(rs1.getString(1), rs1.getInt(2),rs1.getString(3),rs1.getString(4));                                     

					result.add(v);
				}
			}catch (Exception e){e.printStackTrace();}

			DBConnection.closeConnection(conn);
			return result;
	}
	@Override
	public boolean pubblicaVideo(Video v) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="insert into video (idVideo,durata,percorso,post) values (?,?,?,?)";

			st1 = conn.prepareStatement(query);
			st1.setString(1, v.getIdVideo());
			st1.setInt(2, v.getDurata());
			st1.setString(3, v.getPercorso());
		    st1.setString(4, v.getPost());
			
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
	
	@Override
	public boolean rimuoviVideo(Video v) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;

		boolean esito=true;

		try
		{
			String query="delete from video where idVideo=? and post=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, v.getIdVideo());
			st1.setString(2, v.getPost());
			
			st1.executeUpdate();

		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
}
