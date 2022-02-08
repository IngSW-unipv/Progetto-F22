package it.op.unipv.sistem;

import it.unipv.po.profile.Profilo;

public class Sistema {

	private Profilo profiloAttivo;
	private Profilo altroProfilo;
	
	public Sistema() {
		
	}
	
	public void creaProfilo(String nickname, String pwd) {
		profiloAttivo = new Profilo(nickname, pwd);
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
		profiloAttivo.setNumeroFollower(altroProfilo.getNumeroFollower() + 1);
	}
	public void smettiDiSeguire() {
		profiloAttivo.setNumeroFollower(altroProfilo.getNumeroFollower() - 1);
	}
	
}
