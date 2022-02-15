package it.unipv.ings.Foto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.ings.connessione.DBConnection;

public class FotoDao implements IFotoDao{

	private Connection conn;
	private String schema;
	public FotoDao() {
		this.schema = "socialnetwork";
	}
	@Override
	public ArrayList<Foto> selectAll() {
		ArrayList<Foto> result = new ArrayList<>();

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
				Foto f=new Foto(rs1.getString(1),rs1.getString(2),rs1.getString(3));                                     

				result.add(f);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}
	@Override
	public boolean pubblicaFoto(Foto f) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="insert into foto (idFoto,percorso) values (?,?)";

			st1 = conn.prepareStatement(query);
			st1.setString(1, f.getIdFoto());
			st1.setString(2, f.getPerscorso());

			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
	
	@Override
	public boolean inserisciChiavi(Foto f) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="update foto set post=? where idFoto=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, f.getPost());
			st1.setString(2, f.getIdFoto());
			
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
	}
		DBConnection.closeConnection(conn);
		return esito;
	}
	@Override
	public boolean rimuoviFoto(Foto f) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;

		boolean esito=true;

		try
		{
			String query="delete from foto where idFoto=? and post=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, f.getIdFoto());
            st1.setString(2, f.getPost()); 
			
			st1.executeUpdate();

		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
}
