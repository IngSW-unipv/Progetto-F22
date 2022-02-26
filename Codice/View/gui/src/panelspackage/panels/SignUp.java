package panelspackage.panels;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.util.ArrayList;

import panelspackage.panels.elements.GrigliaDiElementi;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.SpecificContainer;
public class SignUp extends JPanel {
	
	private JLabel titolo;
	private JLabel testoEmail;
	private JLabel testoPassword;
	private JLabel testoRipetiPassword;
	private JLabel testoUsername;
	
	private JTextField email;
	private JTextField password;
	private JTextField ripetiPassword;
	private JTextField username;
	
	private JButton registrati;
	
	private static final long serialVersionUID = 1L;
	ArrayList<JComponent> ListaAreaTesto = new ArrayList<JComponent>();
	ArrayList<String> dati = new ArrayList<String>();
	Color ARANCIONE = new Color(255, 125, 0);
	Color NERO = new Color(0, 0, 0);
	int i;
	
	public SignUp() {
		
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(NERO);	
		
		SpecificContainer containerNorth = new SpecificContainer();
		this.add(containerNorth, BorderLayout.NORTH);

		titolo = new JLabel("Sign Up", SwingConstants.CENTER);
		titolo.setForeground(ARANCIONE);
		titolo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
		containerNorth.add(titolo, BorderLayout.CENTER);
		
		testoEmail = new JLabel("EMAIL: ", SwingConstants.CENTER);
		testoEmail.setForeground(ARANCIONE);
		testoEmail.setFont(new Font("Arial", Font.BOLD, 25));
		testoPassword = new JLabel("PASSWORD: ", SwingConstants.CENTER);
		testoPassword.setForeground(ARANCIONE);
		testoPassword.setFont(new Font("Arial", Font.BOLD, 25));
		testoRipetiPassword = new JLabel("RIPETI PASSWORD: ", SwingConstants.CENTER);
		testoRipetiPassword.setForeground(ARANCIONE);
		testoRipetiPassword.setFont(new Font("Arial", Font.BOLD, 25));
		testoUsername = new JLabel("USERNAME: ", SwingConstants.CENTER);
		testoUsername.setForeground(ARANCIONE);
		testoUsername.setFont(new Font("Arial", Font.BOLD, 25));
		
		email = new JTextField();
		email.setBorder(new LineBorder(NERO,1));
		email.setFont(new Font("Arial", Font.PLAIN, 30));
		password = new JTextField();
		password.setBorder(new LineBorder(NERO,1));
		password.setFont(new Font("Arial", Font.PLAIN, 30));
		ripetiPassword = new JTextField();
		ripetiPassword.setBorder(new LineBorder(NERO,1));
		ripetiPassword.setFont(new Font("Arial", Font.PLAIN, 30));
		username = new JTextField();
		username.setBorder(new LineBorder(NERO,1));
		username.setFont(new Font("Arial", Font.PLAIN, 30));
		
		Container containerGenerale = new Container();
		containerGenerale.setLayout(new GridLayout(3, 1));
		
		Container containerVuoto = new Container();
		Container containerVuoto1 = new Container();
		
		SpecificContainer containerCenter = new SpecificContainer(ARANCIONE);
		containerCenter.setLayout(new GridLayout(4, 2));
		this.add(containerGenerale, BorderLayout.CENTER);
		
		containerCenter.add(testoEmail);
		containerCenter.add(email);
		containerCenter.add(testoPassword);
		containerCenter.add(password);
		containerCenter.add(testoRipetiPassword);
		containerCenter.add(ripetiPassword);
		containerCenter.add(testoUsername);
		containerCenter.add(username);
		
		containerGenerale.add(containerVuoto);
		containerGenerale.add(containerCenter);
		containerGenerale.add(containerVuoto1);
		
		SpecificContainer containerSouth = new SpecificContainer(NERO);
		this.add(containerSouth, BorderLayout.SOUTH);
		
		
		registrati = new JButton("REGISTRATI");
		containerSouth.add(registrati, BorderLayout.CENTER);
		/*
		this.dati.add("Email");
		this.dati.add("Password");
		this.dati.add("RipetiPassword");
		this.dati.add("NickName");
		for( i = 0; i < this.dati.size(); i++) {
			AreaDiTesto area = new AreaDiTesto(ARANCIONE, this.dati.get(i), 1);
			ListaAreaTesto.add(area);
		}
		
		GrigliaDiElementi Dati =  new GrigliaDiElementi(ListaAreaTesto,5,1, ListaAreaTesto.size());
		containerCenter.add(Dati, BorderLayout.NORTH);
		
		SpecificContainer containerSouth = new SpecificContainer(NERO);
		this.add(containerSouth, BorderLayout.SOUTH);
		
		Etichette etichettaSud = new Etichette("Sezione Inferiore", ARANCIONE);
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
	public JButton getRegistrati() {
		return registrati;
	}

	public void setRegistrati(JButton registrati) {
		this.registrati = registrati;
	}

}