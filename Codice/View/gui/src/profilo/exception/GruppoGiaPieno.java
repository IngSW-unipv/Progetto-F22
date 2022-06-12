package profilo.exception;

public class GruppoGiaPieno extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static String msg = "Il gruppo %s e' gia' pieno";
	public GruppoGiaPieno(String s) {
		super(String.format(msg, s));
	}
}
