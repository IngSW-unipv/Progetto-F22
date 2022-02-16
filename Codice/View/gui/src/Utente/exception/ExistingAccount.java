package Utente.exception;

public class ExistingAccount extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String msg = "Questo account esiste già";	
	
	public ExistingAccount() {
		super(String.format(msg, null));
	}
}
