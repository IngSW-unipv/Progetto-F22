package Utente.exception;


public class AccountDoesNotExist extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String msg = "Questo account non esiste";	
	
	public AccountDoesNotExist() {
		super(String.format(msg, null));
	}
}
