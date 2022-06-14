package profilo.exception;

public class PostNonVisibile extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String msg = "Il profilo %s non e' visibile";
	public PostNonVisibile(String s) {
		super(String.format(msg, s));
	}
}
