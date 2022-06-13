package profilo.exception;

public class ProfiloGiaInserito extends Exception{

	private final static String msg = "Il profilo %s e' gia presente nel gruppo";
	public ProfiloGiaInserito(String s) {
		super(String.format(msg, s));
	}
}
