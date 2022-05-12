package db.post.multimedia.foto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.connessione.DBConnection;
import db.post.PostDB;
import db.post.PostDao;
import post.Post;

public class FotoDao extends PostDao{

	private Connection conn;
	private String schema;
	public FotoDao() {
		this.schema = "socialnetwork";
	}
	@Override
	public ArrayList<FotoDB> selectAll() {
		ArrayList<FotoDB> result = new ArrayList<>();

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
				FotoDB f=new FotoDB(rs1.getString(1),rs1.getDate(2),rs1.getTime(3), rs1.getString(4), rs1.getInt(5), rs1.getInt(6), rs1.getBoolean(7), rs1.getBoolean(8), rs1.getString(9), rs1.getInt(10), rs1.getString(11), rs1.getBoolean(12), rs1.getBoolean(13));                                     

				result.add(f);
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
	public boolean inserisciChiavi(PostDB p, String s1, String s2, String s3, String s4, int i1, int i2, boolean b1,
			boolean b2) {
		// TODO Auto-generated method stub
		return false;
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
	public ArrayList<FotoDB> cercaFoto(String f) {
		ArrayList<FotoDB> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM foto WHERE idFoto=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, f);

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				FotoDB fdb=new FotoDB(rs1.getString(1),rs1.getDate(2),rs1.getTime(3), rs1.getString(4), rs1.getInt(5), rs1.getInt(6), rs1.getBoolean(7), rs1.getBoolean(8), rs1.getString(9), rs1.getInt(10), rs1.getString(11), rs1.getBoolean(12), rs1.getBoolean(13));                                     

				result.add(fdb);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}

}
