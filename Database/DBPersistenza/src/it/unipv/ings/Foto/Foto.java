package it.unipv.ings.Foto;

public class Foto {

	public Foto(String idFoto, String perscorso, String post) {
		super();
		this.idFoto = idFoto;
		this.perscorso = perscorso;
		this.post = post;
	}
	private String idFoto;
	private String perscorso;
	private String post;
	public String getIdFoto() {
		return idFoto;
	}
	public void setIdFoto(String idFoto) {
		this.idFoto = idFoto;
	}
	public String getPerscorso() {
		return perscorso;
	}
	public void setPerscorso(String perscorso) {
		this.perscorso = perscorso;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	@Override
	public String toString() {
		return "Foto [idFoto=" + idFoto + ", perscorso=" + perscorso + ", post=" + post + "]";
	}
}
