package panelspackage.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import packageframe.Frame;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.Box;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.SpecificContainer;

public class Impostazioni extends JPanel {
	HashMap<String,JComponent> mappaPulsanti = new  HashMap<String,JComponent>();
	private Pulsanti homeImpostazioni, salvaModifiche;
	private AreaDiTesto areaDescrizione;
	private SpecificContainer containerCenter;
	
	int i;
	private static String colori[] = {"arancione", "verde"};
	
	public Impostazioni(String profilo) {
		avvio();
		this.initComponents(profilo);
	}
		
	public void avvio() {
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(Frame.COLORESECONDARIOTEMATICO);
	}
	public void initComponents(String profilo) {
		SpecificContainer containerNorth = new SpecificContainer();
		this.add(containerNorth, BorderLayout.NORTH);
		
		JLabel nomeProfilo = new JLabel(profilo);
		nomeProfilo.setVisible(true);
		
		nomeProfilo.setForeground(Frame.COLOREPRIMARIOTEMATICO);
		containerNorth.add(nomeProfilo, BorderLayout.CENTER);
		
		SpecificContainer containerWest = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
		this.add(containerWest, BorderLayout.WEST);
		containerWest.setLayout(new GridLayout(8,1));
		
		mappaPulsanti.put("modificaprofilo", new Pulsanti("Modifica profilo", Frame.COLOREPRIMARIOTEMATICO));
		mappaPulsanti.put("visibilitapost", new Pulsanti("Visibilita' post", Frame.COLOREPRIMARIOTEMATICO));
		mappaPulsanti.put("cambiaColori", new Box(getColori(), Frame.COLOREPRIMARIOTEMATICO));
		mappaPulsanti.put("logout", new  Pulsanti("Logout", Frame.COLOREPRIMARIOTEMATICO));
		mappaPulsanti.put("eliminaaccount",new Pulsanti("Elimina account", Frame.COLOREPRIMARIOTEMATICO));
			
		mappaPulsanti.forEach((key, value) -> containerWest.add(value));

		containerCenter = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
		this.add(containerCenter, BorderLayout.CENTER);

		containerCenter.setLayout(new GridLayout(4,1));

		containerCenter.add(areaDescrizione = new AreaDiTesto(Frame.COLOREPRIMARIOTEMATICO, "inserisci la tua nuova descrizione profilo"));
		containerCenter.setVisible(false);

		SpecificContainer containerSouth = new SpecificContainer();
		this.add(containerSouth, BorderLayout.SOUTH);
		containerSouth.setLayout(new GridLayout(2, 1));
		containerSouth.add(salvaModifiche = new Pulsanti("Salva le modifiche", Frame.COLORESECONDARIOTEMATICO),BorderLayout.CENTER);
		containerSouth.add(homeImpostazioni = new Pulsanti("Torna alla home", Frame.COLORESECONDARIOTEMATICO),BorderLayout.CENTER);
	}
	
	public String[] getColori() {
		return colori;
	}
	
	public SpecificContainer getContainerCenter() {
		return this.containerCenter;
	}
	public Pulsanti getModificaProfilo() {
		return (Pulsanti) mappaPulsanti.get("modificaprofilo");
	}
	
	public Box getCambiaColore() {
		return (Box) mappaPulsanti.get("cambiaColori");
	}

	public JButton getVisibilitaPost() {
		return (Pulsanti) mappaPulsanti.get("visibilitapost");
	}
	
	public JButton getLogout() {
		return (Pulsanti) mappaPulsanti.get("logout");
	}
	
	public Pulsanti getEliminaAccount() {
		return (Pulsanti) mappaPulsanti.get("eliminaaccount");
	}
	
	public Pulsanti getHomeImpostazioni() {
		return homeImpostazioni;
	}
	
	public Pulsanti getSalvaModifiche() {
		return salvaModifiche;
	}

}
	
