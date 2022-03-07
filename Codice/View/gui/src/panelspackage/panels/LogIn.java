package panelspackage.panels;
import packageframe.Frame;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.util.ArrayList;

import panelspackage.panels.elements.GrigliaDiElementi;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.ScrollText;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.SpecificContainer;

public class LogIn extends JPanel {

	private int i;

	private ArrayList<JComponent> listaComponenti = new ArrayList<JComponent>();
	private ArrayList<String> dati = new ArrayList<String>();
	
	private AreaDiTesto inserimentoEmail;
	private AreaDiTesto inserimentoPassword;
	private Pulsanti accedi;
	
	public LogIn(int base, int altezza) {
		
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(Frame.COLORESECONDARIOTEMATICO);	
		this.setBounds(0,0,base,altezza);

		SpecificContainer containerNorth = new SpecificContainer();
		this.add(containerNorth, BorderLayout.NORTH);

		containerNorth.add(new Etichette("Login", Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", Font.PLAIN | Font.ITALIC, 40)), BorderLayout.CENTER);
		
		SpecificContainer containerCenter = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
		containerCenter.setLayout(new GridLayout(3, 1));
		this.add(containerCenter, BorderLayout.CENTER);
		

		/*testoEmail = new JLabel("EMAIL: ", SwingConstants.CENTER);
		testoEmail.setForeground(Frame.COLOREPRIMARIOTEMATICO);
		testoEmail.setFont(new Font("Arial", Font.BOLD, 25));
		testoPassword = new JLabel("PASSWORD: ", SwingConstants.CENTER);
		testoPassword.setForeground(Frame.COLOREPRIMARIOTEMATICO);
		testoPassword.setFont(new Font("Arial", Font.BOLD, 25));
		
		email = new JTextField();
		email.setBorder(new LineBorder(Frame.COLORESECONDARIOTEMATICO,1));
		email.setFont(new Font("Arial", Font.PLAIN, 30));
		password = new JTextField();
		password.setBorder(new LineBorder(Frame.COLORESECONDARIOTEMATICO,1));
		password.setFont(new Font("Arial", Font.PLAIN, 30));
		
		containerGenerale.add(testoEmail);
		containerGenerale.add(email);
		containerGenerale.add(testoPassword);
		containerGenerale.add(password);
		
		containerCenter.add(containerVuoto);
		containerCenter.add(containerGenerale);
		containerCenter.add(containerVuoto1);
		*/
		
		inserimentoEmail = new AreaDiTesto(Frame.COLOREPRIMARIOTEMATICO, "email", 1, 1, 20/*, new Font("Arial", Font.BOLD, 25)*/);
		inserimentoPassword = new AreaDiTesto(Frame.COLOREPRIMARIOTEMATICO, "pwd", 1, 1, 20/*, new Font("Arial", Font.BOLD, 25)*/);
		
		listaComponenti.add(new Etichette("Inserisci email", Frame.COLOREPRIMARIOTEMATICO));
		listaComponenti.add(new Etichette("Inserisci Password", Frame.COLOREPRIMARIOTEMATICO));
		listaComponenti.add(new Pulsanti("Sign Up", Frame.COLOREPRIMARIOTEMATICO));
		listaComponenti.add(new JScrollPane(inserimentoEmail, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));	
		listaComponenti.add(new JScrollPane(inserimentoPassword, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));	
		listaComponenti.add(accedi = new Pulsanti("Accedi", Frame.COLOREPRIMARIOTEMATICO));
		
		GrigliaDiElementi Dati =  new GrigliaDiElementi(listaComponenti,2,3, listaComponenti.size());
		containerNorth.add(Dati, BorderLayout.SOUTH);
	}

	public ArrayList<JComponent> getListaAreaTesto() {
		return listaComponenti;
	}

	public void setListaAreaTesto(ArrayList<JComponent> listaAreaTesto) {
		listaComponenti = listaAreaTesto;
	}

	//GETTER E SETTER PULSANTI
	public ArrayList<String> getDati() {
		return dati;
	}

	public void setDati(ArrayList<String> dati) {
		this.dati = dati;
	}


	public ArrayList<JComponent> getListaComponenti() {
		return listaComponenti;
	}

	public void setListaComponenti(ArrayList<JComponent> listaComponenti) {
		this.listaComponenti = listaComponenti;
	}
	
	public JButton getAccedi() {
		return (JButton) this.listaComponenti.get(6);
	}
	
	public JButton getSignUp() {
		return (JButton) this.listaComponenti.get(3);
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
