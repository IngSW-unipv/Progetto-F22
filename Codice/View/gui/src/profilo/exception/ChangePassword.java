package profilo.exception;

public class ChangePassword extends Exception{

	private final static String msg = "La password : %s inserita non è corretta";
	public ChangePassword(String c) {
		super(String.format(msg, c ));
	}
}
