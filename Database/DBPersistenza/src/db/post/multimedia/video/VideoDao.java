package db.post.multimedia.video;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.connessione.DBConnection;
import db.post.PostDB;
import db.post.PostDao;


public class VideoDao  extends PostDao {

	private Connection conn;
	private String schema;
	public VideoDao() {
		this.schema = "socialnetwork";
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
				String query="SELECT * from video order by idVideo";
				rs1=st1.executeQuery(query);

				while(rs1.next())
				{
					VideoDB vdb =new VideoDB(rs1.getString(1), rs1.getDate(2), rs1.getTime(3), rs1.getString(4),rs1.getBoolean(5), rs1.getBoolean(6), rs1.getString(7), rs1.getString(8), rs1.getInt(9));                                     

					result.add(vdb);
				}
			}catch (Exception e){e.printStackTrace();}

			DBConnection.closeConnection(conn);
			return result;
	}
	
	@Override
	public boolean caricaPost(PostDB v) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="insert into video (idVideo,dataPubblicazione,oraPubblicazione,descrizione,numLike,numDislike,visibile,condivisibile,profilo) values (?,?,?,?,?,?,?,?,?)";

			st1 = conn.prepareStatement(query);
			st1.setString(1, v.getIdPost());
			st1.setDate(2, v.getDataPubblicazione());
			st1.setTime(3, v.getOraPubblicazione());
		    st1.setString(4, v.getDescrizione());
			st1.setInt(5, v.getNumLike());
			st1.setInt(6, v.getNumDislike());
			st1.setBoolean(7, v.isVisibile());
			st1.setBoolean(8, v.isCondivisibile());
		    st1.setString(9, v.getProfilo());
		    
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
			String query="update video set tempoCancellazione=?, percorso=?, isStory=?, durataInSecondi=? where idVideo=?";

			st1 = conn.prepareStatement(query);
			st1.setInt(1, 0);
			st1.setString(2, s[0]);
			st1.setBoolean(3, false);
			st1.setInt(4, i);
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
	public boolean eliminaPost(PostDB v) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;

		boolean esito=true;

		try
		{
			String query="delete from video where idVideo=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, v.getIdPost());
			
			st1.executeUpdate();

		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
	@Override
	public PostDB cercaPost(PostDB v) {

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM video WHERE idVideo=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, v.getIdPost());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				VideoDB vdb =new VideoDB(rs1.getString(1), rs1.getDate(2), rs1.getTime(3), rs1.getString(4),rs1.getBoolean(5), rs1.getBoolean(6), rs1.getString(7), rs1.getString(8), rs1.getInt(9));                                     
				DBConnection.closeConnection(conn);

				return vdb;
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return null;
	}

}
