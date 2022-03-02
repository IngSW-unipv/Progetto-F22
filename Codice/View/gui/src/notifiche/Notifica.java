package notifiche;

import java.sql.Date;
import java.sql.Time;

public class Notifica {

	private int countNotifiche;
	private String contenuto;
	private Date dataNotifica;
	private Time oraNotifica;
	
	public Notifica(String contenuto, Date dataNotifica, Time oraNotifica) {
		this.countNotifiche = 0;
		this.contenuto = contenuto;
		this.dataNotifica = dataNotifica;
		this.oraNotifica = oraNotifica;
	}

	public int getCountNotifiche() {
		return countNotifiche;
	}

	public void setCountNotifiche(int countNotifiche) {
		this.countNotifiche = countNotifiche;
	}

	public String getContenuto() {
		return contenuto;
	}

	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}

	public Date getDataNotifica() {
		return dataNotifica;
	}

	public void setDataNotifica(Date dataNotifica) {
		this.dataNotifica = dataNotifica;
	}

	public Time getOraNotifica() {
		return oraNotifica;
	}

	public void setOraNotifica(Time oraNotifica) {
		this.oraNotifica = oraNotifica;
	}
}
