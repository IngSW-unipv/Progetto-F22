package db.messaggioDiGruppo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.connessione.DBConnection;

public class MessaggioDiGruppoDao implements IMessaggioDiGruppoDao{
	private String schema;
	private Connection conn;


	public MessaggioDiGruppoDao() {
		super();
		this.schema = "socialnetwork";
	}
	
    @Override
	public ArrayList<MessaggioDiGruppoDB> selectAll() {
		
		ArrayList<MessaggioDiGruppoDB> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		Statement st1;
		ResultSet rs1;

		try
		{
			st1 = conn.createStatement();
			String query="SELECT * from messaggiodigruppo order by idMsgGrp";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				MessaggioDiGruppoDB msg=new MessaggioDiGruppoDB(rs1.getString(1), rs1.getDate(2),rs1.getTime(3),rs1.getString(4),rs1.getString(5), rs1.getString(6));

				result.add(msg);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
		
	}

    @Override
	public boolean scriviMessaggioDiGruppo(MessaggioDiGruppoDB m) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="insert into messaggiodigruppo (idMsgGrp,dataInvio,oraInvio,testo,multimedia,gruppo) values (?,?,?,?,?,?)";

			st1 = conn.prepareStatement(query);
			st1.setString(1, m.getIdMsgGrp());
			st1.setDate(2, m.getDataInvio());
			st1.setTime(3, m.getOraInvio());
			st1.setString(4, m.getTesto());
			st1.setString(5, m.getMultimedia());
			st1.setString(6, m.getIdGruppo());
			
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}


    @Override
	public boolean rimuoviMessaggioDiGruppo(MessaggioDiGruppoDB m) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;

		boolean esito=true;

		try
		{
			String query="delete from messaggiodigruppo where idMsgGrp=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, m.getIdMsgGrp());

			st1.executeUpdate();

		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}

    @Override
	public ArrayList<MessaggioDiGruppoDB> cercaMessaggioDiGruppo(String m) {
		ArrayList<MessaggioDiGruppoDB> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM messaggiodigruppo WHERE idMsgGrp=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, m);

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				MessaggioDiGruppoDB msg=new MessaggioDiGruppoDB(rs1.getString(1), rs1.getDate(2),rs1.getTime(3),rs1.getString(4),rs1.getString(5), rs1.getString(6));

				result.add(msg);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}

	@Override
	public ArrayList<MessaggioDiGruppoDB> selectAllIdGruppo(MessaggioDiGruppoDB m) {
		ArrayList<MessaggioDiGruppoDB> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM messaggiodigruppo WHERE gruppo=? order by idMsgGrp";

			st1 = conn.prepareStatement(query);
			st1.setString(1, m.getIdGruppo());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				MessaggioDiGruppoDB msg=new MessaggioDiGruppoDB(rs1.getString(1), rs1.getDate(2),rs1.getTime(3),rs1.getString(4),rs1.getString(5), rs1.getString(6));

				result.add(msg);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}

	@Override
	public void ottieniTesto(MessaggioDiGruppoDB m) {
	
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT testo FROM messaggiodigruppo WHERE idMsgGrp=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, m.getIdMsgGrp());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				System.out.println(rs1.getString(1));
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		
	}

	
}
