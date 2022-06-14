package profilo.exception;

public class TastoNonEsistente extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static String msg = "Il comando indicato non e' valido";
	public TastoNonEsistente() {
		System.out.println(msg.toString());
	}
}
