package panelspackage.panels;
import javax.swing.*;
import packageframe.Frame;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.util.ArrayList;

import panelspackage.panels.elements.GrigliaDiElementi;
import panelspackage.panels.elements.InserimentoTesto;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.SpecificContainer;
public class SignUp extends JPanel {
	
	private JLabel titolo,testoEmail,testoPassword,testoRipetiPassword, testoUsername;
	private InserimentoTesto email,password,ripetiPassword,username;
	private Pulsanti registrati;
	private Pulsanti indietro;
	
	ArrayList<JComponent> ListaAreaTesto = new ArrayList<JComponent>();
	ArrayList<String> dati = new ArrayList<String>();

	int i;
	
	public SignUp() {
		avvio();
		initComponents();
	}
	
	public void avvio() {
		setOpaque(true);
		setVisible(true);
		setLayout(new BorderLayout());
		setBackground(Frame.COLORESECONDARIOTEMATICO);	
	}
	
	public void initComponents() {
		SpecificContainer containerNorth = new SpecificContainer();
		add(containerNorth, BorderLayout.NORTH);
		containerNorth.add(titolo = new Etichette("Sign Up", SwingConstants.CENTER,Frame.COLOREPRIMARIOTEMATICO,new Font("Arial", Font.BOLD | Font.ITALIC, 40)), BorderLayout.CENTER);		
		Container containerGenerale = new Container();
		containerGenerale.setLayout(new GridLayout(3, 1));
		Container containerVuoto = new Container();
		Container containerVuoto1 = new Container();
		SpecificContainer containerCenter = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
		containerCenter.setLayout(new GridLayout(4, 2));
		add(containerGenerale, BorderLayout.CENTER);
		
		containerCenter.add(testoEmail = new Etichette("EMAIL: ", SwingConstants.CENTER, Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", Font.BOLD, 25)));
		containerCenter.add(email = new InserimentoTesto(Frame.COLORESECONDARIOTEMATICO, new Font("Arial", Font.PLAIN, 30)));
		containerCenter.add(testoPassword = new Etichette("PASSWORD: ", SwingConstants.CENTER,Frame.COLOREPRIMARIOTEMATICO,new Font("Arial", Font.BOLD, 25)));
		containerCenter.add(password = new InserimentoTesto(Frame.COLORESECONDARIOTEMATICO, new Font("Arial", Font.PLAIN, 30)));
		containerCenter.add(testoRipetiPassword = new Etichette("RIPETI PASSWORD: ", SwingConstants.CENTER,Frame.COLOREPRIMARIOTEMATICO,new Font("Arial", Font.BOLD, 25)));
		containerCenter.add(ripetiPassword = new InserimentoTesto(Frame.COLORESECONDARIOTEMATICO, new Font("Arial", Font.PLAIN, 30)));
		containerCenter.add(testoUsername = new Etichette("USERNAME: ", SwingConstants.CENTER, Frame.COLOREPRIMARIOTEMATICO,new Font("Arial", Font.BOLD, 25)));
		containerCenter.add(username = new InserimentoTesto(Frame.COLORESECONDARIOTEMATICO, new Font("Arial", Font.PLAIN, 30)));
		
		containerGenerale.add(containerVuoto);
		containerGenerale.add(containerCenter);
		containerGenerale.add(containerVuoto1);
		
		SpecificContainer containerSouth = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
		add(containerSouth, BorderLayout.SOUTH);
		
		registrati = new Pulsanti("REGISTRATI", Frame.COLOREPRIMARIOTEMATICO);
		indietro = new Pulsanti("INDIETRO", Frame.COLOREPRIMARIOTEMATICO);
		containerSouth.setLayout(new GridLayout(2,1));
		containerSouth.add(registrati);
		containerSouth.add(indietro);

	}
	public ArrayList<JComponent> getListaAreaTesto() {
		return ListaAreaTesto;
	}

	public void setListaAreaTesto(ArrayList<JComponent> listaAreaTesto) {
		ListaAreaTesto = listaAreaTesto;
	}

	public Pulsanti getRegistrati() {
		return registrati;
	}

	public void setRegistrati(Pulsanti registrati) {
		this.registrati = registrati;
	}
	public String getEmailPerReigstrarsi() {
		return this.email.getText();
	}
	public String getPasswordPerRegistrarsi() {
		return this.password.getText();
	}

	public String getNickNamePerReigstrarsi() {
		return this.username.getText();
	}

	public Pulsanti getIndietro() {
		return indietro;
	}

	public void setIndietro(Pulsanti indietro) {
		this.indietro = indietro;
	}
	
}