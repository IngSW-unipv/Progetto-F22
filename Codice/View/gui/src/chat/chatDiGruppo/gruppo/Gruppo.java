package chat.chatDiGruppo.gruppo;


public class Gruppo {
	
public Gruppo(String idGruppo, String descrizione, String nomeGruppo, String profilo1, String profilo2,
			String profilo3, String profilo4, String profilo5, String profilo6, String amministratore) {
	
		super();
		this.idGruppo = idGruppo;
		this.descrizione = descrizione;
		this.nomeGruppo = nomeGruppo;
		this.profilo1 = profilo1;
		this.profilo2 = profilo2;
		this.profilo3 = profilo3;
		this.profilo4 = profilo4;
		this.profilo5 = profilo5;
		this.profilo6 = profilo6;
		Amministratore = amministratore;
	}

	private String idGruppo;
	private String descrizione;
	private String nomeGruppo;
	private String profilo1;
	private String profilo2;
	private String profilo3;
	private String profilo4;
	private String profilo5;
	private String profilo6;
	private String Amministratore;
	public String getIdGruppo() {
	return idGruppo;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public String getNomeGruppo() {
		return nomeGruppo;
	}
	
	public String getProfilo1() {
		return profilo1;
	}
	
	public String getProfilo2() {
		return profilo2;
	}
	
	public String getProfilo3() {
		return profilo3;
	}
	
	public String getProfilo4() {
		return profilo4;
	}
	
	public String getProfilo5() {
		return profilo5;
	}
	
	public String getProfilo6() {
		return profilo6;
	}
	
	public String getAmministratore() {
		return Amministratore;
	}
	@Override
	public String toString() {
		return "Gruppo [idGruppo=" + idGruppo + ", descrizione=" + descrizione + ", nomeGruppo=" + nomeGruppo
			+ ", profilo1=" + profilo1 + ", profilo2=" + profilo2 + ", profilo3=" + profilo3 + ", profilo4=" + profilo4
			+ ", profilo5=" + profilo5 + ", profilo6=" + profilo6 + ", Amministratore=" + Amministratore + "]";
	}
}
