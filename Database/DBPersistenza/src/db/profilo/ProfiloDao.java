package db.profilo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import profilo.exception.AccountDoesNotExist;
import db.connessione.DBConnection;

public class ProfiloDao implements IProfiloDao{
	
	private String schema;
	private Connection conn;


	public ProfiloDao() {
		super();
		this.schema = "socialnetwork";
	}


	public ArrayList<ProfiloDB> selectAll() {
		ArrayList<ProfiloDB> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		Statement st1;
		ResultSet rs1;

		try
		{
			st1 = conn.createStatement();
			String query="SELECT * from profilo order by idProfilo";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				ProfiloDB prof =new ProfiloDB(rs1.getString(1), rs1.getString(2),rs1.getString(3),rs1.getInt(4),rs1.getInt(5),rs1.getInt(6),rs1.getBoolean(7), rs1.getBoolean(8),rs1.getBoolean(9),rs1.getString(10),rs1.getString(11));

				result.add(prof);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}


	public boolean inserisciProfilo(ProfiloDB p) {
		
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="insert into profilo (idProfilo,nickname,descrizione,numFollower,numSeguiti,numPost,esiste,pswCambiata,isloggato,psw,immagineProfilo) values (?,?,?,?,?,?,?,?,?,?,?)";

			st1 = conn.prepareStatement(query);
			st1.setString(1, p.getIdProfilo());
			st1.setString(2, p.getNickname());
			st1.setString(3, p.getDescrizione());
			st1.setInt(4, p.getNumFollower());
			st1.setInt(5, p.getNumSeguiti());
			st1.setInt(6, p.getNumPost());
			st1.setBoolean(7, false);
			st1.setBoolean(8, false);
			st1.setBoolean(9, false);
			st1.setString(10, p.getPsw());
			st1.setString(11, p.getImmagineProfilo());
			
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
    	System.out.println(p.getIdProfilo() + 1);

		return esito;

	}

	public boolean rimuoviProfilo(ProfiloDB p) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;

		boolean esito=true;

		try
		{
			String query="delete from profilo where idProfilo=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, p.getIdProfilo());

			st1.executeUpdate();

		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;

	}


	
	public ProfiloDB cercaProfilo(ProfiloDB p) {


		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM profilo WHERE idProfilo=? order by idProfilo";

			st1 = conn.prepareStatement(query);
			st1.setString(1, p.getIdProfilo());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				ProfiloDB prof =new ProfiloDB(rs1.getString(1), rs1.getString(2),rs1.getString(3),rs1.getInt(4),rs1.getInt(5),rs1.getInt(6),rs1.getBoolean(7), rs1.getBoolean(8),rs1.getBoolean(9),rs1.getString(10),rs1.getString(11));

				DBConnection.closeConnection(conn);
				return prof;
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return null;
	}


	@Override
	public boolean vediSeEsiste(String p) throws AccountDoesNotExist {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT esiste FROM profilo WHERE idProfilo=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, p);

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				boolean b = rs1.getBoolean("esiste");
				DBConnection.closeConnection(conn);
				return b;
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
	    throw new AccountDoesNotExist(p);
	}


