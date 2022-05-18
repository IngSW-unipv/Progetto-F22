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
	private AreaDiTesto areaDescrizione, areaNuovaMail;
	private Box areaCambioSesso;
	private SpecificContainer containerCenter;
	
	int i;
	private static String visibilita[]  = {"Pubblico", "Privato"};
	private static String colori[] = {"arancione", "verde"};
	private static String sesso[] = {"maschio", "femmina","altro"};
	private static String profili[] = {"Profilo1", "Profilo2", "Profilo3", "Profilo4"};
	
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
		//mappaPulsanti.put("cambiaprofilo",new Pulsanti("Cambia profilo", Frame.COLOREPRIMARIOTEMATICO));
		mappaPulsanti.put("cambiaProfilo", new Box(getProfili(), Frame.COLOREPRIMARIOTEMATICO));
		mappaPulsanti.put("visibilita", new Box(getVisibilita(), Frame.COLOREPRIMARIOTEMATICO));
		mappaPulsanti.put("visibilitapost", new Pulsanti("Visibilita' post", Frame.COLOREPRIMARIOTEMATICO));
		mappaPulsanti.put("cambiaColori", new Box(getColori(), Frame.COLOREPRIMARIOTEMATICO));
		mappaPulsanti.put("logout", new  Pulsanti("Logout", Frame.COLOREPRIMARIOTEMATICO));
		mappaPulsanti.put("eliminaaccount",new Pulsanti("Elimina account", Frame.COLOREPRIMARIOTEMATICO));
			
		mappaPulsanti.forEach((key, value) -> containerWest.add(value));

		containerCenter = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
		this.add(containerCenter, BorderLayout.CENTER);

		containerCenter.setLayout(new GridLayout(4,1));

		containerCenter.add(areaDescrizione = new AreaDiTesto(Frame.COLOREPRIMARIOTEMATICO, "inserisci la tua nuova descrizione profilo"));
		containerCenter.add(areaCambioSesso = new Box(getSesso(), Frame.COLOREPRIMARIOTEMATICO));
		containerCenter.add(areaNuovaMail= new AreaDiTesto(Frame.COLOREPRIMARIOTEMATICO, "inserisci una nuova mail"));
		containerCenter.setVisible(false);

		SpecificContainer containerSouth = new SpecificContainer();
		this.add(containerSouth, BorderLayout.SOUTH);
		containerSouth.setLayout(new GridLayout(2, 1));
		containerSouth.add(salvaModifiche = new Pulsanti("Salva le modifiche", Frame.COLORESECONDARIOTEMATICO),BorderLayout.CENTER);
		containerSouth.add(homeImpostazioni = new Pulsanti("Torna alla home", Frame.COLORESECONDARIOTEMATICO),BorderLayout.CENTER);
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
	
	public String[] getProfili() {
		return profili;
	}
	
	
	public SpecificContainer getContainerCenter() {
		return this.containerCenter;
	}
	public Pulsanti getModificaProfilo() {
		return (Pulsanti) mappaPulsanti.get("modificaprofilo");
	}
	
	public Box getCambiaProfilo() {
		return (Box) mappaPulsanti.get("cambiaProfilo");
	}
	
	public Box getVisibilitaProfilo() {
		return (Box) mappaPulsanti.get("visibilita");
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
	
