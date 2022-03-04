package Utente;

import java.util.Date;

public class Credenziali {

	private String nome;
	private String cognome;
	private Date dataDiNascita;
	private EnumSesso sesso;
	private EnumPaesi paese;
	private String eMail;
	private String pwd;
	
	public Credenziali(String nome, String cognome, EnumSesso sesso, Date dataDiNascita, EnumPaesi paese, String eMail) {
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.dataDiNascita = dataDiNascita;
		this.paese = paese;
		this.eMail = eMail;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
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

	public String getEMail() {
		return eMail;
	}

	public void setEMail(String eMail) {
		this.eMail = eMail;
	}

	@Override
	public String toString() {
		return "Credenziali [nome=" + nome + ", cognome=" + cognome + ", sesso="
				+ sesso + ", paese=" + paese + ", eMail=" + eMail + "]";
	}

}
