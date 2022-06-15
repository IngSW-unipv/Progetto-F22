package db.messaggio.messaggioPrivato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.connessione.DBConnection;
import db.messaggio.MessaggioDB;
import db.messaggio.MessaggioDao;
import db.profilo.ProfiloDB;

public class MessaggioPrivatoDao extends MessaggioDao {

	private String schema;
	private Connection conn;


	public MessaggioPrivatoDao() {
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
			String query="insert into messaggioprivato (idMsgPvt,dataInvio,oraInvio,testo) values (?,?,?,?)";

			st1 = conn.prepareStatement(query);
			st1.setString(1, m.getIdMessaggio());
			st1.setDate(2, m.getDataInvio());
			st1.setTime(3, m.getOraInvio());
			st1.setString(4, m.getTesto());
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
			String query="update messaggioprivato set profiloInviante=?,profiloRicevente=? where idMsgPvt=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, s1);
			st1.setString(2, s2);
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
	public boolean rimuoviMessaggio(MessaggioDB m) {
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


    @Override
	public MessaggioDB cercaMessaggio(MessaggioDB m) {
	
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM messaggioprivato WHERE idMsgPvt=? ";

			st1 = conn.prepareStatement(query);
			st1.setString(1, m.getIdMessaggio());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				MessaggioPrivatoDB msg=new MessaggioPrivatoDB(rs1.getString(1), rs1.getDate(2),rs1.getTime(3),rs1.getString(4),rs1.getString(5), rs1.getString(6));
				DBConnection.closeConnection(conn);
                return msg;
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return null;
	}
    
    @Override
   	public ArrayList<MessaggioDB> caricaMessaggiChatPrivata(String inviante, String ricevente) {
    	ArrayList<MessaggioDB> result = new ArrayList<>();
    	
   		conn=DBConnection.startConnection(conn,schema);
   		PreparedStatement st1;
   		
   		ResultSet rs1;

   		try
   		{
   			String query= "select testo, profiloInviante, profiloRicevente from messaggioprivato where(profiloinviante= ? and profiloRicevente =?) or (profiloinviante=? and profiloRicevente=?) order by dataInvio, oraInvio";

   			st1 = conn.prepareStatement(query);
			st1.setString(1, inviante);
			st1.setString(2, ricevente);
			st1.setString(3, ricevente);
			st1.setString(4, inviante);
   
   			rs1=st1.executeQuery();

   			while(rs1.next())
			{
				MessaggioPrivatoDB msg=new MessaggioPrivatoDB(null,null,null,rs1.getString(1),rs1.getString(2), rs1.getString(2));
				result.add(msg);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);

		return result;
	}

 
    
	@Override
	public ArrayList<MessaggioDB> selezionaMessaggi(String s1, String s2) {
		ArrayList<MessaggioDB> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;
		
		try
		{
			String query="SELECT * FROM messaggioprivato WHERE profiloInviante=? and profiloRicevente=? order by dataInvio,oraInvio";

			st1 = conn.prepareStatement(query);
			st1.setString(1, s1);
            st1.setString(2, s2);
			
			rs1=st1.executeQuery();

			while(rs1.next())
			{
				MessaggioPrivatoDB msg=new MessaggioPrivatoDB(rs1.getString(1), rs1.getDate(2),rs1.getTime(3),rs1.getString(4),rs1.getString(5), rs1.getString(6));
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
			String query="SELECT testo FROM messaggioprivato WHERE idMsgPvt=?";

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
	public ArrayList<String> ottieniTestoListaMessaggi(String s1, String s2) {
		ArrayList<String> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;
		
		try
		{
			String query="SELECT testo FROM messaggioprivato WHERE profiloInviante=? and profiloRicevente=? order by dataInvio,oraInvio";

			st1 = conn.prepareStatement(query);
			st1.setString(1, s1);
            st1.setString(2, s2);
			
			rs1=st1.executeQuery();

			while(rs1.next())
			{
				result.add(rs1.getString("testo"));
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}

	@Override
	public ArrayList<MessaggioDB> selezionaMessaggiProfilo(ProfiloDB p) {
		ArrayList<MessaggioDB> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;
		
		try
		{
			String query="SELECT * FROM messaggioprivato WHERE profiloInviante=? order by dataInvio,oraInvio";

			st1 = conn.prepareStatement(query);
			st1.setString(1, p.getIdProfilo());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				MessaggioPrivatoDB msg=new MessaggioPrivatoDB(rs1.getString(1), rs1.getDate(2),rs1.getTime(3),rs1.getString(4),rs1.getString(5), rs1.getString(6));
				result.add(msg);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}

	@Override
	public ArrayList<String> selezionaTestoMessaggiProfilo(ProfiloDB p) {
		ArrayList<String> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;
		
		try
		{
			String query="SELECT testo FROM messaggioprivato WHERE profiloInviante=? order by dataInvio,oraInvio";

			st1 = conn.prepareStatement(query);
			st1.setString(1, p.getIdProfilo());

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
