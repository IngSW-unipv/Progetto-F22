package convertitore;

import Messaggio.MessaggioPrivato;
import convertitore.messaggioUtility.MessaggioUtility;
import messaggio.messaggioPrivato.MessaggioPrivatoDB;

public class ConvTest {

	public static void main(String[] args) {
		MessaggioUtility u = new MessaggioUtility();
		MessaggioPrivato m = new MessaggioPrivato("F00", null, null, "Lol", null, "P01", "P00");

		MessaggioPrivatoDB mdb = (MessaggioPrivatoDB) u.converti(m);
		System.out.println(mdb.toString());
	}

}
