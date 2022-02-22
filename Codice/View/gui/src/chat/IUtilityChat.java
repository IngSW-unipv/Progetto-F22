package chat;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

public interface IUtilityChat {

	//Metodo che converte Date in sql Date
		public Date convertiInSqlData(java.util.Date d);
		
		//Metodo che converte LocalTime in sql Time
	    public Time convertiInSqlTime(LocalTime t);
	
	    public void visualizzaMultimedia();
}
