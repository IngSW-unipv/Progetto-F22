package convertitore.testoUtility;

import db.testo.TestoDB;
import post.testo.Testo;

public class TestoUtility{

	public static TestoDB convertiATestoDB(Testo t) {
		TestoDB tdb = new TestoDB(t.getIdPost(),t.getDataPubblicazione(), t.getOraPubblicazione(), t.getDescrizione(), t.getNumLike(), t.getNumDislike(), t.isVisibile(), t.isCondivisibile(), t.getProfilo(),t.getFont(),t.getTitolo());
		return tdb;
	}
	

	public static Testo convertiATesto(TestoDB t) {
		Testo tdb = new Testo(t.getIdTesto(), t.getDataPubblicazione(), t.getOraPubblicazione(), t.getDescrizione(), t.isVisibile(), t.isCondivisibile(), t.getProfilo(), t.getFont(), t.getTitolo());
		return tdb;
	}
}
