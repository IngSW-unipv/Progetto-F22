package panelspackage.panels;
import packageframe.Frame;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import panelspackage.panels.elements.GrigliaDiElementi;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.ScrollText;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.Box;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.SpecificContainer;

public class CreazionePost extends JPanel {

	private int i;

	//private HashMap<String, JComponent> listaComponenti = new HashMap<String, JComponent>();
	private AreaDiTesto inserimentoCommentoPost;
	private Pulsanti homeCreazionePost;
	private Pulsanti pubblicaPost;
	private Pulsanti caricaPost;
	private Etichette testoInserisciCommento;
	//static String visibilita[]  = {"Pubblico", "Privato"};
	
	public CreazionePost() {
		this.avvio();
		this.initComponents();
	}
		
	public void avvio() {
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(Frame.COLORESECONDARIOTEMATICO);	
		//this.setBounds(0,0,base,altezza);
	}
	
	public void initComponents() {
		SpecificContainer containerNorth = new SpecificContainer();
		this.add(containerNorth, BorderLayout.NORTH);

		containerNorth.add(new Etichette("Personalizza il tuo post", Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", Font.PLAIN | Font.ITALIC, 40)), BorderLayout.CENTER);
		
		pubblicaPost = new Pulsanti("Carica un file", Frame.COLOREPRIMARIOTEMATICO);
		
		SpecificContainer containerCenter = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
		//containerCenter.setLayout(new GridLayout(3, 1));
		this.add(containerCenter, BorderLayout.CENTER);
		containerCenter.add(pubblicaPost, BorderLayout.NORTH);
		SpecificContainer containerCommento = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
		containerCenter.add(containerCommento);
		inserimentoCommentoPost = new AreaDiTesto(Frame.COLOREPRIMARIOTEMATICO, "pwd", 1, 1, 20);
		testoInserisciCommento = new Etichette("Inserire il commento al post:", SwingConstants.LEFT, Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", Font.PLAIN, 20));
		containerCommento.add(testoInserisciCommento, BorderLayout.NORTH);
		containerCommento.add(inserimentoCommentoPost, BorderLayout.CENTER);
		
		//inserimentoEmail = new AreaDiTesto(Frame.COLOREPRIMARIOTEMATICO, "email", 1, 1, 20/*, new Font("Arial", Font.BOLD, 25)*/);
		//inserimentoCommentoPost = new AreaDiTesto(Frame.COLOREPRIMARIOTEMATICO, "pwd", 1, 1, 20/*, new Font("Arial", Font.BOLD, 25)*/);
		//listaComponenti.put("InserisciCommento", new JScrollPane(inserimentoCommentoPost = new AreaDiTesto(Frame.COLOREPRIMARIOTEMATICO, ": )", 1, 1, 20/*, new Font("Arial", Font.BOLD, 25)*/), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
		//listaComponenti.put("CaricaImmagine", new Pulsanti("Carica un file", Frame.COLOREPRIMARIOTEMATICO));
		//listaComponenti.put("EtichettaInserisciCommento", new Etichette("inserisci il commento", Frame.COLOREPRIMARIOTEMATICO));
		//listaComponenti.put("Pubblica", new Pulsanti("Pubblica", Frame.COLOREPRIMARIOTEMATICO));
		//listaComponenti.put("visibilita", new Box(getVisibilita(), Frame.COLOREPRIMARIOTEMATICO));

		//GrigliaDiElementi Dati =  new GrigliaDiElementi(listaComponenti,1,4, listaComponenti.size());
		//containerCenter.add(Dati, BorderLayout.CENTER);
		
		pubblicaPost = new Pulsanti("Pubblica post", Frame.COLORESECONDARIOTEMATICO);
		
		SpecificContainer containerSouth = new SpecificContainer();
		this.add(containerSouth, BorderLayout.SOUTH);
		containerSouth.setLayout(new GridLayout(2, 1));
		containerSouth.add(pubblicaPost);
		containerSouth.add(homeCreazionePost = new Pulsanti("Torna alla home", Frame.COLORESECONDARIOTEMATICO),BorderLayout.CENTER);
	}


	public Pulsanti getHomeCreazionePost() {
		return homeCreazionePost;
	}

	public Pulsanti getPubblicaPost() {
		return pubblicaPost;
	}

	public void setPubblicaPost(Pulsanti pubblicaPost) {
		this.pubblicaPost = pubblicaPost;
	}

	public Pulsanti getCaricaPost() {
		return caricaPost;
	}

	public void setCaricaPost(Pulsanti caricaPost) {
		this.caricaPost = caricaPost;
	}

	public void setHomeCreazionePost(Pulsanti homeCreazionePost) {
		this.homeCreazionePost = homeCreazionePost;
	}
}
