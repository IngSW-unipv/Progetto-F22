package it.unipv.po.user.exception;

public class AccountDoesNotExist extends Exception{

	private static final String msg = "Questo account non esiste";	
	
	public AccountDoesNotExist() {
		super(String.format(msg, null));
	}
}
