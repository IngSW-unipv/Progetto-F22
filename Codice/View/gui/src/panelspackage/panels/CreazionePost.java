package panelspackage.panels;
import packageframe.Frame;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

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

	private AreaDiTesto inserimentoCommentoPost;
	private Pulsanti homeCreazionePost;
	private Pulsanti pubblicaPost;
	private Pulsanti caricaFile;
	private Etichette testoInserisciCommento;
	private JFileChooser fileChooser;
	
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
		
		fileChooser = new JFileChooser();
		
		SpecificContainer containerCenter = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
		this.add(containerCenter, BorderLayout.CENTER);
		containerCenter.add(fileChooser, BorderLayout.NORTH);
		
		SpecificContainer containerCommento = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
		containerCenter.add(containerCommento);
		inserimentoCommentoPost = new AreaDiTesto(Frame.COLOREPRIMARIOTEMATICO, "pwd", 1, 1, 20);
		testoInserisciCommento = new Etichette("Inserire il commento al post:", SwingConstants.LEFT, Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", Font.PLAIN, 20));
		containerCommento.add(testoInserisciCommento, BorderLayout.NORTH);
		containerCommento.add(inserimentoCommentoPost, BorderLayout.CENTER);
		
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

	public Pulsanti getCaricaFile() {
		return caricaFile;
	}

	public void setCaricaFile(Pulsanti caricaFile) {
		this.caricaFile = caricaFile;
	}

	public void setHomeCreazionePost(Pulsanti homeCreazionePost) {
		this.homeCreazionePost = homeCreazionePost;
	}

	public JFileChooser getFileChooser() {
		return fileChooser;
	}

	public void setFileChooser(JFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}
	
}
