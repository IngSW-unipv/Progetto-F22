package post.testo.utility;

import db.testo.TestoDB;
import post.testo.Testo;

public class TestoUtility implements ITestoUtility{

	@Override
	public TestoDB converti(Testo t) {
		TestoDB tdb = new TestoDB(t.getIdPost(),t.getDataPubblicazione(), t.getOraPubblicazione(), t.getDescrizione(), t.getNumLike(), t.getNumDislike(), t.isVisibile(), t.isCondivisibile(), t.getProfilo(),t.getFont(),t.getTitolo());
		return tdb;
	}

}
