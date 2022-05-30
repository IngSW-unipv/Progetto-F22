package db.post.sondaggio.sondaggioMap1;

//Questa classe rappresenta la mappa(idProfilo,sondaggio) nel database per i sondaggiDoppiaVotazione


public class SondaggioMap1DB {

	public SondaggioMap1DB(String profilo, String sondaggio) {
		this.profilo = profilo;
		this.sondaggio = sondaggio;
	}
	private String profilo;
	private String sondaggio;
	public String getProfilo() {
		return profilo;
	}
	public void setProfilo(String profilo) {
		this.profilo = profilo;
	}
	public String getSondaggio() {
		return sondaggio;
	}
	public void setSondaggio(String sondaggio) {
		this.sondaggio = sondaggio;
	}
	@Override
	public String toString() {
		return "SondaggioMapDB [profilo=" + profilo + ", sondaggio=" + sondaggio + "]";
	}
}
