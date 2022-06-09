package profilo.exception;


public class PostNonPresente extends Exception{

	private static final long serialVersionUID = 1L;
	private final static String msg = "Il post %s non e' stato trovato";
	public PostNonPresente(String s) {
		super(String.format(msg, s));
	}

}

