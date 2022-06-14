package panelspackage.panels;

import packageframe.Frame;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import panelspackage.panels.elements.InserimentoTesto;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.SpecificContainer;

@SuppressWarnings("serial")
public class LogIn extends JPanel {


	private HashMap<String, JComponent> listaComponenti = new HashMap<String, JComponent>();
	
	private ArrayList<String> dati = new ArrayList<String>();
	
	private Pulsanti login, signup;
	
	private InserimentoTesto inserimentoEmail, inserimentoPassword;
	private Etichette etichettaDiSegnalazioneLoginFallito;
	
	
	public LogIn() {
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
		this.add(containerNorth, BorderLayout.NORTH);

		containerNorth.add(new Etichette("Login", Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", Font.PLAIN | Font.ITALIC, 40)), BorderLayout.CENTER);
		
		SpecificContainer containerCenter = new SpecificContainer();
		containerCenter.setLayout(new GridLayout(2, 1));
		this.add(containerCenter, BorderLayout.CENTER);
		
		SpecificContainer containerCenterAlto = new SpecificContainer();
		containerCenterAlto.setLayout(new GridLayout(3, 2));
		Container containerVuoto = new Container();
		containerCenterAlto.add(containerVuoto);
		Container containerVuoto1 = new Container();
		containerCenterAlto.add(containerVuoto1);
		containerCenterAlto.add(new Etichette("EMAIL: ", SwingConstants.CENTER, Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", Font.BOLD, 25)));
		containerCenterAlto.add(inserimentoEmail = new InserimentoTesto(Frame.COLORESECONDARIOTEMATICO, new Font("Arial", Font.BOLD, 25)));
		containerCenterAlto.add(new Etichette("PASSWORD: ", SwingConstants.CENTER, Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", Font.BOLD, 25)));
		containerCenterAlto.add(inserimentoPassword = new InserimentoTesto(Frame.COLORESECONDARIOTEMATICO, new Font("Arial", Font.BOLD, 25)));
		
		SpecificContainer containerCenterBasso = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
		containerCenterBasso.add(etichettaDiSegnalazioneLoginFallito = new Etichette("Login fallito, provare a reinserire i dati", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.NORTH);
		etichettaDiSegnalazioneLoginFallito.setVisible(false);
		
		containerCenter.add(containerCenterAlto);
		containerCenter.add(containerCenterBasso);
		
		//listaComponenti.put("labelEmail", new Etichette("EMAIL: ", SwingConstants.CENTER, Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", Font.BOLD, 25)));
		//listaComponenti.put("email", new JScrollPane(inserimentoEmail = new AreaDiTesto(Frame.COLOREPRIMARIOTEMATICO, "email", 1, 1, 20/*, new Font("Arial", Font.BOLD, 25)*/), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));	
		//listaComponenti.put("labelPwd", new Etichette("PASSWORD: ", SwingConstants.CENTER, Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", Font.BOLD, 25)));
		//listaComponenti.put("password", new JScrollPane(inserimentoPassword = new AreaDiTesto(Frame.COLOREPRIMARIOTEMATICO, "pwd", 1, 1, 20/*, new Font("Arial", Font.BOLD, 25)*/), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));	
		//GrigliaDiElementi dati =  new GrigliaDiElementi(listaComponenti,2,2, listaComponenti.size());
		//containerNorth.add(dati, BorderLayout.SOUTH);
		
		//SpecificContainer containerCenter = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
		//add(containerCenter, BorderLayout.CENTER);
		//containerCenter.add(etichettaDiSegnalazioneLoginFallito = new Etichette("Login fallito, provare a reinserire i dati", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.NORTH);
		//etichettaDiSegnalazioneLoginFallito.setVisible(false);
		
		SpecificContainer containerSouth = new SpecificContainer();
		add(containerSouth, BorderLayout.SOUTH);
		containerSouth.setLayout(new GridLayout(2, 1));
		containerSouth.add(login = new Pulsanti("LOGIN", Frame.COLOREPRIMARIOTEMATICO));
		containerSouth.add(signup = new Pulsanti("SIGNUP", Frame.COLOREPRIMARIOTEMATICO));
		
		listaComponenti.put("signup", signup);
		listaComponenti.put("accedi", login);
		
	}
	
	public void setListaComponenti(HashMap<String, JComponent> listaComponenti) {
		this.listaComponenti = listaComponenti;
	}
	
	@SuppressWarnings("rawtypes")
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

	public InserimentoTesto getInserimentoEmail() {
		return inserimentoEmail;
	}

	public void setInserimentoEmail(InserimentoTesto inserimentoEmail) {
		this.inserimentoEmail = inserimentoEmail;
	}

	public InserimentoTesto getInserimentoPassword() {
		return inserimentoPassword;
	}

	public void setInserimentoPassword(InserimentoTesto inserimentoPassword) {
		this.inserimentoPassword = inserimentoPassword;
	}
	public Etichette getEtichettaErroreLogin() {
		return etichettaDiSegnalazioneLoginFallito;
	}

	public InserimentoTesto getInserimentoPwd() {
		return inserimentoPassword;
	}
	
}
