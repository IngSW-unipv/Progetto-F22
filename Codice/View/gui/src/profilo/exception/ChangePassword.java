package profilo.exception;

import profilo.credenziali.*;

public class ChangePassword extends Exception{

	private final static String msg = "La password : %s inserita non � corretta";
	public ChangePassword(Credenziali c) {
		super(String.format(msg, c.getPwd()));
	}
}
