package profilo.exception;

public class AccountGiaEsistente extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String msg = "L'account di id : %s e' gia esistente";
	public AccountGiaEsistente(String id) {
		super(String.format(msg, id));
	}

}
