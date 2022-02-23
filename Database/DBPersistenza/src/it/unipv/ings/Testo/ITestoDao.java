package it.unipv.ings.Testo;

import java.util.ArrayList;

public interface ITestoDao {
  
	public ArrayList<TestoDB> selectAll();
	public boolean pubblicaTesto(TestoDB t);
	public boolean rimuoviTesto(TestoDB t);
}
