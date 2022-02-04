package user;

import java.util.Calendar;

import jhjhjjh.EnumPaesi;
import jhjhjjh.EnumSesso;

public class Credenziali {

	private String nome;
	private String cognome;
	private Calendar dataDiNascita;
	private EnumSesso sesso;
	private EnumPaesi paese;
	private String eMail;
	private String pwd;
	
	public Credenziali(String nome, String cognome, Calendar dataDiNascita, EnumSesso sesso, EnumPaesi paese, String eMail, String pwd) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.sesso = sesso;
		this.paese = paese;
		this.eMail = eMail;
		this.pwd = pwd;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Calendar getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Calendar dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public EnumSesso getSesso() {
		return sesso;
	}

	public void setSesso(EnumSesso sesso) {
		this.sesso = sesso;
	}

	public EnumPaesi getPaese() {
		return paese;
	}

	public void setPaese(EnumPaesi paese) {
		this.paese = paese;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
