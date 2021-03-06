package panelspackage.panels;

import javax.swing.*;
import packageframe.Frame;
import java.awt.*;
import java.util.ArrayList;
import panelspackage.panels.elements.GrigliaDiElementi;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.SpecificContainer;


public class  Profilo extends JPanel {

	private String idProfilo;
	private ArrayList<JComponent> ListaEtichette = new ArrayList<JComponent>();
	private ArrayList<Pulsanti> ListaPost = new ArrayList<Pulsanti>();
	private ArrayList<AreaDiTesto> ListaTesti = new ArrayList<AreaDiTesto>();
	private ArrayList<AreaDiTesto> listaSondaggiDoppiaScelta  = new ArrayList<AreaDiTesto>();	
	private ArrayList<String> dati = new ArrayList<String>();
	private ArrayList<AreaDiTesto> ListaSondaggi  = new ArrayList<AreaDiTesto>();
	private Pulsanti homeProfilo, immagineProf, segui, apriChat,nextFoto,prevFoto, nextSondaggio, prevSondaggio, nextSondaggioDoppiaScelta, 
					 prevSondaggioDoppiaScelta, nextTesto,prevTesto, nextTipoPost,prevTipoPost, pulsantePrimoSondaggio, pulsanteSecondoSondaggio,
					 pulsanteTerzoSondaggio, pulsantePrimoTesto, pulsanteSecondoTesto, pulsanteTerzoTesto,pulsantePrimoSondaggioDoppia, 
					 pulsanteSecondoSondaggioDoppia, pulsanteTerzoSondaggioDoppia;
	private SpecificContainer containerNorth, containerNorthNorth;
	
	private int contatoreFoto = 0, contatoreTesto = 0, contatoreSondaggio = 0, contatoreSondaggioDoppiaScelta = 0;
	
	public Profilo() {
		this.avvio();
		this.initComponents();
	}
	
	public void avvio() {
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(Frame.COLORESECONDARIOTEMATICO);	
	}
	
