package panelspackage.panels;
import javax.swing.*;
import packageframe.Frame;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.util.ArrayList;

import panelspackage.panels.elements.GrigliaDiElementi;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.SpecificContainer;
public class SignUp extends JPanel {
	
	private JLabel titolo,testoEmail,testoPassword,testoRipetiPassword, testoUsername;
	private AreaDiTesto email,password,ripetiPassword,username;
	private Pulsanti registrati;
	
	ArrayList<JComponent> ListaAreaTesto = new ArrayList<JComponent>();
	ArrayList<String> dati = new ArrayList<String>();

	int i;
	
	public SignUp() {
		this.avvio();
		this.initComponents();
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
		containerNorth.add(titolo = new Etichette("Sign Up", SwingConstants.CENTER,Frame.COLOREPRIMARIOTEMATICO,new Font("Arial", Font.BOLD | Font.ITALIC, 40)), BorderLayout.CENTER);		
		Container containerGenerale = new Container();
		containerGenerale.setLayout(new GridLayout(3, 1));
		Container containerVuoto = new Container();
		Container containerVuoto1 = new Container();
		SpecificContainer containerCenter = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
		containerCenter.setLayout(new GridLayout(4, 2));
		this.add(containerGenerale, BorderLayout.CENTER);
		
		containerCenter.add(testoEmail = new Etichette("EMAIL: ", SwingConstants.CENTER, Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", Font.BOLD, 25)));
		containerCenter.add(email = new AreaDiTesto(new LineBorder(Frame.COLOREPRIMARIOTEMATICO,1),new Font("Arial", Font.PLAIN, 30)));
		containerCenter.add(testoPassword = new Etichette("PASSWORD: ", SwingConstants.CENTER,Frame.COLOREPRIMARIOTEMATICO,new Font("Arial", Font.BOLD, 25)));
		containerCenter.add(password = new AreaDiTesto(new LineBorder(Frame.COLORESECONDARIOTEMATICO,1),new Font("Arial", Font.PLAIN, 30)));
		containerCenter.add(testoRipetiPassword = new Etichette("RIPETI PASSWORD: ", SwingConstants.CENTER,Frame.COLOREPRIMARIOTEMATICO,new Font("Arial", Font.BOLD, 25)));
		containerCenter.add(ripetiPassword = new AreaDiTesto(new LineBorder(Frame.COLORESECONDARIOTEMATICO,1),new Font("Arial", Font.PLAIN, 30)));
		containerCenter.add(testoUsername = new Etichette("USERNAME: ", SwingConstants.CENTER,Frame.COLOREPRIMARIOTEMATICO,new Font("Arial", Font.BOLD, 25)));
		containerCenter.add(username = new AreaDiTesto(new LineBorder(Frame.COLORESECONDARIOTEMATICO,1),new Font("Arial", Font.PLAIN, 30)));
		
		containerGenerale.add(containerVuoto);
		containerGenerale.add(containerCenter);
		containerGenerale.add(containerVuoto1);
		
		SpecificContainer containerSouth = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
		this.add(containerSouth, BorderLayout.SOUTH);
		
		registrati = new Pulsanti("REGISTRATI");
		containerSouth.add(registrati, BorderLayout.CENTER);
		
		/*
		this.dati.add("Email");
		this.dati.add("Password");
		this.dati.add("RipetiPassword");
		this.dati.add("NickName");
		for( i = 0; i < this.dati.size(); i++) {
			AreaDiTesto area = new AreaDiTesto(COLOREPRIMARIOTEMATICO, this.dati.get(i), 1);
			ListaAreaTesto.add(area);
		}
		
		GrigliaDiElementi Dati =  new GrigliaDiElementi(ListaAreaTesto,5,1, ListaAreaTesto.size());
		containerCenter.add(Dati, BorderLayout.NORTH);
		
		SpecificContainer containerSouth = new SpecificContainer(COLORESECONDARIOTEMATICO);
		this.add(containerSouth, BorderLayout.SOUTH);
		
		Etichette etichettaSud = new Etichette("Sezione Inferiore", COLOREPRIMARIOTEMATICO);
		containerSouth.add(etichettaSud, BorderLayout.CENTER);
		*/
	}
	public ArrayList<JComponent> getListaAreaTesto() {
		return ListaAreaTesto;
	}

	public void setListaAreaTesto(ArrayList<JComponent> listaAreaTesto) {
		ListaAreaTesto = listaAreaTesto;
	}

	
	//GETTER E SETTER PULSANTI
	public Pulsanti getRegistrati() {
		return registrati;
	}

	public void setRegistrati(Pulsanti registrati) {
		this.registrati = registrati;
	}
}