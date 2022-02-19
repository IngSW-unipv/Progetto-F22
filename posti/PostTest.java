package posti;

public class PostTest {
	public static void main(String[] args) {
		Multimedia m = new  Multimedia();
		
		
		m.getPost().add("Foto");
		m.getPost().add("Video");
		m.getPost().add("Story");
		m.getPost().add("Sondaggio");
		
		
		
		
		
		m.aggiungiPost();
		m.eliminaPost(2);
		
	}

}
