package Messaggio;

import java.time.LocalTime;
import java.util.Date;

public class MessaggioTester {
public static void main(String[] args) {
	Date d = new Date();
	System.out.println(d);
	System.out.println(Messaggio.convertiInSqlData(d));
	LocalTime t = LocalTime.now();
	System.out.println("Local time : " + t);
	System.out.println("Sql time : " + Messaggio.convertiInSqlTime(t));
}
}
