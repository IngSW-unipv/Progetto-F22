package panelspackage.panels;

import java.awt.BorderLayout;

import panelspackage.panels.elements.Pulsanti;

public class PostVisualizzatoProprio extends PostVisualizzato {
	public PostVisualizzatoProprio() {
		super();
		super.getAreaDescrizione().setEditable(true);
		Pulsanti eliminaPost = new Pulsanti("elimina post", ARANCIONE);
		super.getContainerNorth().add(eliminaPost, BorderLayout.EAST);
	}

}
