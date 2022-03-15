package controllerPackage;

import panelspackage.panels.Home;

public class ControllerSocial implements IcontrollerSistema{
	
	private Home homeView;
	//Inserire modello con metodi per la home 
	
	private ActionListener gestoreRicerca;
	private ActionListener gestoreAggiungiLike;
	private ActionListener gestoreAggiungiDislike;
	private ActionListener gestoreAggiungiCommento;
	private ActionListener gestorePostSuccessivo;
	private ActionListener gestorePostPrecedente;
	private ActionListener gestoreStoriaSuccessiva;
	private ActionListener gestoreStoriaPrecedente;
	private ActionListener gestorePubblicaPost;
	private ActionListener gestorePubblicaStoria;
	private ActionListener gestorePubblicaSondaggio;
	private ActionListener gestorePubblicaIdea;
	
	public ControllerSocial(Home homeView) {
		this.homeView = homeView;
		//inserire modello con metodi per la home
	}
	
	public void assegnaGestori() {
		
		gestoreRicerca = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
				System.out.println("Ricerca");
				ricercaNelSocial();
			}
		};
		homeView.getSearchButton().addActionListener(gestoreRicerca);
		
		
		gestoreAggiungiLike = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
				System.out.println("aggiungi like");
				aggiungiLike();
			}
		};
		homeView.getAggiungiLike().addActionListener(gestoreAggiungiLike);
		
		
		gestoreAggiungiDislike = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
				System.out.println("aggiungi dilike");
				aggiungiDislike();
			}
		};
		homeView.getAggiungiDislike().addActionListener(gestoreAggiungiDislike);
		
		
		gestoreAggiungiCommento = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
				System.out.println("aggiungi commento");
				aggiungiCommento();
			}
		};
		homeView.getAggiungiCommento().addActionListener(gestoreAggiungiCommento);
		
		
		gestorePostSuccessivo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
				System.out.println("post successivo");
				postSuccessivo();
			}
		};
		homeView.getButtonNextPost().addActionListener(gestorePostSuccessivo);
		
		
		gestorePostPrecedente = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
				System.out.println("post precedente");
				postPrecedente();
			}
		};
		homeView.getButtonPrevPost().addActionListener(gestorePostPrecedente);
		
		
		gestoreStoriaSuccessiva = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
				System.out.println("storia successiva");
				storiaSuccessiva();
			}
		};
		homeView.getButtonNextStory().addActionListener(gestoreStoriaSuccessiva);
		
		
		gestoreStoriaPrecedente = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
				System.out.println("storia precedente");
				storiaPrecedente();
			}
		};
		homeView.getButtonPrevStory().addActionListener(gestoreStoriaPrecedente);
		
		
		gestorePubblicaPost = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
				System.out.println("pubblica post");
				pubblicaPost();
			}
		};
		homeView.getpPost().addActionListener(gestorePubblicaPost);
		
		
		gestorePubblicaStoria = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
				System.out.println("pubblica storia");
				pubblicaStoria();
			}
		};
		homeView.getpStory().addActionListener(gestorePubblicaStoria);
		
		
		gestorePubblicaSondaggio = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
				System.out.println("pubblica sondaggio");
				pubblicaSondaggio();
			}
		};
		homeView.getpSondaggio().addActionListener(gestorePubblicaSondaggio);
		
		
		gestorePubblicaIdea = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
				System.out.println("pubblica idea");
				pubblicaIdea();
			}
		};
		homeView.getpIdea().addActionListener(gestorePubblicaIdea);
	}
}



























