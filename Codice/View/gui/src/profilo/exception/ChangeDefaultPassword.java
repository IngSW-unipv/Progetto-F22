package profilo.exception;

import profilo.credenziali.Credenziali;

public class ChangeDefaultPassword extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static String msg = "Devi prima cambiare la password %s di default";
	public ChangeDefaultPassword(Credenziali c) {
		super(String.format(msg, c.getPwd()));
	}
}
