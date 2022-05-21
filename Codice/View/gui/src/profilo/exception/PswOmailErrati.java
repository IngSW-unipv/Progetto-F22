package profilo.exception;


public class PswOmailErrati extends Exception{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private static final String msg = "La mail : %s, o la password %s, e' errata ";	
	
	public PswOmailErrati(String s1, String s2) {
		super(String.format(msg, s1, s2));
	}

}
