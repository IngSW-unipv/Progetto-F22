package db.messaggioPrivato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.connessione.DBConnection;

public class MessaggioPrivatoDao implements IMessaggioPrivatoDao{

	private String schema;
	private Connection conn;


	public MessaggioPrivatoDao() {
		super();
		this.schema = "socialnetwork";
	}

    @Override
	public ArrayList<MessaggioPrivatoDB> selectAll() {

		ArrayList<MessaggioPrivatoDB> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		Statement st1;
		ResultSet rs1;

		try
		{
			st1 = conn.createStatement();
			String query="SELECT * from messaggioprivato order by idMsgPvt";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				MessaggioPrivatoDB msg=new MessaggioPrivatoDB(rs1.getString(1), rs1.getDate(2),rs1.getTime(3),rs1.getString(4),rs1.getString(5), rs1.getString(6),rs1.getString(7));

				result.add(msg);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}


	@Override
	public boolean scriviMessaggioPrivato(MessaggioPrivatoDB m) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="insert into messaggioprivato (idMsgPvt,dataInvio,oraInvio,testo,multimedia,profiloInviante,profiloRicevente) values (?,?,?,?,?,?,?)";

			st1 = conn.prepareStatement(query);
			st1.setString(1, m.getIdMsgPvt());
			st1.setDate(2, m.getDataInvio());
			st1.setTime(3, m.getOraInvio());
			st1.setString(4, m.getTesto());
			st1.setString(5, m.getMultimedia());
			st1.setString(6, m.getProfiloInviante());
			st1.setString(7, m.getProfiloRicevente());
			
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}


	@Override
	public boolean rimuoviMessaggioPrivato(MessaggioPrivatoDB m) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;

		boolean esito=true;

		try
		{
			String query="delete from messaggioPrivato where idMsgPvt=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, m.getIdMsgPvt());

			st1.executeUpdate();

		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}


    @Override
	public ArrayList<MessaggioPrivatoDB> cercaMessaggioPrivato(MessaggioPrivatoDB m) {
		ArrayList<MessaggioPrivatoDB> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM messaggioprivato WHERE idMsgPvt=? order by idMsgPvt";

			st1 = conn.prepareStatement(query);
			st1.setString(1, m.getIdMsgPvt());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				MessaggioPrivatoDB msg=new MessaggioPrivatoDB(rs1.getString(1), rs1.getDate(2),rs1.getTime(3),rs1.getString(4),rs1.getString(5), rs1.getString(6),rs1.getString(7));
				result.add(msg);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}

	@Override
	public ArrayList<MessaggioPrivatoDB> selectAllNomeProfilo(MessaggioPrivatoDB m) {
		ArrayList<MessaggioPrivatoDB> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;
		
		try
		{
			String query="SELECT * FROM messaggioprivato WHERE profiloRicevente=? order by idMsgPvt";

			st1 = conn.prepareStatement(query);
			st1.setString(1, m.getIdMsgPvt());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				MessaggioPrivatoDB msg=new MessaggioPrivatoDB(rs1.getString(1), rs1.getDate(2),rs1.getTime(3),rs1.getString(4),rs1.getString(5), rs1.getString(6),rs1.getString(7));
				result.add(msg);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}


	@Override
	public void ottieniMessaggio(MessaggioPrivatoDB m) {
		
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT testo FROM messaggioprivato WHERE idMsgPvt=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, m.getIdMsgPvt());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				System.out.println(rs1.getString(1));
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		
	}

}
