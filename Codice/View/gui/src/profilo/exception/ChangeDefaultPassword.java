package profilo.exception;

public class ChangeDefaultPassword extends Exception{


	private final static String msg = "Devi prima cambiare la password %s di default";
	public ChangeDefaultPassword(String c) {
		super(String.format(msg, c));
	}
}
