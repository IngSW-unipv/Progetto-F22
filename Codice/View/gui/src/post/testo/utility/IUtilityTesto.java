package post.testo.utility;

import it.unipv.ings.Testo.TestoDB;
import post.testo.Testo;

public interface IUtilityTesto {

	//Adatta la classe testo alla classe testoDB usata per fare le query
	public TestoDB convertiToTestoDB(Testo t);
}
