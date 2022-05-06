package db.gruppo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.connessione.DBConnection;

public class GruppoDao implements IGruppo{
private Connection conn;
private String schema;
public GruppoDao() {
	super();
	this.schema = "socialnetwork";
}

@Override
public ArrayList<GruppoDB> selectall() {
	ArrayList<GruppoDB> result = new ArrayList<>();

	conn=DBConnection.startConnection(conn,schema);
	Statement st1;
	ResultSet rs1;

	try
	{
		st1 = conn.createStatement();
		String query="SELECT * from gruppo order by idGruppo";
		rs1=st1.executeQuery(query);

		while(rs1.next())
		{
			GruppoDB grp =new GruppoDB(rs1.getString(1), rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getString(5), rs1.getString(6),rs1.getString(7),rs1.getString(8),rs1.getString(9),rs1.getString(10));

			result.add(grp);
		}
	}catch (Exception e){e.printStackTrace();}

	DBConnection.closeConnection(conn);
	return result;
}

@Override
public boolean creaGruppo(GruppoDB g) {
	conn=DBConnection.startConnection(conn,schema);
	PreparedStatement st1;
	boolean esito = true;

	try
	{
		String query="insert into gruppo (idGruppo,descrizione,nomeGruppo) values (?,?,?)";

		st1 = conn.prepareStatement(query);
		st1.setString(1, g.getIdGruppo());
		st1.setString(2, g.getDescrizione());
		st1.setString(3, g.getNomeGruppo());
		
		st1.executeUpdate();


	}catch (Exception e){
		e.printStackTrace();
		esito=false;
	}

	DBConnection.closeConnection(conn);
	return esito;
}
@Override
public boolean inserisciChiavi(GruppoDB g) {
	conn=DBConnection.startConnection(conn,schema);
	PreparedStatement st1;
	boolean esito = true;

	try
	{
		String query="update gruppo set profilo1=?,profilo2=?,profilo3=?,profilo4=?,profilo5=?,profilo6=?,amministratore=? where idGruppo=?";

		st1 = conn.prepareStatement(query);
		st1.setString(1, g.getProfilo1());
		st1.setString(2, g.getProfilo2());
		st1.setString(3, g.getProfilo3());
		st1.setString(4, g.getProfilo4());
		st1.setString(5, g.getProfilo5());
		st1.setString(6, g.getProfilo6());
		st1.setString(7, g.getAmministratore());
		st1.setString(8, g.getIdGruppo());
		
		st1.executeUpdate();


	}catch (Exception e){
		e.printStackTrace();
		esito=false;
	}

	DBConnection.closeConnection(conn);
	return esito;
}
@Override
public boolean cancellaGruppo(GruppoDB g) {
	conn=DBConnection.startConnection(conn,schema);
	PreparedStatement st1;

	boolean esito=true;

	try
	{
		String query="delete from Gruppo where idGruppo=?";
		st1 = conn.prepareStatement(query);
		st1.setString(1, g.getIdGruppo());

		st1.executeUpdate();

	}catch (Exception e){
		e.printStackTrace();
		esito=false;
	}

	DBConnection.closeConnection(conn);
	return esito;
}
@Override
public ArrayList<GruppoDB> cercaGruppo(String g) {
	ArrayList<GruppoDB> result = new ArrayList<>();

	conn=DBConnection.startConnection(conn,schema);
	PreparedStatement st1;
	ResultSet rs1;

	try
	{
		String query="SELECT * FROM Gruppo WHERE idGruppo=?";

		st1 = conn.prepareStatement(query);
		st1.setString(1, g);

		rs1=st1.executeQuery();

		while(rs1.next())
		{
			GruppoDB grp =new GruppoDB(rs1.getString(1), rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getString(5), rs1.getString(6),rs1.getString(7),rs1.getString(8),rs1.getString(9),rs1.getString(10));

			result.add(grp);
		}
	}catch (Exception e){e.printStackTrace();}

	DBConnection.closeConnection(conn);
	return result;
}
}
