package it.unipv.ings.Testo;

public class Testo {
public Testo(String idTesto, String descrizione, String titolo, String font, String post) {
		super();
		this.idTesto = idTesto;
		this.descrizione = descrizione;
		this.titolo = titolo;
		this.font = font;
		this.post = post;
	}
private String idTesto;
private String descrizione;
private String titolo;
private String font;
private String post;
public String getIdTesto() {
	return idTesto;
}
public void setIdTesto(String idTesto) {
	this.idTesto = idTesto;
}
public String getDescrizione() {
	return descrizione;
}
public void setDescrizione(String descrizione) {
	this.descrizione = descrizione;
}
public String getTitolo() {
	return titolo;
}
public void setTitolo(String titolo) {
	this.titolo = titolo;
}
public String getFont() {
	return font;
}
public void setFont(String font) {
	this.font = font;
}
public String getPost() {
	return post;
}
public void setPost(String post) {
	this.post = post;
}
@Override
public String toString() {
	return "Testo [idTesto=" + idTesto + ", descrizione=" + descrizione + ", titolo=" + titolo + ", font=" + font
			+ ", post=" + post + "]";
}
}
