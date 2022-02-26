package panelspackage.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import panelspackage.panels.elements.AddPostButton;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.Box;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.SpecificContainer;

public class Impostazioni extends JPanel {

	private JButton modificaProfilo;
	private JButton cambiaProfilo;
	private JButton visibilitaPost;
	private JButton logout;
	private JButton eliminaAccount;
	private JButton homeImpostazioni;
	
	private SpecificContainer containerCenter;
	
	private static final long serialVersionUID = 1L;
	Color ARANCIONE = new Color(255, 125, 0);
	Color NERO = new Color(0, 0, 0);
	static String visibilita[]  = {"Pubblico", "Privato"};
	static String colori[] = {"arancione", "verde"};
	static String sesso[] = {"maschio", "femmina","altro"};
	public Impostazioni(String profilo) {
	
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(NERO);
		
		SpecificContainer containerNorth = new SpecificContainer();
		this.add(containerNorth, BorderLayout.NORTH);
		
		JLabel nomeProfilo = new JLabel(profilo);
		nomeProfilo.setVisible(true);
		
		nomeProfilo.setForeground(ARANCIONE);
		containerNorth.add(nomeProfilo, BorderLayout.CENTER);
		
		SpecificContainer containerWest = new SpecificContainer(ARANCIONE);
		this.add(containerWest, BorderLayout.WEST);
		containerWest.setLayout(new GridLayout(8,1));
		
		modificaProfilo = new AddPostButton("Modifica profilo", NERO);
		cambiaProfilo = new AddPostButton("Cambia profilo", ARANCIONE);
		visibilitaPost = new AddPostButton("Visibilita' post", ARANCIONE);
		logout = new AddPostButton("Logout", ARANCIONE);
		eliminaAccount = new AddPostButton("Elimina account", ARANCIONE);
		homeImpostazioni = new AddPostButton("Torna alla home", NERO);
				
		containerWest.add(modificaProfilo);
		containerWest.add(cambiaProfilo);
		containerWest.add(new Box(getVisibilita(), ARANCIONE));
		containerWest.add(visibilitaPost);
		containerWest.add(new Box(getColori(), ARANCIONE));
		containerWest.add(logout);
		containerWest.add(eliminaAccount);

		
		containerCenter = new SpecificContainer(ARANCIONE);
		this.add(containerCenter, BorderLayout.CENTER);
		

		containerCenter.setLayout(new GridLayout(4,1));
		
		AreaDiTesto areaDescrizione = new AreaDiTesto(ARANCIONE, "inserisci la tua nuova descrizione profilo");
		Box areaCambioSesso = new Box(getSesso(), ARANCIONE);
		AreaDiTesto areaNuovaMail = new AreaDiTesto(ARANCIONE, "inserisci una nuova mail");

		containerCenter.add(areaDescrizione);
		containerCenter.add(areaCambioSesso);
		containerCenter.add(areaNuovaMail);

		containerCenter.setVisible(false);

		SpecificContainer containerSouth = new SpecificContainer();
		this.add(containerSouth, BorderLayout.SOUTH);
		
		containerSouth.add(homeImpostazioni, BorderLayout.CENTER);
	}
	public String[] getVisibilita() {
		return visibilita;
	}

	public String[] getColori() {
		return colori;
	}

	public String[] getSesso() {
		return sesso;
	}

	public SpecificContainer getContainerCenter() {
		return containerCenter;
	}
	public void setContainerCenter(SpecificContainer containerCenter) {
		this.containerCenter = containerCenter;
	}
	
	
	//GETTER E SETTER PULSANTI
	public JButton getModificaProfilo() {
		return modificaProfilo;
	}
	public void setModificaProfilo(JButton modificaProfilo) {
		this.modificaProfilo = modificaProfilo;
	}
	public JButton getCambiaProfilo() {
		return cambiaProfilo;
	}
	public void setCambiaProfilo(JButton cambiaProfilo) {
		this.cambiaProfilo = cambiaProfilo;
	}
	public JButton getVisibilitaPost() {
		return visibilitaPost;
	}
	public void setVisibilitaPost(JButton visibilitaPost) {
		this.visibilitaPost = visibilitaPost;
	}
	public JButton getLogout() {
		return logout;
	}
	public void setLogout(JButton logout) {
		this.logout = logout;
	}
	public JButton getEliminaAccount() {
		return eliminaAccount;
	}
	public void setEliminaAccount(JButton eliminaAccount) {
		this.eliminaAccount = eliminaAccount;
	}
	public JButton getHomeImpostazioni() {
		return homeImpostazioni;
	}
	public void setHomeImpostazioni(JButton homeImpostazioni) {
		this.homeImpostazioni = homeImpostazioni;
	}


}
	
