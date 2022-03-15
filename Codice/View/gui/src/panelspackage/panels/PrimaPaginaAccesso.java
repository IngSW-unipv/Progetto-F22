package panelspackage.panels;

import javax.swing.*;

import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.SpecificContainer;
import packageframe.Frame;
import java.awt.*;

public class PrimaPaginaAccesso extends JPanel{
	private Etichette titolo;
	private Pulsanti signUp, login;

	public PrimaPaginaAccesso() {
		
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(Frame.COLORESECONDARIOTEMATICO);	
		
		SpecificContainer containerNorth = new SpecificContainer();
		this.add(containerNorth, BorderLayout.NORTH);

		containerNorth.add(titolo = new Etichette("SOCIAL NETWORK", SwingConstants.CENTER, Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", Font.BOLD | Font.ITALIC, 40)), BorderLayout.CENTER);
		
		SpecificContainer containerSouth = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
		containerSouth.setLayout(new GridLayout(1, 2));
		this.add(containerSouth, BorderLayout.SOUTH);
		
		containerSouth.add(login = new Pulsanti("ACCEDI", Frame.COLOREPRIMARIOTEMATICO));
		containerSouth.add(signUp = new Pulsanti("REGISTRATI", Frame.COLOREPRIMARIOTEMATICO));
	}

	public Pulsanti getLogin() {
		return login;
	}

	public void setLogin(Pulsanti login) {
		this.login = login;
	}

	public Pulsanti getSignUp() {
		return signUp;
	}

	public void setSignUp(Pulsanti signUp) {
		this.signUp = signUp;
	}
	
}
