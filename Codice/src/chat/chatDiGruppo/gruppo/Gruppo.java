package chat.chatDiGruppo.gruppo;


public class Gruppo {
	
	private String idGruppo;
	private String descrizione;
	private String profilo1;
	private String profilo2;
	private String profilo3;
	private String profilo4;
	private String profilo5;
	private String profilo6;
	private String amministratore;
	
	public Gruppo(String idGruppo, String descrizione, String profilo1, String profilo2, String profilo3, String profilo4, String profilo5, 
			  String profilo6, String amministratore) {	
		super();
		this.idGruppo = idGruppo;
		this.descrizione = descrizione;
		this.profilo1 = profilo1;
		this.profilo2 = profilo2;
		this.profilo3 = profilo3;
		this.profilo4 = profilo4;
		this.profilo5 = profilo5;
		this.profilo6 = profilo6;
		this.amministratore = amministratore;
	}

	public Gruppo(String idGruppo) {
		this.idGruppo = idGruppo;
		this.descrizione = null;
		this.profilo1 = null;
		this.profilo2 = null;
		this.profilo3 = null;
		this.profilo4 = null;
		this.profilo5 = null;
		this.profilo6 = null;
		this.amministratore = null;
	}
	
	@Override
	public String toString() {
		return "Gruppo [idGruppo=" + idGruppo + ", descrizione=" + descrizione + ", profilo1=" + profilo1 + ", profilo2=" + profilo2 + ", profilo3=" + profilo3 + ", profilo4="
				+ profilo4 + ", profilo5=" + profilo5 + ", profilo6=" + profilo6 + ", amministratore=" + amministratore
				+ ", fotoGruppo=" + "]";
	}
	
	public String getIdGruppo() {
		return idGruppo;
	}
	
	public String getDescrizione() {
		return descrizione;
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
		return amministratore;
	}

	public void setIdGruppo(String idGruppo) {
		this.idGruppo = idGruppo;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public void setProfilo1(String profilo1) {
		this.profilo1 = profilo1;
	}

	public void setProfilo2(String profilo2) {
		this.profilo2 = profilo2;
	}

	public void setProfilo3(String profilo3) {
		this.profilo3 = profilo3;
	}

	public void setProfilo4(String profilo4) {
		this.profilo4 = profilo4;
	}

	public void setProfilo5(String profilo5) {
		this.profilo5 = profilo5;
	}

	public void setProfilo6(String profilo6) {
		this.profilo6 = profilo6;
	}

	public void setAmministratore(String amministratore) {
		this.amministratore = amministratore;
	}
}
