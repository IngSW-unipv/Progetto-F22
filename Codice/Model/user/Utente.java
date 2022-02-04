package user;

public class Utente {
	private Credenziali credenziali;
	private boolean login;
	private boolean pwdDaCambiare = true; 	//All'inizio la variabile è true perchè al primo accesso la pwd va cambiata
	private boolean esistente = false;
	
	public Utente() {
		credenziali = new Credenziali();
	}
	
	public void creaAccount() {
		
	}
	
	public boolean cambiaPassword(String nuovaPassword) {
		String pwdDefault = "changeme";
		if(pwdDaCambiare == true) {
			if(credenziali.getPwd().equals(pwdDefault)) {
				credenziali.setPwd(nuovaPassword);
				return false;
			}
		} else {
			return true;
		}
	}
	
	public boolean accountEsistente() {
		if(esistente) {
			return true;
		} else {
			creaAccount();
			return true;
		}
	}
	
}
