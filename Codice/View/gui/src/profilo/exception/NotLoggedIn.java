package profilo.exception;


public class NotLoggedIn extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String msg = "Devi prima loggarti nel modo corretto al profilo di id %s";
	public NotLoggedIn(String id) {
		super(String.format(msg, id));
	}
}
