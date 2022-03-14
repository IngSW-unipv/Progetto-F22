package convertitore.chatUtility;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

public class UtilityChat implements IUtilityChat{

	//Metodo che converte Date in sql Date
		public Date convertiInSqlData(java.util.Date d) {
			java.sql.Date dataSql = new java.sql.Date(d.getTime());
			return dataSql;
		}
		
		//Metodo che converte LocalTime in sql Time
	    public Time convertiInSqlTime(LocalTime t) {
	    	Time time = Time.valueOf(t);
	    	return time;
	    }	    
	    
}
