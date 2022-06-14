package profilo.exception;


public class AccountDoesNotExist extends Exception{

	private static final long serialVersionUID = 1L;
	private static final String msg = "L'account di id %s non esiste";	
	
	public AccountDoesNotExist(String id) {
		super(String.format(msg, id));
	}
}
