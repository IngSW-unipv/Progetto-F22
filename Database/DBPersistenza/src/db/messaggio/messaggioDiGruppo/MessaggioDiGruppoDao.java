package db.messaggio.messaggioDiGruppo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.connessione.DBConnection;
import db.messaggio.MessaggioDB;
import db.messaggio.MessaggioDao;

public class MessaggioDiGruppoDao extends MessaggioDao {
	private String schema;
	private Connection conn;


	public MessaggioDiGruppoDao() {
		super();
		this.schema = "socialnetwork";
	}
	

    @Override
	public boolean scriviMessaggio(MessaggioDB m) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="insert into messaggiodigruppo (idMsgGrp,dataInvio,oraInvio,testo,multimedia) values (?,?,?,?,?)";

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

 
    

    @Override
	public boolean inserisciChiavi(MessaggioDB m, String s1, String s2) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="update messaggiodigruppo set gruppo=? where idMsgGrp=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, s1);
			st1.setString(2, m.getIdMessaggio());
			
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
		
		
	}
  
   
    

    
    @Override
	public boolean rimuoviMessaggio(MessaggioDB m) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;

		boolean esito=true;

		try
		{
			String query="delete from messaggiodigruppo where idMsgGrp=?";
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

    
    
    @Override
	public MessaggioDB cercaMessaggio(MessaggioDB m) {
		

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM messaggiodigruppo WHERE idMsgGrp=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, m.getIdMessaggio());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				MessaggioDiGruppoDB msg=new MessaggioDiGruppoDB(rs1.getString(1), rs1.getDate(2),rs1.getTime(3),rs1.getString(4),rs1.getString(5), rs1.getString(6));
				DBConnection.closeConnection(conn);
             	return msg;
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return null;
	}

    
    
	@Override
	public ArrayList<MessaggioDB> selezionaMessaggi(String s) {
		ArrayList<MessaggioDB> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM messaggiodigruppo WHERE gruppo=? order by idMsgGrp";

			st1 = conn.prepareStatement(query);
			st1.setString(1, s);

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
	public String ottieniTestoMessaggio(String m) {
	
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT testo FROM messaggiodigruppo WHERE idMsgGrp=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, m);

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				String s = rs1.getString("testo");
				DBConnection.closeConnection(conn);
				return s;
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return null;
	}


	@Override
	public ArrayList<String> ottieniTestoListaMessaggi(String m) {

		ArrayList<String> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT testo FROM messaggiodigruppo WHERE gruppo=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, m);

			rs1=st1.executeQuery();

			while(rs1.next())
			{
                	result.add(rs1.getString("testo"));
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
		
	}

	
}
