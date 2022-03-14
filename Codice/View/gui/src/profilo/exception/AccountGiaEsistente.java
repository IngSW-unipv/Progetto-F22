package profilo.exception;

public class AccountGiaEsistente extends Exception{

	private static String msg = "L'account di id : %s � gi� esistente";
	public AccountGiaEsistente(String id) {
		super(String.format(msg, id));
	}

}
