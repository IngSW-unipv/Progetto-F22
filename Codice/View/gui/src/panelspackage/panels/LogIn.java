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
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.SpecificContainer;

public class LogIn extends JPanel {

	private int i;

	private HashMap<String, JComponent> listaComponenti = new HashMap<String, JComponent>();
	
	private ArrayList<String> dati = new ArrayList<String>();
	
	private AreaDiTesto inserimentoEmail, inserimentoPassword;
	private Pulsanti accedi;
	
	
	public LogIn() {
		this.avvio();
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
		this.add(containerNorth, BorderLayout.NORTH);

		containerNorth.add(new Etichette("Login", Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", Font.PLAIN | Font.ITALIC, 40)), BorderLayout.CENTER);
		
		SpecificContainer containerCenter = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
		containerCenter.setLayout(new GridLayout(3, 1));
		this.add(containerCenter, BorderLayout.CENTER);
		
		listaComponenti.put("password", new JScrollPane(inserimentoPassword = new AreaDiTesto(Frame.COLOREPRIMARIOTEMATICO, "pwd", 1, 1, 20/*, new Font("Arial", Font.BOLD, 25)*/), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
		listaComponenti.put("signup", new Pulsanti("Sign Up", Frame.COLOREPRIMARIOTEMATICO));
		listaComponenti.put("email", new JScrollPane(inserimentoEmail = new AreaDiTesto(Frame.COLOREPRIMARIOTEMATICO, "email", 1, 1, 20/*, new Font("Arial", Font.BOLD, 25)*/), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));		
		listaComponenti.put("labelEmail", new Etichette("Inserisci email", Frame.COLOREPRIMARIOTEMATICO));
		listaComponenti.put("labelPwd", new Etichette("Inserisci Password", Frame.COLOREPRIMARIOTEMATICO));
		listaComponenti.put("accedi", new Pulsanti("Accedi", Frame.COLOREPRIMARIOTEMATICO));
		GrigliaDiElementi dati =  new GrigliaDiElementi(listaComponenti,2,3, listaComponenti.size());
		
		containerNorth.add(dati, BorderLayout.SOUTH);
	}
	
	public void setListaComponenti(HashMap<String, JComponent> listaComponenti) {
		this.listaComponenti = listaComponenti;
	}
	
	public HashMap getListaComponenti() {
		return this.listaComponenti;
	}

	public ArrayList<String> getDati() {
		return dati;
	}

	public void setDati(ArrayList<String> dati) {
		this.dati = dati;
	}
	
	public JButton getAccedi() {
		return (JButton) this.listaComponenti.get("accedi");
	}
	
	public JButton getSignUp() {
		return (JButton) this.listaComponenti.get("signup");
	}

	public AreaDiTesto getInserimentoEmail() {
		return inserimentoEmail;
	}

	public void setInserimentoEmail(AreaDiTesto inserimentoEmail) {
		this.inserimentoEmail = inserimentoEmail;
	}

	public AreaDiTesto getInserimentoPassword() {
		return inserimentoPassword;
	}

	public void setInserimentoPassword(AreaDiTesto inserimentoPassword) {
		this.inserimentoPassword = inserimentoPassword;
	}
	
	
	
}
