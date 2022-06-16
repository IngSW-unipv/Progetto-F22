package panelspackage.panels;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import packageframe.Frame;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.SpecificContainer;

public class Impostazioni extends JPanel {
	
	HashMap<String,JComponent> mappaPulsanti = new  HashMap<String,JComponent>();
	private Pulsanti homeImpostazioni, salvaModifiche;
	private AreaDiTesto areaDescrizione;
	private SpecificContainer containerCenter;
	private Etichette nomeProfilo;
	
	public Impostazioni() {
		avvio();
		this.initComponents();
	}
		
	public void avvio() {
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(Frame.COLORESECONDARIOTEMATICO);
	}
	
	public void initComponents() {
		SpecificContainer containerNorth = new SpecificContainer();
		this.add(containerNorth, BorderLayout.NORTH);
		
		nomeProfilo = new Etichette("");
		nomeProfilo.setVisible(true);
		
		nomeProfilo.setForeground(Frame.COLOREPRIMARIOTEMATICO);
		containerNorth.add(nomeProfilo, BorderLayout.CENTER);
		
		SpecificContainer containerWest = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
		this.add(containerWest, BorderLayout.WEST);
		containerWest.setLayout(new GridLayout(8,1));
		
		mappaPulsanti.put("modificaprofilo", new Pulsanti("Modifica profilo", Frame.COLOREPRIMARIOTEMATICO));
		mappaPulsanti.put("logout", new  Pulsanti("Logout", Frame.COLOREPRIMARIOTEMATICO));
		mappaPulsanti.put("eliminaaccount",new Pulsanti("Elimina account", Frame.COLOREPRIMARIOTEMATICO));
			
		mappaPulsanti.forEach((key, value) -> containerWest.add(value));

		containerCenter = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
		this.add(containerCenter, BorderLayout.CENTER);

		//containerCenter.setLayout(new GridLayout(3,1));
		containerCenter.add(new Etichette("Inserisci la nuova descrizione del tuo profilo", Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", Font.BOLD, 18)), BorderLayout.NORTH);
		containerCenter.add(areaDescrizione = new AreaDiTesto(Frame.COLOREPRIMARIOTEMATICO, "Nuova descrizione"), BorderLayout.CENTER);
		containerCenter.setVisible(false);

		SpecificContainer containerSouth = new SpecificContainer();
		this.add(containerSouth, BorderLayout.SOUTH);
		containerSouth.setLayout(new GridLayout(2, 1));
		containerSouth.add(salvaModifiche = new Pulsanti("Salva le modifiche", Frame.COLORESECONDARIOTEMATICO),BorderLayout.CENTER);
		containerSouth.add(homeImpostazioni = new Pulsanti("Torna alla home", Frame.COLORESECONDARIOTEMATICO),BorderLayout.CENTER);
	}
	
	public SpecificContainer getContainerCenter() {
		return this.containerCenter;
	}
	public Pulsanti getModificaProfilo() {
		return (Pulsanti) mappaPulsanti.get("modificaprofilo");
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

	public AreaDiTesto getAreaDescrizione() {
		return areaDescrizione;
	}

	public void setAreaDescrizione(AreaDiTesto areaDescrizione) {
		this.areaDescrizione = areaDescrizione;
	}

	public Etichette getNomeProfilo() {
		return nomeProfilo;
	}
}
	
