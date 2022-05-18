package db.post.multimedia.foto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.connessione.DBConnection;
import db.post.PostDB;
import db.post.PostDao;

public class FotoDao extends PostDao{

	private Connection conn;
	private String schema;
	public FotoDao() {
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
			String query="SELECT * from foto order by idFoto";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				FotoDB fdb=new FotoDB(rs1.getString(1),rs1.getDate(2),rs1.getTime(3), rs1.getString(4), rs1.getBoolean(5), rs1.getBoolean(6), rs1.getString(7), rs1.getString(8), rs1.getBoolean(9));                                     

				result.add(fdb);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}
	
	@Override
	public boolean caricaPost(PostDB f) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="insert into foto (idFoto,dataPubblicazione,oraPubblicazione,descrizione,numLike,numDislike,visibile,condivisibile,profilo) values (?,?,?,?,?,?,?,?,?)";

			st1 = conn.prepareStatement(query);
			st1.setString(1, f.getIdPost());
			st1.setDate(2, f.getDataPubblicazione());
			st1.setTime(3, f.getOraPubblicazione());
		    st1.setString(4, f.getDescrizione());
			st1.setInt(5, f.getNumLike());
			st1.setInt(6, f.getNumDislike());
			st1.setBoolean(7, f.isVisibile());
			st1.setBoolean(8, f.isCondivisibile());
		    st1.setString(9, f.getProfilo());
		 
		    
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
	
	
	@Override
	public boolean inserisciChiavi(PostDB p, String [] s, int i, boolean b) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="update foto set tempoCancellazione=?, percorso=?, isStory=?, isHd=? where idFoto=?";

			st1 = conn.prepareStatement(query);
			st1.setInt(1, 0);
			st1.setString(2, s[0]);
			st1.setBoolean(3, false);
			st1.setBoolean(4, b);
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
	public boolean eliminaPost(PostDB f) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;

		boolean esito=true;

		try
		{
			String query="delete from foto where idFoto=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, f.getIdPost());
           
			st1.executeUpdate();

		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
	
	@Override
	public PostDB cercaPost(PostDB p) {

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM foto WHERE idFoto=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, p.getIdPost());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				FotoDB fdb=new FotoDB(rs1.getString(1),rs1.getDate(2),rs1.getTime(3), rs1.getString(4), rs1.getBoolean(5), rs1.getBoolean(6), rs1.getString(7), rs1.getString(8), rs1.getBoolean(9));                                     
				DBConnection.closeConnection(conn);

				return fdb;
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return null;
	}

}
