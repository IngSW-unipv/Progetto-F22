package it.unipv.ings.Foto;

public class FotoDB {

	public FotoDB(String idFoto, String perscorso, String post, boolean isStory) {
		super();
		this.idFoto = idFoto;
		this.perscorso = perscorso;
		this.post = post;
		this.isStory = isStory;
	}
	private String idFoto;
	private String perscorso;
	private String post;
	private boolean isStory;
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
	public boolean isStory() {
		return isStory;
	}
	public void setStory(boolean isStory) {
		this.isStory = isStory;
	}
	@Override
	public String toString() {
		return "FotoDB [idFoto=" + idFoto + ", perscorso=" + perscorso + ", post=" + post + ", isStory=" + isStory
				+ "]";
	}
	
}
