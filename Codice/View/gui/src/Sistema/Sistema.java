package Sistema;

import Profilo.Profilo;

public class Sistema {

	private Profilo profiloAttivo;
	private Profilo altroProfilo;
	
	public Sistema() {
		
	}
	
	public void creaProfilo(String nickname, String pwd) {
	     
		//Per Francesco
		//Bisogna usare la funzione di profiloDao
		//simile a scrivi messaggio di chatPrivata
		
		
		
		//	profiloAttivo = new Profilo(nickname, pwd);
	}
	public boolean eliminaProfilo(Profilo p) {
		return false;
	}
/*	
	public boolean login(String eMail, String pwd) {
		verificaEsistenzaAccount(eMail);
		/*codice per prelevare da sql un oggetto profilo
		Profilo profiloChiamato = ProfiloPrelevato()
		if (profiloChiamato.getPwd() == pwd)
		return true;
	    else
		return false;
	}
*/	
	public boolean verificaEsistenzaAccount(String eMail) {
		return true;
	}
	
	public void segui() {
		//codice da recuperare da database
		profiloAttivo.setNumFollower(altroProfilo.getNumFollower() + 1);
	}
	public void smettiDiSeguire() {
		profiloAttivo.setNumFollower(altroProfilo.getNumFollower() - 1);
	}
	
}