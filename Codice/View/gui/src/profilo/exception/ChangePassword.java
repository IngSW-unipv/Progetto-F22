package profilo.exception;

import profilo.credenziali.*;

public class ChangePassword extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static String msg = "La password : %s inserita non � corretta";
	public ChangePassword(Credenziali c) {
		super(String.format(msg, c.getPwd()));
	}
}
