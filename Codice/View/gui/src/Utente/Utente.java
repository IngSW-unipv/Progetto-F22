package Utente;

public class Utente {
	private Credenziali credenziali;
	//private static boolean login = false;
	//private boolean esistente = false;
	
	public Utente() {
		credenziali = new Credenziali();
	}

	public Credenziali getCredenziali() {
		return credenziali;
	}
/*
	public void setCredenziali(Credenziali credenziali) {
		this.credenziali = credenziali;
	}
	*/
	
	/*
	public boolean creaAccount() throws ExistingAccount{
		
		if(esistente == true) {
			throw new ExistingAccount();
		}
		else {
			esistente = true;
			return true;
		}
	}
	
	public void inserisciPassword(String pwd) {
		 
		credenziali.setPwd(pwd);		
	}
	
	public boolean login(String eMail, String pwd) throws AccountDoesNotExist{
		
		if(esistente == false) {
			throw new AccountDoesNotExist();
		}
		else {
			if(credenziali.getEMail().equals(eMail) && credenziali.getPwd().equals(pwd)) {
				login = true;
				return true;
			}
			else {
				System.out.println("Login errato");
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Utente [credenziali=" + credenziali + "]";
	}

	public static void main(String[] args) {
		
		Utente u1 = new Utente();
		u1.inserisciPassword("stocazzo");
		
		try {
			u1.creaAccount();
		} catch(ExistingAccount e1) {
			e1.getMessage();
		}
		try {
			u1.login("francesco.ardizzoni@gmail.com", "stocazzo");
			try {
				if(login == true) {
					System.out.println(u1);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch(AccountDoesNotExist e2) {
			e2.getMessage();
		}
	}*/
}