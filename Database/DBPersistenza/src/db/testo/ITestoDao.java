package db.testo;

import java.util.ArrayList;


public interface ITestoDao {
  
	public ArrayList<TestoDB> selectAll();
	public boolean pubblicaTesto(TestoDB p);
	public boolean rimuoviTesto(TestoDB p);
	public ArrayList<TestoDB> cercaTesto(String t);
}
