package post;

import java.awt.Font;
//import java.util.ArrayList;

public class Testo extends Post{
//extends Posts{
	
	private Font font;
	private String title;
	private String campoTesto;
	private String testoID;
	//private int PostInserito;
	
	
	public Testo(Font font, String campoTesto) {
		this.campoTesto = campoTesto;
		this.font = font;
	}
	

	 @Override
	public void aggiungiPost() {
			 if(campoTesto != "") {
				this.getCampoTesto();
				this.getFont();
			 }
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean eliminaPost(int post) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCampoTesto() {
		return campoTesto;
	}

	public void setCampoTesto(String campoTesto) {
		this.campoTesto = campoTesto;
	}

	public String getTestoID() {
		return testoID;
	}

	public void setTestoID(String testoID) {
		this.testoID = testoID;
	}

}
