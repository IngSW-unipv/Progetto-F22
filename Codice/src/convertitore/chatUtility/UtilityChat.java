package convertitore.chatUtility;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

public class UtilityChat{

	/**
	 * Converte una data da java.util.data a java.sql.data
	 * @param data in ingresso da convertire
	 */
		public static Date convertiInSqlData(java.util.Date d) {
			java.sql.Date dataSql = new java.sql.Date(d.getTime());
			return dataSql;
		}
		
		/**
		 * Converte una tempo da LocalTime a sqlTime
		 * @param data in ingresso da convertire
		 */
	    public static Time convertiInSqlTime(LocalTime t) {
	    	Time time = Time.valueOf(t);
	    	return time;
	    }	    
}
