package post.multimedia;


import post.Post;

public abstract class Multimedia extends Post{

	private int tempoCancellazione;
    private String percorso;
    private boolean isStory;
	
	public Multimedia(String idPost, String descrizione, boolean visibile, String profilo, String percorso, boolean isStory) {
		super(idPost,descrizione, visibile, profilo);
		this.tempoCancellazione = 0;
		this.percorso = percorso;
		this.isStory = isStory;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", tempoCancellazione = " + tempoCancellazione + ", percorso = " + percorso + ", isStory = " + isStory ;
	}

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
}
