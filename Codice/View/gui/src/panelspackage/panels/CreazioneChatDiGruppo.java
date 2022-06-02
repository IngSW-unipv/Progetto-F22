package panelspackage.panels;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import packageframe.Frame;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.InserimentoTesto;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.SpecificContainer;

@SuppressWarnings("serial")
public class CreazioneChatDiGruppo extends JPanel {
	
	private InserimentoTesto nomeGruppo;
	private AreaDiTesto descrizioneGruppo;
	private InserimentoTesto inserisciNomeUtente;
	private Pulsanti aggiungiUtente;
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
		this.setBackground(Frame.COLOREPRIMARIOTEMATICO);
	}
	
	public void initComponents() {
		SpecificContainer containerNorth = new SpecificContainer();
		containerNorth.setLayout(new GridLayout(1,1));
		this.add(containerNorth, BorderLayout.NORTH);
		nomeGruppo = new InserimentoTesto("Nome del gruppo", Frame.COLOREPRIMARIOTEMATICO, new Font("Times New Roman", 1, 14), 30);
		containerNorth.add(nomeGruppo);
		
		descrizioneGruppo = new AreaDiTesto(Frame.COLORESECONDARIOTEMATICO, 50, 10, new Font("Arial", 1, 12));
		SpecificContainer containerCenter = new SpecificContainer();
		this.add(containerCenter, BorderLayout.CENTER);
		
		SpecificContainer containerSouth = new SpecificContainer();
		containerSouth.setLayout(new GridLayout(2,1));
		this.add(containerSouth, BorderLayout.SOUTH);
		inserisciNomeUtente = new InserimentoTesto("Inserici nome utente", Frame.COLORESECONDARIOTEMATICO, new Font("Times New Roman", 1, 12));
		aggiungiUtente = new Pulsanti("Aggiungi un utente", Frame.COLOREPRIMARIOTEMATICO);
		containerSouth.add(inserisciNomeUtente, aggiungiUtente);
		
		fotoDiProfiloGruppo = new JFileChooser();
		containerSouth.add(fotoDiProfiloGruppo);
		
		SpecificContainer containerEndPage = new SpecificContainer();
	    this.add(containerEndPage);
		creaGruppo = new Pulsanti(" Crea un chat di gruppo", Frame.COLOREPRIMARIOTEMATICO);
		containerEndPage.add(creaGruppo);
		
	}
	
	
	public InserimentoTesto getNomeGruppo() {
		return nomeGruppo;
	}
	
	public void setNomeGruppo(InserimentoTesto nomeGruppo) {
		this.nomeGruppo = nomeGruppo;
	}
	
	public AreaDiTesto getDescrizioneGruppo() {
		return descrizioneGruppo;
	}
	
	public void setDescrizioneGruppo(AreaDiTesto descrizioneGruppo) {
		this.descrizioneGruppo = descrizioneGruppo;
	}
	
	public InserimentoTesto getInserisciNomeUtente() {
		return inserisciNomeUtente;
	}
	
	public void setInserisciNomeUtente(InserimentoTesto inserisciNomeUtente) {
		this.inserisciNomeUtente = inserisciNomeUtente;
	}
	
	public Pulsanti getAggiungiUtente() {
		return aggiungiUtente;
	}
	
	public void setAggiungiUtente(Pulsanti aggiungiUtente) {
		this.aggiungiUtente = aggiungiUtente;
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
	
	
}
