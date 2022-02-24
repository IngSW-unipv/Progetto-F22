package post.testo.utility;

import it.unipv.ings.Testo.TestoDB;
import post.testo.Testo;

public class UtilityTesto implements IUtilityTesto{

	@Override
	public TestoDB convertiToTestoDB(Testo t) {
		TestoDB tdb = new TestoDB(t.getIdTesto(), t.getDescrizione(), t.getTitolo(), t.getFont(), t.getIdPost());
		return tdb;
	}

}
