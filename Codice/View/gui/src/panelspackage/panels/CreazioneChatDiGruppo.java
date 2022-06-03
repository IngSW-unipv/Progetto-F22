package panelspackage.panels;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import packageframe.Frame;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.InserimentoTesto;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.SpecificContainer;

@SuppressWarnings("serial")
public class CreazioneChatDiGruppo extends JPanel {
	
	private InserimentoTesto nomeGruppo;
	private InserimentoTesto descrizioneGruppo;
	private JFileChooser fotoDiProfiloGruppo;
	private Pulsanti creaGruppo;
	
	public CreazioneChatDiGruppo() {
		avvio();
		initComponents();
		
	}
	
	public void avvio() {
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(Frame.COLORESECONDARIOTEMATICO);
	}
	
	public void initComponents() {
		SpecificContainer containerNorth = new SpecificContainer();
		containerNorth.setLayout(new GridLayout(5,1));
		this.add(containerNorth, BorderLayout.NORTH);
		
		nomeGruppo = new InserimentoTesto("Nome del gruppo", Frame.COLOREPRIMARIOTEMATICO, new Font("Times New Roman", 1, 14), 30);
		descrizioneGruppo = new InserimentoTesto("Descrizione del gruppo", Frame.COLOREPRIMARIOTEMATICO, new Font("Times New Roman", 1, 14), 30);
		
		containerNorth.add(new Etichette("Inserire li nome del gruppo: ", Frame.COLOREPRIMARIOTEMATICO));
		containerNorth.add(nomeGruppo);
		containerNorth.add(new Etichette("Inserire la descrizione del gruppo: ", Frame.COLOREPRIMARIOTEMATICO));
		containerNorth.add(descrizioneGruppo);
		containerNorth.add(new Etichette("Scegliere l'immagine del gruppo: ", Frame.COLOREPRIMARIOTEMATICO));
		
		
		SpecificContainer containerCenter = new SpecificContainer();
		this.add(containerCenter, BorderLayout.CENTER);
		
		fotoDiProfiloGruppo = new JFileChooser();
		fotoDiProfiloGruppo.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter1 = new FileNameExtensionFilter("Image post (.png)", "png");
        FileNameExtensionFilter filter2 = new FileNameExtensionFilter("Image post (.jpg)", "jpg");
        FileNameExtensionFilter filter3 = new FileNameExtensionFilter("Image post (.jpeg)", "jpeg");

        fotoDiProfiloGruppo.addChoosableFileFilter(filter1);
        fotoDiProfiloGruppo.addChoosableFileFilter(filter2);
        fotoDiProfiloGruppo.addChoosableFileFilter(filter3);
        
		containerCenter.add(fotoDiProfiloGruppo);
		
		
		SpecificContainer containerSouth = new SpecificContainer();
		this.add(containerSouth, BorderLayout.SOUTH);
		
		creaGruppo = new Pulsanti("Crea chat", Frame.COLOREPRIMARIOTEMATICO);
		containerSouth.add(creaGruppo);
		
	}
	
	
	public InserimentoTesto getNomeGruppo() {
		return nomeGruppo;
	}
	
	public void setNomeGruppo(InserimentoTesto nomeGruppo) {
		this.nomeGruppo = nomeGruppo;
	}
	
	public InserimentoTesto getDescrizioneGruppo() {
		return descrizioneGruppo;
	}
	
	public void setDescrizioneGruppo(InserimentoTesto descrizioneGruppo) {
		this.descrizioneGruppo = descrizioneGruppo;
	}
	
	public JFileChooser getFotoDiProfiloGruppo() {
		return fotoDiProfiloGruppo;
	}
	
	public void setFotoDiProfiloGruppo(JFileChooser fotoDiProfiloGruppo) {
		this.fotoDiProfiloGruppo = fotoDiProfiloGruppo;
	}
	
	public Pulsanti getCreaGruppo() {
		return creaGruppo;
	}
	
	public void setCreaGruppo(Pulsanti creaGruppo) {
		this.creaGruppo = creaGruppo;
	}
	
	public String getPercorsoImmagineGruppo() {
		return this.fotoDiProfiloGruppo.getSelectedFile().getAbsolutePath();
	}
	
	
}