	public void initComponents() {
		
		containerNorth = new SpecificContainer();
		containerNorthNorth = new SpecificContainer();
		
		add(containerNorth, BorderLayout.NORTH);
		containerNorth.add(containerNorthNorth, BorderLayout.NORTH);
		containerNorthNorth.add(segui = new Pulsanti("Segui", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.EAST);
		containerNorthNorth.add(apriChat = new Pulsanti("Apri Chat", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.WEST);
		containerNorthNorth.add(new Etichette("Nome utente", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.NORTH);
		immagineProf = new Pulsanti("");
		JScrollPane pannelloFoto = new JScrollPane(immagineProf);
		pannelloFoto.setPreferredSize(new Dimension(80,80));
		containerNorthNorth.add(pannelloFoto,BorderLayout.PAGE_START);

		dati.add("Nome utente: ");
		dati.add(Integer.toString(0));
		dati.add("Numero di post: ");
		dati.add(Integer.toString(0));
		dati.add("Numero di follower: ");
		dati.add(Integer.toString(0));
		dati.add("Numero di account seguiti: ");
		dati.add(Integer.toString(0));
		dati.add("");
		dati.add("");
		dati.add("Descrizione:");
		dati.add("Per ora non ??? presente nessuna descrizione. Pu??? essere inserita nelle impostazioni.");
		
		for(int i = 0; i < this.dati.size(); i++) {
			Etichette etichetta = new Etichette(this.dati.get(i), Frame.COLOREPRIMARIOTEMATICO);
			ListaEtichette.add(etichetta);
			
		GrigliaDiElementi Dati =  new GrigliaDiElementi(ListaEtichette,6,2, ListaEtichette.size());
		containerNorth.add(Dati, BorderLayout.SOUTH);		
		}
		
		
		SpecificContainer containerCenter = new SpecificContainer();
		add(containerCenter, BorderLayout.CENTER);
		containerCenter.setLayout(new GridLayout(3,1));

		ListaPost.clear();
		for(int i = 0;  i < 3 ; i++) {
			ListaPost.add(new Pulsanti("/Users/tommasomasaracchio/immaginiDatabase/images.jpeg"));
			JScrollPane pannelloPostFoto= new JScrollPane(ListaPost.get(i));
			pannelloPostFoto.setPreferredSize(new Dimension(100,100));
			containerCenter.add(pannelloPostFoto);
		}
		
		SpecificContainer containerWest = new SpecificContainer();
		add(containerWest, BorderLayout.WEST);
		containerWest.setLayout(new GridLayout(6,1));

		ListaTesti.clear();
			AreaDiTesto primoTesto = new AreaDiTesto(Frame.getColoreprimariotematico(), 10, 20);
			ListaTesti.add(primoTesto);
			containerWest.add(pulsantePrimoTesto = new Pulsanti("Visualizza post", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.PAGE_START);
			containerWest.add(new JScrollPane(ListaTesti.get(0)), BorderLayout.PAGE_START);
		
			AreaDiTesto secondoTesto = new AreaDiTesto(Frame.getColoreprimariotematico(), 10, 20);
			ListaTesti.add(secondoTesto);
			containerWest.add(pulsanteSecondoTesto = new Pulsanti("Visualizza post", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.PAGE_START);
			containerWest.add(new JScrollPane(ListaTesti.get(1)), BorderLayout.PAGE_START);
		
			AreaDiTesto terzoTesto = new AreaDiTesto(Frame.getColoreprimariotematico(), 10, 20);
			ListaTesti.add(terzoTesto);
			containerWest.add(pulsanteTerzoTesto = new Pulsanti("Visualizza post", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.PAGE_START);
			containerWest.add(new JScrollPane(ListaTesti.get(2)), BorderLayout.PAGE_START);
		
		SpecificContainer containerEast = new SpecificContainer();
		add(containerEast, BorderLayout.EAST);
		containerEast.setLayout(new GridLayout(6,2));

		
		ListaSondaggi.clear();
			AreaDiTesto testoPrimoSondaggioDoppia = new AreaDiTesto(Frame.getColoreprimariotematico(), 10, 20);
			listaSondaggiDoppiaScelta.add(testoPrimoSondaggioDoppia);
			containerEast.add(pulsantePrimoSondaggioDoppia = new Pulsanti("Visualizza sondaggio doppia scelta", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.PAGE_START);
			containerEast.add(new JScrollPane(listaSondaggiDoppiaScelta.get(0)), BorderLayout.PAGE_START);
			
			AreaDiTesto testoSecondoSondaggioDoppia = new AreaDiTesto(Frame.getColoreprimariotematico(), 10, 20);
			listaSondaggiDoppiaScelta.add(testoSecondoSondaggioDoppia);
			containerEast.add(pulsanteSecondoSondaggioDoppia = new Pulsanti("Visualizza sondaggio doppia scelta", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.PAGE_START);
			containerEast.add(new JScrollPane(listaSondaggiDoppiaScelta.get(1)), BorderLayout.PAGE_START);
			
			AreaDiTesto testoTerzoSondaggioDoppia = new AreaDiTesto(Frame.getColoreprimariotematico(), 10, 20);
			listaSondaggiDoppiaScelta.add(testoTerzoSondaggioDoppia);
			containerEast.add(pulsanteTerzoSondaggioDoppia = new Pulsanti("Visualizza sondaggio doppia scelta", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.PAGE_START);
			containerEast.add(new JScrollPane(listaSondaggiDoppiaScelta.get(2)), BorderLayout.PAGE_START);

			ListaSondaggi.clear();
			AreaDiTesto testoPrimoSondaggio = new AreaDiTesto(Frame.getColoreprimariotematico(), 10, 20);
			ListaSondaggi.add(testoPrimoSondaggio);
			containerEast.add(pulsantePrimoSondaggio = new Pulsanti("Visualizza sondaggio scelta multipla", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.PAGE_START);
			containerEast.add(new JScrollPane(ListaSondaggi.get(0)), BorderLayout.PAGE_START);
			
			AreaDiTesto testoSecondoSondaggio = new AreaDiTesto(Frame.getColoreprimariotematico(), 10, 20);
			ListaSondaggi.add(testoSecondoSondaggio);
			containerEast.add(pulsanteSecondoSondaggio = new Pulsanti("Visualizza sondaggio scelta multipla", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.PAGE_START);
			containerEast.add(new JScrollPane(ListaSondaggi.get(1)), BorderLayout.PAGE_START);
			
			AreaDiTesto testoTerzoSondaggio = new AreaDiTesto(Frame.getColoreprimariotematico(), 10, 20);
			ListaSondaggi.add(testoTerzoSondaggio);
			containerEast.add(pulsanteTerzoSondaggio = new Pulsanti("Visualizza sondaggio scelta multipla", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.PAGE_START);
			containerEast.add(new JScrollPane(ListaSondaggi.get(2)), BorderLayout.PAGE_START);
		
		SpecificContainer containerSouth = new SpecificContainer(Frame.COLORESECONDARIOTEMATICO);
		this.add(containerSouth, BorderLayout.SOUTH);

		SpecificContainer containerGrigliaSouth = new SpecificContainer(Frame.COLORESECONDARIOTEMATICO);
		containerGrigliaSouth.setLayout(new GridLayout(1,8));
		
		containerGrigliaSouth.add(prevTesto = new Pulsanti("Idea precedente", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.WEST);
		containerGrigliaSouth.add(nextTesto = new Pulsanti("Idea successiva", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.EAST);
		containerGrigliaSouth.add(prevFoto = new Pulsanti("Foto precedente", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.WEST);
		containerGrigliaSouth.add(nextFoto = new Pulsanti("Foto successiva", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.EAST);
		containerGrigliaSouth.add(prevSondaggio = new Pulsanti("Sondaggi precedenti", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.WEST);
		containerGrigliaSouth.add(nextSondaggio = new Pulsanti("Sondaggi  successivi", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.EAST);
		containerGrigliaSouth.add(prevSondaggioDoppiaScelta = new Pulsanti("Sondaggi precedenti", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.WEST);
		containerGrigliaSouth.add(nextSondaggioDoppiaScelta = new Pulsanti("Sondaggi  successivi", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.EAST);

		containerSouth.add(containerGrigliaSouth, BorderLayout.NORTH);
		containerSouth.add(homeProfilo = new Pulsanti("Torna alla Home", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.CENTER);
	}

	
	public void setSchermataDati(int nFollower, int nSeguiti, int nPost, String nickName, String descrizione) {
		((JLabel) ListaEtichette.get(1)).setText(String.valueOf(nickName));
		((JLabel) ListaEtichette.get(3)).setText(String.valueOf(nFollower));
		((JLabel) ListaEtichette.get(5)).setText(String.valueOf(nSeguiti));
		((JLabel) ListaEtichette.get(7)).setText(String.valueOf(nPost));
		((JLabel) ListaEtichette.get(11)).setText(String.valueOf(descrizione));
	}

	public Pulsanti getHomeProfilo() {
		return homeProfilo;
	}

	public void setPostProfilo(ArrayList<String> postDelProfilo) {
		int i;
		

		if (contatoreFoto <= 0) {
			contatoreFoto = 0;
    	}

    	if (contatoreFoto > postDelProfilo.size() - 6) {
    		contatoreFoto = postDelProfilo.size() - 6;
    	}

		for (i = 0; i < postDelProfilo.size()/2 && i < 3 ; i++) {
			if (contatoreFoto < 0) {
				contatoreFoto = 0;
	    	}
			int indice =(i*2)+1 + getContatoreFoto();
			ListaPost.get(i).setIcon(new ImageIcon(postDelProfilo.get(indice)));
		}
		
		if (i<3) {
			for (int j = i; j < 3; j++) {
				Icon img2=new ImageIcon("immagini/images.png");
				ListaPost.get(j).setIcon(img2);
			}
		}
	}
	
	
	
	public void setPostTestoProfilo(ArrayList<String> postTestoDelProfilo) {

		int i;
		if (contatoreTesto <= 0) {
			contatoreTesto = 0;
    	}

    	if (contatoreTesto > postTestoDelProfilo.size() - 6) {
    		contatoreTesto = postTestoDelProfilo.size() - 6;
    	}
    	if (this.contatoreTesto > postTestoDelProfilo.size()/2 -2) {
    		contatoreTesto = postTestoDelProfilo.size()/2 - 2;
    	}
			if(postTestoDelProfilo.size()/2 < 3)  {
				for ( i = 0; i < 3 ; i++) {
					ListaTesti.get(i).setText("");
				}
			}
			
			if(postTestoDelProfilo.size() > 0)	 {
				for ( i = 0; i < postTestoDelProfilo.size()/2 && i < 3  ; i++) {
					if (contatoreTesto < 0) {
						contatoreTesto = 0;
			    	}
					ListaTesti.get(i).setText(postTestoDelProfilo.get(((i*2) + 1) + this.getContatoreTesto()));
				}
			}
	}
	public void setPostSondaggioProfilo(ArrayList<String> postSondaggioDelProfilo) {
		if (contatoreSondaggio <= 0) {
			contatoreSondaggio = 0;
    	}

    	if (contatoreSondaggio > postSondaggioDelProfilo.size() - 6) {
    		contatoreSondaggio = postSondaggioDelProfilo.size() - 6;
    	}
			if(postSondaggioDelProfilo.size()/2 < 3)  {
				int i;
				for ( i = 0; i < postSondaggioDelProfilo.size()/2 ; i++) {
					if (contatoreSondaggio < 0) {
						contatoreSondaggio = 0;
			    	}
					ListaSondaggi.get(i).setText(postSondaggioDelProfilo.get(((i*2) + 1) + this.getContatoreSondaggio()));
				}
				
				for (int j = i; j < 3; j++) {
				ListaSondaggi.get(j).setText("");
				}
			} else
				for (int i = 0; i < 3 ; i++) {
					ListaSondaggi.get(i).setText(postSondaggioDelProfilo.get(((i*2) + 1) + this.getContatoreSondaggio()));
		}
	}
	
	
	public void setPostSondaggioDoppiaSceltaProfilo(ArrayList<String> postSondaggioDoppiaSceltaDelProfilo) {
		if (contatoreSondaggioDoppiaScelta <= 0) {
			contatoreSondaggioDoppiaScelta = 0;
    	}

    	if (contatoreSondaggioDoppiaScelta > postSondaggioDoppiaSceltaDelProfilo.size() - 6) {
    		contatoreSondaggioDoppiaScelta = postSondaggioDoppiaSceltaDelProfilo.size() - 6;
    	}
			if(postSondaggioDoppiaSceltaDelProfilo.size()/2 < 3)  {
				int i;
				for ( i = 0; i < postSondaggioDoppiaSceltaDelProfilo.size()/2 ; i++) {
					if (contatoreSondaggio < 0) {
						contatoreSondaggio = 0;
			    	}
					listaSondaggiDoppiaScelta.get(i).setText(postSondaggioDoppiaSceltaDelProfilo.get(((i*2) + 1) + this.getContatoreSondaggioDoppiaScelta()));
				}
				
				for (int j = i; j < 3; j++) {
					listaSondaggiDoppiaScelta.get(j).setText("");
				}
			} else
				for (int i = 0; i < 3 ; i++) {
					listaSondaggiDoppiaScelta.get(i).setText(postSondaggioDoppiaSceltaDelProfilo.get(((i*2) + 1) + this.getContatoreSondaggioDoppiaScelta()));
		}
	}
	
	public ArrayList<JComponent> getListaAreaTesto() {
		return ListaEtichette;
	}

	public void setListaAreaTesto(ArrayList<JComponent> listaAreaTesto) {
		ListaEtichette = listaAreaTesto;
	}
	
	public Pulsanti getPulsanteFotoProfilo() {
		return this.immagineProf;
	}

	public void setHomeProfilo(Pulsanti homeProfilo) {
		this.homeProfilo = homeProfilo;
	}

	public Pulsanti getImmagineProf() {
		return immagineProf;
	}

	public void setImmagineProf(Pulsanti immagineProf) {
		
		this.immagineProf = immagineProf;
	}
	
	public void setFotoProfilo(String percorso) {
		this.immagineProf.setIcon(new ImageIcon(percorso));
	}

	public Pulsanti getPulsanteSegui() {
		return segui;
	}

	public Pulsanti getApriChat() {
		return apriChat;
	}


	public ArrayList<Pulsanti> getListaPost() {
		return ListaPost;
	}


	public void setListaPost(ArrayList<Pulsanti> listaPost) {
		ListaPost = listaPost;
	}


	public Pulsanti getNextFoto() {
		return nextFoto;
	}


	public Pulsanti getNextTipoPost() {
		return nextTipoPost;
	}


	public Pulsanti getPrevTipoPost() {
		return prevTipoPost;
	}


	public Pulsanti getPulsantePrimoSondaggio() {
		return pulsantePrimoSondaggio;
	}


	public Pulsanti getPulsanteSecondoSondaggio() {
		return pulsanteSecondoSondaggio;
	}


	public Pulsanti getPulsanteTerzoSondaggio() {
		return pulsanteTerzoSondaggio;
	}


	public int getContatoreFoto() {
		return contatoreFoto;
	}

	
	public void setContatoreFoto(int contatoreFoto) {
		this.contatoreFoto = contatoreFoto;
	}

	
	public int getContatoreTesto() {
		return contatoreTesto;
	}


	public void setContatoreTesto(int contatoreTesto) {
		this.contatoreTesto = contatoreTesto;
	}


	public int getContatoreSondaggio() {
		return contatoreSondaggio;
	}


	public void setContatoreSondaggio(int contatoreSondaggio) {
		this.contatoreSondaggio = contatoreSondaggio;
	}
	
	public void setNextFoto(Pulsanti nextFoto) {
		this.nextFoto = nextFoto;
	}


	public Pulsanti getPrevFoto() {
		return prevFoto;
	}


	public void setPrevFoto(Pulsanti prevFoto) {
		this.prevFoto = prevFoto;
	}


	public Pulsanti getNextSondaggio() {
		return nextSondaggio;
	}


	public void setNextSondaggio(Pulsanti nextSondaggio) {
		this.nextSondaggio = nextSondaggio;
	}


	public Pulsanti getPrevSondaggio() {
		return prevSondaggio;
	}


	public void setPrevSondaggio(Pulsanti prevSondaggio) {
		this.prevSondaggio = prevSondaggio;
	}


	public Pulsanti getNextTesto() {
		return nextTesto;
	}


	public void setNextTesto(Pulsanti nextTesto) {
		this.nextTesto = nextTesto;
	}


	public Pulsanti getPrevTesto() {
		return prevTesto;
	}


	public Pulsanti getPulsantePrimoSondaggioDoppia() {
		return pulsantePrimoSondaggioDoppia;
	}


	public Pulsanti getPulsanteSecondoSondaggioDoppia() {
		return pulsanteSecondoSondaggioDoppia;
	}


	public Pulsanti getPulsanteTerzoSondaggioDoppia() {
		return pulsanteTerzoSondaggioDoppia;
	}


	public void setPrevTesto(Pulsanti prevTesto) {
		this.prevTesto = prevTesto;
	}


	public Pulsanti getPulsantePrimoTesto() {
		return pulsantePrimoTesto;
	}


	public Pulsanti getPulsanteSecondoTesto() {
		return pulsanteSecondoTesto;
	}


	public Pulsanti getPulsanteTerzoTesto() {
		return pulsanteTerzoTesto;
	}


	public Pulsanti getNextSondaggioDoppiaScelta() {
		return nextSondaggioDoppiaScelta;
	}


	public void setNextSondaggioDoppiaScelta(Pulsanti nextSondaggioDoppiaScelta) {
		this.nextSondaggioDoppiaScelta = nextSondaggioDoppiaScelta;
	}


	public Pulsanti getPrevSondaggioDoppiaScelta() {
		return prevSondaggioDoppiaScelta;
	}


	public void setPrevSondaggioDoppiaScelta(Pulsanti prevSondaggioDoppiaScelta) {
		this.prevSondaggioDoppiaScelta = prevSondaggioDoppiaScelta;
	}


	public int getContatoreSondaggioDoppiaScelta() {
		return contatoreSondaggioDoppiaScelta;
	}


	public void setContatoreSondaggioDoppiaScelta(int contatoreSondaggioDoppiaScelta) {
		this.contatoreSondaggioDoppiaScelta = contatoreSondaggioDoppiaScelta;
	}
}