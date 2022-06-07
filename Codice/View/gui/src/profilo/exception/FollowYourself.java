package profilo.exception;

public class FollowYourself extends Exception{

	private static final long serialVersionUID = 1L;
	private static final String msg = "l'account sta cercando di seguirsi da solo";	
	
	public FollowYourself(String id) {
		super(String.format(msg, id));
	}
}
