package db.follow;

public class FollowDB {

	public FollowDB(String profiloPersonale, String profiloSeguito) {
		super();
		this.profiloPersonale = profiloPersonale;
		this.profiloSeguito = profiloSeguito;
	}
	private String profiloPersonale;
	private String profiloSeguito;
	public String getProfiloPersonale() {
		return profiloPersonale;
	}
	public void setProfiloPersonale(String profiloPersonale) {
		this.profiloPersonale = profiloPersonale;
	}
	public String getProfiloSeguito() {
		return profiloSeguito;
	}
	public void setProfiloSeguito(String profiloSeguito) {
		this.profiloSeguito = profiloSeguito;
	}
	@Override
	public String toString() {
		return "FollowDB [profiloPersonale=" + profiloPersonale + ", profiloSeguito=" + profiloSeguito + "]";
	}
}
