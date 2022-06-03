package profilo.exception;


public class FotoProfiloNonAncoraImpostata extends Exception{

	private final static String msg = "non è stata ancora impostata una foto";
	public FotoProfiloNonAncoraImpostata() {
		super(String.format(msg));
	}

}

