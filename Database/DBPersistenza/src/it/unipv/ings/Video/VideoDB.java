package it.unipv.ings.Video;

public class VideoDB {
public VideoDB(String idVideo, int durata, String percorso, String post, boolean isStory) {
		super();
		this.idVideo = idVideo;
		this.durata = durata;
		this.percorso = percorso;
		this.post = post;
		this.isStory = isStory;
	}
private String idVideo;
private int durata;
private String percorso;
private String post;
private boolean isStory;
public String getIdVideo() {
	return idVideo;
}
public void setIdVideo(String idVideo) {
	this.idVideo = idVideo;
}
public int getDurata() {
	return durata;
}
public void setDurata(int durata) {
	this.durata = durata;
}
public String getPercorso() {
	return percorso;
}
public void setPercorso(String percorso) {
	this.percorso = percorso;
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
	return "VideoDB [idVideo=" + idVideo + ", durata=" + durata + ", percorso=" + percorso + ", post=" + post
			+ ", isStory=" + isStory + "]";
}
}
