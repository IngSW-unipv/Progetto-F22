package it.unipv.po.user.exception;

public class ExistingAccount extends Exception{

	private static final String msg = "Questo account esiste già";	
	
	public ExistingAccount() {
		super(String.format(msg, null));
	}
}
