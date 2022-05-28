package profilo.exception;

public class TipoNonEsistente extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String msg = "Il tipo %s non esiste";
	public TipoNonEsistente(String s) {
		super(String.format(msg, s));
	}
}
