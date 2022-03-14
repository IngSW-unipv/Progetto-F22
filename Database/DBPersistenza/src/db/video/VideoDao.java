package db.video;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.connessione.DBConnection;


public class VideoDao implements IVideoDao{

	private Connection conn;
	private String schema;
	public VideoDao() {
		this.schema = "socialnetwork";
	}
	@Override
	public ArrayList<VideoDB> selectAll() {
		 ArrayList<VideoDB> result = new ArrayList<>();

			conn=DBConnection.startConnection(conn,schema);
			Statement st1;
			ResultSet rs1;

			try
			{
				st1 = conn.createStatement();
				String query="SELECT * from video order by idVideo";
				rs1=st1.executeQuery(query);

				while(rs1.next())
				{
					VideoDB v=new VideoDB(rs1.getString(1), rs1.getDate(2), rs1.getTime(3), rs1.getString(4), rs1.getInt(5), rs1.getInt(6), rs1.getBoolean(7), rs1.getBoolean(8), rs1.getString(9),rs1.getInt(10), rs1.getString(11),rs1.getBoolean(12), rs1.getInt(13));                                     

					result.add(v);
				}
			}catch (Exception e){e.printStackTrace();}

			DBConnection.closeConnection(conn);
			return result;
	}
	@Override
	public boolean pubblicaVideo(VideoDB v) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="insert into video (idVideo,dataPubblicazione,oraPubblicazione,descrizione,numLike,numDislike,visibile,condivisibile,profilo,tempoCancellazione,percorso,isStory,durataInSecondi) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

			st1 = conn.prepareStatement(query);
			st1.setString(1, v.getIdVideo());
			st1.setDate(2, v.getDataPubblicazione());
			st1.setTime(3, v.getOraPubblicazione());
		    st1.setString(4, v.getDescrizione());
			st1.setInt(5, v.getNumLike());
			st1.setInt(6, v.getNumDislike());
			st1.setBoolean(7, v.isVisibile());
			st1.setBoolean(8, v.isCondivisibile());
		    st1.setString(9, v.getProfilo());
			st1.setInt(10, v.getTempoCancellazione());
		    st1.setString(11, v.getPercorso());
		    st1.setBoolean(12, v.isStory());
		    st1.setInt(13, v.getDurataInSecondi());
		    
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
	
	@Override
	public boolean rimuoviVideo(VideoDB v) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;

		boolean esito=true;

		try
		{
			String query="delete from video where idVideo=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, v.getIdVideo());
			
			st1.executeUpdate();

		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
}
