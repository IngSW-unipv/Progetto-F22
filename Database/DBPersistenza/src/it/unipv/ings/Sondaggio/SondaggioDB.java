package it.unipv.ings.Sondaggio;

public class SondaggioDB {


public SondaggioDB(String idSondaggio, String primaScelta, String secondaScelta, String terzaScelta,
			String quartaScelta, String post) {
		super();
		this.idSondaggio = idSondaggio;
		this.primaScelta = primaScelta;
		this.secondaScelta = secondaScelta;
		this.terzaScelta = terzaScelta;
		this.quartaScelta = quartaScelta;
		this.post = post;
	}
private String idSondaggio;
private String primaScelta;
private String secondaScelta;
private String terzaScelta;
private String quartaScelta;
private String post;
public String getIdSondaggio() {
	return idSondaggio;
}
public void setIdSondaggio(String idSondaggio) {
	this.idSondaggio = idSondaggio;
}
public String getPrimaScelta() {
	return primaScelta;
}
public void setPrimaScelta(String primaScelta) {
	this.primaScelta = primaScelta;
}
public String getSecondaScelta() {
	return secondaScelta;
}
public void setSecondaScelta(String secondaScelta) {
	this.secondaScelta = secondaScelta;
}
public String getTerzaScelta() {
	return terzaScelta;
}
public void setTerzaScelta(String terzaScelta) {
	this.terzaScelta = terzaScelta;
}
public String getQuartaScelta() {
	return quartaScelta;
}
public void setQuartaScelta(String quartaScelta) {
	this.quartaScelta = quartaScelta;
}
public String getPost() {
	return post;
}
public void setPost(String post) {
	this.post = post;
}
@Override
public String toString() {
	return "Sondaggio [idSondaggio=" + idSondaggio + ", primaScelta=" + primaScelta + ", secondaScelta=" + secondaScelta
			+ ", terzaScelta=" + terzaScelta + ", quartaScelta=" + quartaScelta + ", post=" + post + "]";
}


}