	@Override
	public boolean modificaEsiste(String p, boolean s) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="update profilo set esiste=? where idProfilo=?";
			st1 = conn.prepareStatement(query);
			st1.setBoolean(1, s);
			st1.setString(2, p);
		
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}


	@Override
	public boolean vediSePswCambiata(String p) throws AccountDoesNotExist {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT pswCambiata FROM profilo WHERE idProfilo=?";
			System.out.println("account di " + p);
			st1 = conn.prepareStatement(query);
			st1.setString(1, p);

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				boolean b = rs1.getBoolean("pswCambiata");
				DBConnection.closeConnection(conn);
				return b;
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
	    throw new AccountDoesNotExist(p);
	}


	@Override
	public boolean modificaPswCambiata(String p, boolean s) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="update profilo set pswCambiata=? where idProfilo=?";
			st1 = conn.prepareStatement(query);
			st1.setBoolean(1, s);
			st1.setString(2, p);
		
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}


	@Override
	public boolean vediSeIsLoggato(String p) throws AccountDoesNotExist {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT isLoggato FROM profilo WHERE idProfilo=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, p);

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				boolean b = rs1.getBoolean("isLoggato");
				DBConnection.closeConnection(conn);
				return b;
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
	    throw new AccountDoesNotExist(p);
	}


	@Override
	public boolean modificaIsLoggato(String p, boolean s) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="update profilo set isLoggato=? where idProfilo=?";
			st1 = conn.prepareStatement(query);
			st1.setBoolean(1, s);
			st1.setString(2, p);
		
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}


	@Override
	public boolean modificaPsw(String idProfilo, String s) throws AccountDoesNotExist {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="update profilo set psw=? where idProfilo=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, s);
			st1.setString(2, idProfilo);
		
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}


	@Override
	public String ottieniPsw(String idProfilo) throws AccountDoesNotExist {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT psw FROM profilo WHERE idProfilo=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, idProfilo);

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				String s = rs1.getString("psw");
				DBConnection.closeConnection(conn);
				return s;
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
	    throw new AccountDoesNotExist(idProfilo);
	}

	@Override
	public boolean cambiaImmagineProfilo(ProfiloDB p, String s) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="update profilo set immagineProfilo=? where idProfilo=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, s);
			st1.setString(2, p.getIdProfilo());
		
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}


	@Override
	public String ottieniImmagine(ProfiloDB p) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT immagineProfilo FROM profilo WHERE idProfilo=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, p.getIdProfilo());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				String s = rs1.getString("immagineProfilo");
				DBConnection.closeConnection(conn);
				return s;
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
	    return null;
	}


	@Override
	public int vediSeguiti(ProfiloDB p) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT numSeguiti FROM profilo WHERE idProfilo=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, p.getIdProfilo());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				int i = rs1.getInt("numSeguiti");
				DBConnection.closeConnection(conn);
				return i;
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
	    return -1;
	}


	@Override
	public int vediFollower(ProfiloDB p) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT numFollower FROM profilo WHERE idProfilo=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, p.getIdProfilo());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				int i = rs1.getInt("numFollower");
				DBConnection.closeConnection(conn);
				return i;
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
	    return -1;
	}


	@Override
	public boolean modificaSeguiti(ProfiloDB p, int n) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="update profilo set numSeguiti=? where idProfilo=?";
			st1 = conn.prepareStatement(query);
			st1.setInt(1, n);
			st1.setString(2, p.getIdProfilo());
		
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}


	@Override
	public boolean modificaFollower(ProfiloDB p, int n) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="update profilo set numFollower=? where idProfilo=?";
			st1 = conn.prepareStatement(query);
			st1.setInt(1, n);
			st1.setString(2, p.getIdProfilo());
		
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}


	@Override
	public int vediNumPost(ProfiloDB p) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT numPost FROM profilo WHERE idProfilo=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, p.getIdProfilo());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				int i = rs1.getInt("numPost");
				DBConnection.closeConnection(conn);
				return i;
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
	    return -1;
	}


	@Override
	public boolean modificaNumPost(ProfiloDB p, int n) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="update profilo set numPost=? where idProfilo=?";
			st1 = conn.prepareStatement(query);
			st1.setInt(1, n);
			st1.setString(2, p.getIdProfilo());
		
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}


	@Override
	public String vediDescrizione(ProfiloDB p) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT descrizione FROM profilo WHERE idProfilo=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, p.getIdProfilo());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				String i = rs1.getString("descrizione");
				DBConnection.closeConnection(conn);
				return i;
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
	    return null;
	}


	@Override
	public boolean modificaDescrizione(ProfiloDB p, String s) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="update profilo set descrizione=? where idProfilo=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, s);
			st1.setString(2, p.getIdProfilo());
		
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}


	@Override
	public String vediNickname(ProfiloDB p) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT nickname FROM profilo WHERE idProfilo=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, p.getIdProfilo());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				String i = rs1.getString("nickname");
				DBConnection.closeConnection(conn);
				return i;
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
	    return null;
	}


	@Override
	public boolean modificaNickname(ProfiloDB p, String s) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="update profilo set nickname=? where idProfilo=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, s);
			st1.setString(2, p.getIdProfilo());
		
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;
	}
	
	}

	

