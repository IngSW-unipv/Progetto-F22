package it.unipv.ings.Profilo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.ings.connessione.DBConnection;

public class ProfiloDao implements IProfiloDao{
	
	private String schema;
	private Connection conn;


	public ProfiloDao() {
		super();
		this.schema = "socialnetwork";
	}


	public ArrayList<Profilo> selectAll() {
		ArrayList<Profilo> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		Statement st1;
		ResultSet rs1;

		try
		{
			st1 = conn.createStatement();
			String query="SELECT * from profilo";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				Profilo p=new Profilo(rs1.getString(1), rs1.getString(2),rs1.getString(3),rs1.getInt(4),rs1.getInt(5),rs1.getInt(6),rs1.getString(7),rs1.getString(8),rs1.getString(9),rs1.getString(10),rs1.getString(11));                                     

				result.add(p);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}


	public boolean inserisciProfilo(Profilo p) {
		
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="insert into profilo (idProfilo,nickname,descrizione,numFollower,numSeguiti,numPost,tipo) values (?,?,?,?,?,?,?)";

			st1 = conn.prepareStatement(query);
			st1.setString(1, p.getIdProfilo());
			st1.setString(2, p.getNickname());
			st1.setString(3, p.getDescrizione());
			st1.setInt(4, p.getNumFollower());
			st1.setInt(5, p.getNumSeguiti());
			st1.setInt(6, p.getNumPost());
			st1.setString(7, p.getTipo());
			
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;

	}

	public boolean rimuoviProfilo(Profilo p) {
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


	
	public ArrayList<Profilo> cercaProfilo(Profilo p) {
		ArrayList<Profilo> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM profilo WHERE idProfilo=?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, p.getIdProfilo());

			rs1=st1.executeQuery();

			while(rs1.next())
			{
				Profilo prof =new Profilo(rs1.getString(1), rs1.getString(2),rs1.getString(3),rs1.getInt(4),rs1.getInt(5),rs1.getInt(6),rs1.getString(7),rs1.getString(8),rs1.getString(9),rs1.getString(10),rs1.getString(11));

				result.add(prof);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}


	@Override
	public boolean inserisciChiavi(Profilo p) {
		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		boolean esito = true;

		try
		{
			String query="update profilo set messaggioDiGruppo=?,messaggioPrivato=?,utente=?,post=? where idProfilo=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, p.getMessaggioDiGruppo());
			st1.setString(2, p.getMessaggioPrivato());
			st1.setString(3, p.getUtente());
			st1.setString(4, p.getPost());
			st1.setString(5, p.getIdProfilo());
			
			st1.executeUpdate();


		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;

	}
	}

	

