package panelspackage.panels;

import javax.swing.*;

import panelspackage.panels.elements.SpecificContainer;

import java.awt.*;

public class PrimaPaginaAccesso extends JPanel{
	private JLabel titolo;
	private JButton login;
	private JButton signUp;
	private Color ARANCIONE = new Color(255, 125, 0);
	private Color NERO = new Color(0, 0, 0);
	
	public PrimaPaginaAccesso() {
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(NERO);	
		
		SpecificContainer containerNorth = new SpecificContainer();
		this.add(containerNorth, BorderLayout.NORTH);

		titolo = new JLabel("SOCIAL NETWORK", SwingConstants.CENTER);
		titolo.setForeground(ARANCIONE);
		titolo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
		containerNorth.add(titolo, BorderLayout.CENTER);
		
		SpecificContainer containerSouth = new SpecificContainer(NERO);
		containerSouth.setLayout(new GridLayout(1, 2));
		this.add(containerSouth, BorderLayout.SOUTH);
		
		login = new JButton("ACCEDI");
		signUp = new JButton("REGISTRATI");
		
		containerSouth.add(login);
		containerSouth.add(signUp);
	}

	public JButton getLogin() {
		return login;
	}

	public void setLogin(JButton login) {
		this.login = login;
	}

	public JButton getSignUp() {
		return signUp;
	}

	public void setSignUp(JButton signUp) {
		this.signUp = signUp;
	}
	
}
