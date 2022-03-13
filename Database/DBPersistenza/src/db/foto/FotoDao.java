package db.foto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.connessione.DBConnection;

public class FotoDao implements IFotoDao{

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
			String query="SELECT * from foto";
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
	public boolean pubblicaFoto(FotoDB f) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="insert into foto (idFoto,dataPubblicazione,oraPubblicazione,descrizione,numLike,numDislike,visibile,condivisibile,profilo,tempoCancellazione,percorso,isStory,isHd) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

			st1 = conn.prepareStatement(query);
			st1.setString(1, f.getIdFoto());
			st1.setDate(2, f.getDataPubblicazione());
			st1.setTime(3, f.getOraPubblicazione());
		    st1.setString(4, f.getDescrizione());
			st1.setInt(5, f.getNumLike());
			st1.setInt(6, f.getNumDislike());
			st1.setBoolean(7, f.isVisibile());
			st1.setBoolean(8, f.isCondivisibile());
		    st1.setString(9, f.getProfilo());
		    st1.setInt(10, f.getTempoCancellazione());
		    st1.setString(11, f.getPercorso());
		    st1.setBoolean(12, f.isStory());
		    st1.setBoolean(13, f.isHd);
		    
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
	
	@Override
	public boolean rimuoviFoto(FotoDB f) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;

		boolean esito=true;

		try
		{
			String query="delete from foto where idFoto=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, f.getIdFoto());
           
			st1.executeUpdate();

		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
}
