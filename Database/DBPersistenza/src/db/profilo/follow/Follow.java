package db.profilo.follow;

public class Follow {

	public Follow(String mailProfiloPersonale, String mailProfiloSeguito) {
		super();
		this.mailProfiloPersonale = mailProfiloPersonale;
		this.mailProfiloSeguito = mailProfiloSeguito;
	}
	private String mailProfiloPersonale;
	private String mailProfiloSeguito;
	public String getMailProfiloPersonale() {
		return mailProfiloPersonale;
	}
	public void setMailProfiloPersonale(String mailProfiloPersonale) {
		this.mailProfiloPersonale = mailProfiloPersonale;
	}
	public String getMailProfiloSeguito() {
		return mailProfiloSeguito;
	}
	public void setMailProfiloSeguito(String mailProfiloSeguito) {
		this.mailProfiloSeguito = mailProfiloSeguito;
	}
	@Override
	public String toString() {
		return "Follow [mailProfiloPersonale=" + mailProfiloPersonale + ", mailProfiloSeguito=" + mailProfiloSeguito
				+ "]";
	}
}
