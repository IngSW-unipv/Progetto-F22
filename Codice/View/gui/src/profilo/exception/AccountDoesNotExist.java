package profilo.exception;


public class AccountDoesNotExist extends Exception{

	private static final String msg = "L'account di id %s non esiste";	
	
	public AccountDoesNotExist(String id) {
		super(String.format(msg, id));
	}
}
