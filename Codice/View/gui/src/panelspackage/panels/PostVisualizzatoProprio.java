package panelspackage.panels;

import java.awt.BorderLayout;

import panelspackage.panels.elements.AddPostButton;

public class PostVisualizzatoProprio extends PostVisualizzato {
	public PostVisualizzatoProprio() {
		super();
		super.getAreaDescrizione().setEditable(true);
		AddPostButton eliminaPost = new AddPostButton("elimina post", ARANCIONE);
		super.getContainerNorth().add(eliminaPost, BorderLayout.EAST);
	}

}
