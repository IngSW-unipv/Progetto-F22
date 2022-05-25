package post.multimedia;


import post.Post;

public abstract class Multimedia extends Post{

	public Multimedia(String idPost, String descrizione, boolean visibile, boolean condivisibile, String profilo, String percorso) {
		super(idPost,descrizione, visibile, condivisibile,
				profilo);
		
		this.tempoCancellazione = 0;
		this.percorso = percorso;
		this.isStory = false;
	}
	private int tempoCancellazione;
    private String percorso;
    private boolean isStory;
	public String getPercorso() {
		return percorso;
	}
	public void setPercorso(String percorso) {
		this.percorso = percorso;
	}
	public int getTempoCancellazione() {
		return tempoCancellazione;
	}
	public void setTempoCancellazione(int tempoCancellazione) {
		this.tempoCancellazione = tempoCancellazione;
	}
	public boolean isStory() {
		return isStory;
	}
	public void setStory(boolean isStory) {
		this.isStory = isStory;
	}
	@Override
	public String toString() {
		return super.toString() + ", tempoCancellazione = " + tempoCancellazione + ", percorso = " + percorso + ", isStory = "
				+ isStory ;
	}
	
}
