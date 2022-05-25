package Sistema;

import profilo.exception.AccountDoesNotExist;
import profilo.exception.ChangeDefaultPassword;
import profilo.exception.PswOmailErrati;

public class TestSistema {

	public static void main(String [] args) {
		Sistema s = new Sistema();

	try {
		s.login("008", "cerbiatto");
	} catch (ChangeDefaultPassword | AccountDoesNotExist | PswOmailErrati e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
