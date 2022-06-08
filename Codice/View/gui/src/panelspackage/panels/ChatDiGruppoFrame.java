package panelspackage.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import packageframe.Frame;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.InserimentoTesto;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.SpecificContainer;

@SuppressWarnings("serial")
public class ChatDiGruppoFrame extends JPanel {
	
	private Pulsanti foto;
	private AreaDiTesto descrizione;
	private InserimentoTesto aggiungi;
	private Pulsanti aggiungiUtente;
	private InserimentoTesto rimuovi;
	private Pulsanti rimuoviUtente;
	
	public ChatDiGruppoFrame() {
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
		
		SpecificContainer containerNorth1 = new SpecificContainer();
		this.add(containerNorth1, BorderLayout.NORTH);
		
		foto = new Pulsanti("C:/Users/aissa/OneDrive/Immagini/We can.jpg");
		JScrollPane panel = new JScrollPane(foto);
		panel.setPreferredSize(new Dimension(500,500));
		containerNorth1.add(panel, BorderLayout.PAGE_START);
		
		descrizione = new AreaDiTesto("", 60, 20);
		SpecificContainer containerNorth2 = new SpecificContainer();
		containerNorth2.setLayout(new GridLayout(2, 1));
		this.add(containerNorth2, BorderLayout.NORTH);
		containerNorth2.add(new Etichette("Inserire la descrizione", Frame.COLOREPRIMARIOTEMATICO) );
		containerNorth2.add(descrizione);
		
		aggiungi = new InserimentoTesto("", Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", 1, 14), 30);
		aggiungiUtente = new Pulsanti("Aggiungi utente", Frame.COLOREPRIMARIOTEMATICO);
		rimuovi = new InserimentoTesto("", Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", 1, 14), 30);
		rimuoviUtente = new Pulsanti("Rimuovi utente", Frame.COLOREPRIMARIOTEMATICO);
		
		SpecificContainer containerCenter = new SpecificContainer();
		containerCenter.setLayout(new GridLayout(2, 2));
		this.add(containerCenter, BorderLayout.CENTER);
		containerCenter.add(aggiungi);
		containerCenter.add(aggiungiUtente);
		containerCenter.add(rimuovi);
		containerCenter.add(rimuoviUtente);
		
		
		
	}

	
	public Pulsanti getFoto() {
		return foto;
	}

	public void setFoto(Pulsanti foto) {
		this.foto = foto;
	}

	public AreaDiTesto getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(AreaDiTesto descrizione) {
		this.descrizione = descrizione;
	}

	public InserimentoTesto getAggiungi() {
		return aggiungi;
	}

	public void setAggiungi(InserimentoTesto aggiungi) {
		this.aggiungi = aggiungi;
	}

	public Pulsanti getAggiungiUtente() {
		return aggiungiUtente;
	}

	public void setAggiungiUtente(Pulsanti aggiungiUtente) {
		this.aggiungiUtente = aggiungiUtente;
	}

	public InserimentoTesto getRimuovi() {
		return rimuovi;
	}

	public void setRimuovi(InserimentoTesto rimuovi) {
		this.rimuovi = rimuovi;
	}

	public Pulsanti getRimuoviUtente() {
		return rimuoviUtente;
	}

	public void setRimuoviUtente(Pulsanti rimuoviUtente) {
		this.rimuoviUtente = rimuoviUtente;
	}

}
