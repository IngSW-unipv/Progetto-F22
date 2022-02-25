package it.unipv.ings.MessaggioPrivato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Messaggio.MessaggioPrivato;
import it.unipv.ings.connessione.DBConnection;

public class MessaggioPrivatoDao implements IMessaggioPrivatoDao{

	private String schema;
	private Connection conn;


	public MessaggioPrivatoDao() {
		super();
		this.schema = "socialnetwork";
	}


	public ArrayList<MessaggioPrivato> selectAll() {

		ArrayList<MessaggioPrivato> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		Statement st1;
		ResultSet rs1;

		try
		{
			st1 = conn.createStatement();
			String query="SELECT * from messaggioprivato";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				MessaggioPrivato msg=new MessaggioPrivato(rs1.getString(1), rs1.getDate(2),rs1.getTime(3),rs1.getString(4),rs1.getString(5), rs1.getString(6),rs1.getString(7));

				result.add(msg);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}


	
	public boolean scriviMessaggioPrivato(MessaggioPrivato m) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="insert into messaggioprivato (idMsgPvt,dataInvio,oraInvio,testo,multimedia) values (?,?,?,?,?)";

			st1 = conn.prepareStatement(query);
			st1.setString(1, m.getIdMessaggio());
			st1.setDate(2, m.getDataInvio());
			st1.setTime(3, m.getOraInvio());
			st1.setString(4, m.getTesto());
			st1.setString(5, m.getMultimedia());
			
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}


	
	public boolean rimuoviMessaggioPrivato(MessaggioPrivato m) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;

		boolean esito=true;

		try
		{
			String query="delete from messaggioPrivato where idMsgPvt=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, m.getIdMessaggio());

			st1.executeUpdate();

		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}



	public ArrayList<MessaggioPrivato> cercaMessaggioPrivato(MessaggioPrivato m) {
		ArrayList<MessaggioPrivato> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM messaggioprivato WHERE idMsgPvt=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, m.getIdMessaggio());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				MessaggioPrivato msg=new MessaggioPrivato(rs1.getString(1), rs1.getDate(2),rs1.getTime(3),rs1.getString(4),rs1.getString(5), rs1.getString(6),rs1.getString(7));
				result.add(msg);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}


	@Override
	public boolean inserisciChiavi(MessaggioPrivato m) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="update messaggioPrivato set profiloInviante=?,profiloRicevente=? where idMsgPvt=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, m.getIdProfiloInviante());
			st1.setString(2, m.getIdProfiloInviante());
			st1.setString(3, m.getIdMessaggio());

			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}


	@Override
	public ArrayList<MessaggioPrivato> selectAllNomeProfilo(MessaggioPrivato m) {
		ArrayList<MessaggioPrivato> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM messaggioprivato WHERE profiloRicevente=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, m.getIdProfiloRicevente());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				MessaggioPrivato msg=new MessaggioPrivato(rs1.getString(1), rs1.getDate(2),rs1.getTime(3),rs1.getString(4),rs1.getString(5), rs1.getString(6),rs1.getString(7));
				result.add(msg);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}


	@Override
	public void ottieniMessaggio(MessaggioPrivato m) {
		
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT testo FROM messaggioprivato WHERE idMsgPvt=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, m.getIdMessaggio());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				System.out.println(rs1.getString(1));
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		
	}

}
