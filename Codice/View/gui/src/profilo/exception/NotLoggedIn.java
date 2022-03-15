package profilo.exception;

import profilo.Profilo;

public class NotLoggedIn extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String msg = "Devi prima loggarti nel modo corretto al profilo di id %s";
	public NotLoggedIn(Profilo p) {
		super(String.format(msg, p.getIdProfilo()));
	}
}
