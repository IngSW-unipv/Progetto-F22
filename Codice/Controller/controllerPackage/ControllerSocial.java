package controllerPackage;

public class ControllerSocial {
	
	private Home homeView;
	//Inserire modello con metodi per la home 
	
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
		
		gestoreAggiungiLike = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
			}
		};
		//Assegnare al get del pulsante
		
		gestoreAggiungiDislike = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
			}
		};
		//Assegnare al get del pulsante
		
		gestoreAggiungiCommento = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
			}
		};
		//Assegnare al get del pulsante
		
		gestorePostSuccessivo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
			}
		};
		//Assegnare al get del pulsante
		
		gestorePostPrecedente = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
			}
		};
		//Assegnare al get del pulsante
		
		gestoreStoriaSuccessiva = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
			}
		};
		//Assegnare al get del pulsante
		
		gestoreStoriaPrecedente = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
			}
		};
		//Assegnare al get del pulsante
		
		gestorePubblicaPost = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
			}
		};
		//Assegnare al get del pulsante
		
		gestorePubblicaStoria = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
			}
		};
		//Assegnare al get del pulsante
		
		gestorePubblicaSondaggio = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
			}
		};
		//Assegnare al get del pulsante
		
		gestorePubblicaIdea = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
			}
		};
		//Assegnare al get del pulsante
	}
}



























