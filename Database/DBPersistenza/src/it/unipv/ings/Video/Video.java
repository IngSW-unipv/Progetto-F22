package it.unipv.ings.Video;

public class Video {
public Video(String idVideo, int durata, String percorso, String post) {
		super();
		this.idVideo = idVideo;
		this.durata = durata;
		this.percorso = percorso;
		this.post = post;
	}
private String idVideo;
private int durata;
private String percorso;
private String post;
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
@Override
public String toString() {
	return "Video [idVideo=" + idVideo + ", durata=" + durata + ", percorso=" + percorso + ", post=" + post + "]";
}
}
