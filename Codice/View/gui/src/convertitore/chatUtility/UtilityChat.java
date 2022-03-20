package convertitore.chatUtility;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

public class UtilityChat{

	//Metodo che converte Date in sql Date
		public static Date convertiInSqlData(java.util.Date d) {
			java.sql.Date dataSql = new java.sql.Date(d.getTime());
			return dataSql;
		}
		
		//Metodo che converte LocalTime in sql Time
	    public static Time convertiInSqlTime(LocalTime t) {
	    	Time time = Time.valueOf(t);
	    	return time;
	    }	    
}
