package it.unipv.ings.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.ings.connessione.DBConnection;
import post.Post;

public class PostDao implements IPostDao{
private Connection conn;
private String schema;
public PostDao() {
	this.schema = "socialnetwork";
}
@Override
public ArrayList<Post> selectAll() {
     ArrayList<Post> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		Statement st1;
		ResultSet rs1;

		try
		{
			st1 = conn.createStatement();
			String query="SELECT * from post";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				Post p=new Post(rs1.getString(1), rs1.getDate(2),rs1.getTime(3),rs1.getString(4),rs1.getInt(5),rs1.getInt(6),rs1.getBoolean(7),rs1.getBoolean(8),rs1.getBoolean(9),rs1.getString(10));                                     

				result.add(p);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
}
@Override
public boolean pubblicaPost(Post p) {
	conn=DBConnection.startConnection(conn,schema);
	PreparedStatement st1;
	boolean esito = true;

	try
	{
		String query="insert into post (idPost,dataPubblicazione,oraPubblicazione,Descrizione,numLike,numDislike,visibile,isStory,condivisibile) values (?,?,?,?,?,?,?,?,?)";

		st1 = conn.prepareStatement(query);
		st1.setString(1, p.getIdPost());
		st1.setDate(2, p.getDataPubblicazione());
		st1.setTime(3, p.getOraPubblicazione());
		st1.setString(4, p.getDescrizione());
		st1.setInt(5, p.getNumLike());
		st1.setInt(6, p.getNumDislike());
		st1.setBoolean(7, p.isVisibile());
		st1.setBoolean(8, p.isStory());
		st1.setBoolean(9, p.isCondivisibile());
		
		st1.executeUpdate();


	}catch (Exception e){
		e.printStackTrace();
		esito=false;
	}

	DBConnection.closeConnection(conn);
	return esito;
}
@Override
public boolean inserisciChiavi(Post p) {
	conn=DBConnection.startConnection(conn,schema);
	PreparedStatement st1;
	boolean esito = true;

	try
	{
		String query="update post set profilo=? where idPost=?";
		st1 = conn.prepareStatement(query);
		st1.setString(1, p.getProfilo());
		st1.setString(2, p.getIdPost());
		
		st1.executeUpdate();


	}catch (Exception e){
		e.printStackTrace();
		esito=false;
}
	DBConnection.closeConnection(conn);
	return esito;
}
@Override
public boolean rimuoviPost(Post p) {
	conn=DBConnection.startConnection(conn,schema);
	PreparedStatement st1;

	boolean esito=true;

	try
	{
		String query="delete from post where idPost=?";
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


}
