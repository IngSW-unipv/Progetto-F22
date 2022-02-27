package panelspackage.panels;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.util.ArrayList;

import panelspackage.panels.elements.GrigliaDiElementi;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.SpecificContainer;
public class LogIn extends JPanel {

	private JLabel titolo;
	
	private JLabel testoEmail;
	private JLabel testoPassword;
	
	private JTextField email;
	private JTextField password;
	
	private JButton accedi;
	
	private static final long serialVersionUID = 1L;
	ArrayList<JComponent> ListaAreaTesto = new ArrayList<JComponent>();
	ArrayList<String> dati = new ArrayList<String>();
	Color ARANCIONE = new Color(255, 125, 0);
	Color NERO = new Color(0, 0, 0);
	int i;
	
	public LogIn() {
		
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(NERO);	
		
		SpecificContainer containerNorth = new SpecificContainer();
		this.add(containerNorth, BorderLayout.NORTH);

		titolo = new JLabel("Login", SwingConstants.CENTER);
		titolo.setForeground(ARANCIONE);
		titolo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
		containerNorth.add(titolo, BorderLayout.CENTER);
		
		Container containerGenerale = new Container();
		containerGenerale.setLayout(new GridLayout(2, 2));
		
		SpecificContainer containerCenter = new SpecificContainer(ARANCIONE);
		containerCenter.setLayout(new GridLayout(3, 1));
		this.add(containerCenter, BorderLayout.CENTER);
		
		Container containerVuoto = new Container();
		Container containerVuoto1 = new Container();
		
		testoEmail = new JLabel("EMAIL: ", SwingConstants.CENTER);
		testoEmail.setForeground(ARANCIONE);
		testoEmail.setFont(new Font("Arial", Font.BOLD, 25));
		testoPassword = new JLabel("PASSWORD: ", SwingConstants.CENTER);
		testoPassword.setForeground(ARANCIONE);
		testoPassword.setFont(new Font("Arial", Font.BOLD, 25));
		
		email = new JTextField();
		email.setBorder(new LineBorder(NERO,1));
		email.setFont(new Font("Arial", Font.PLAIN, 30));
		password = new JTextField();
		password.setBorder(new LineBorder(NERO,1));
		password.setFont(new Font("Arial", Font.PLAIN, 30));
		
		containerGenerale.add(testoEmail);
		containerGenerale.add(email);
		containerGenerale.add(testoPassword);
		containerGenerale.add(password);
		
		containerCenter.add(containerVuoto);
		containerCenter.add(containerGenerale);
		containerCenter.add(containerVuoto1);

		
		
		
		
		
		
		/*this.dati.add("Email");
		this.dati.add("Password");
		for( i = 0; i < this.dati.size(); i++) {
			AreaDiTesto area = new AreaDiTesto(ARANCIONE, this.dati.get(i));
			ListaAreaTesto.add(area);
		}
		
		GrigliaDiElementi Dati =  new GrigliaDiElementi(ListaAreaTesto,1,5, ListaAreaTesto.size());
		containerCenter.add(Dati, BorderLayout.CENTER);*/
		
		SpecificContainer containerSouth = new SpecificContainer(NERO);
		this.add(containerSouth, BorderLayout.SOUTH);
		
		accedi = new JButton("ACCEDI");
		containerSouth.add(accedi, BorderLayout.CENTER);
	}

	public ArrayList<JComponent> getListaAreaTesto() {
		return ListaAreaTesto;
	}

	public void setListaAreaTesto(ArrayList<JComponent> listaAreaTesto) {
		ListaAreaTesto = listaAreaTesto;
	}

	//GETTER E SETTER PULSANTI
	public JButton getAccedi() {
		return accedi;
	}

	public void setAccedi(JButton accedi) {
		this.accedi = accedi;
	}

}
