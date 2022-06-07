package panelspackage.panels;
	import javax.swing.*;
	import java.awt.*;
	import java.util.ArrayList;
	import panelspackage.panels.elements.GrigliaDiElementi;
	import panelspackage.panels.elements.LabeledIcon;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.*;
	import panelspackage.panels.elements.AreaCommenti;
	import panelspackage.panels.elements.AreaDiTesto;
	import panelspackage.panels.elements.Etichette;
	import panelspackage.panels.elements.SpecificContainer;
	import packageframe.Frame;
	
public class PostVisualizzato extends JPanel{

	
	
		ArrayList<JComponent> ListaAreaTesto = new ArrayList<JComponent>();
		ArrayList<String> dati = new ArrayList<String>();

		int indiceCommentoCorrente = 0;
		int numeroCommentiTotali = 5;
		private String messaggioBottoneSuperioreFollow = "Inizia a seguire";
		private String messaggioBottoneSuperioreProfilo = "Imposta come immagine profilo";
		private JTextArea areaDescrizione;
		private AreaCommenti areaCommenti;
		private AreaDiTesto aggiungiCommento;
		private JButton homePostVisualizzato,nextCommento, prevCommento;
		private Pulsanti impostaImmagineProfiloButton, iniziaSeguireButton,pulsantePrimaScelta,pulsanteSecondaScelta,pulsanteTerzaScelta,pulsanteQuartaScelta;
		private SpecificContainer containerNorth, containerCenter =  new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO), containerSondaggio =  new SpecificContainer(), containerPost = new SpecificContainer();
		private String fotoPath =  "C:\\Users\\franc\\OneDrive\\Immagini\\imgbin-rias-.jpg", idPost = "405";
		private ArrayList<String> postCommentiConUtenti = new ArrayList<String>();
		private Etichette fotoVisualizzata = new Etichette("/Users/tommasomasaracchio/immaginiDatabase/waifu.jpeg");
		int numeroMiPiace = 10, numeroNonMiPiace = 20, numeroComm = 3;
		
		public PostVisualizzato() {
			avvio();
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
			
			impostaImmagineProfiloButton = new Pulsanti(messaggioBottoneSuperioreProfilo, Frame.COLOREPRIMARIOTEMATICO);
			containerNorth.add(impostaImmagineProfiloButton);
			
			
			/*iniziaSeguireButton = new Pulsanti(messaggioBottoneSuperioreFollow, Frame.COLOREPRIMARIOTEMATICO);
			iniziaSeguireButton.setVisible(false);
			containerNorth.add(iniziaSeguireButton);*/

			this.add(containerCenter, BorderLayout.CENTER);

			
			//POST
			
			containerCenter.add(containerPost, BorderLayout.CENTER);
			containerPost.add(fotoVisualizzata, BorderLayout.CENTER);

			areaCommenti =  new AreaCommenti();
			containerPost.add(areaCommenti, BorderLayout.SOUTH);

			//COMMENTI
			postCommentiConUtenti.add("");
			postCommentiConUtenti.add("");
			
			postCommentiConUtenti.add("");
			postCommentiConUtenti.add("");
			
			postCommentiConUtenti.add("");
			postCommentiConUtenti.add("");
			
			postCommentiConUtenti.add("");
			postCommentiConUtenti.add("");
			
			postCommentiConUtenti.add("");
			postCommentiConUtenti.add("");
			
			
			for( int i = getIndiceCommentoCorrente();  i <  this.postCommentiConUtenti.size() - 1; i = i +2) {

			Pulsanti areaNomeProfilo = new Pulsanti(postCommentiConUtenti.get(i), Frame.COLOREPRIMARIOTEMATICO);
			Etichette areaCommento = new Etichette(postCommentiConUtenti.get(i + 1),Frame.COLOREPRIMARIOTEMATICO);
			ListaAreaTesto.add(areaNomeProfilo);
			ListaAreaTesto.add(areaCommento);	
			}
			ListaAreaTesto.add(nextCommento = new  JButton("->"));
			ListaAreaTesto.add(prevCommento = new JButton("<-"));
			
			
			SpecificContainer containerEast = new SpecificContainer();
			this.add(containerEast, BorderLayout.EAST);
			
			GrigliaDiElementi dati =  new GrigliaDiElementi(ListaAreaTesto,10,2, ListaAreaTesto.size());
			
			
			aggiungiCommento = new AreaDiTesto(Frame.COLOREPRIMARIOTEMATICO, 10, 20);
			aggiungiCommento.setEditable(true);
			JScrollPane scrollCommento = new JScrollPane(aggiungiCommento);

			containerEast.add(dati, BorderLayout.CENTER);
			containerEast.add(scrollCommento,  BorderLayout.SOUTH);
			
				
			SpecificContainer containerSouth = new SpecificContainer(Frame.COLORESECONDARIOTEMATICO);
			this.add(containerSouth, BorderLayout.SOUTH);
			
			homePostVisualizzato = new Pulsanti("Home", Frame.COLOREPRIMARIOTEMATICO);
			containerSouth.add(homePostVisualizzato, BorderLayout.CENTER);
	
		}
		
		/*public void mostraBottoneSuperiore(boolean condition) {
			if(condition) {
				//iniziaSeguireButton.setVisible(false);
				impostaImmagineProfiloButton.setVisible(true);
			} else {
				//impostaImmagineProfiloButton.setVisible(false);
				iniziaSeguireButton.setVisible(true);
			}
		}*/
		
		public boolean settaCommenti(ArrayList<String> commenti) {
			if(commenti.size() == 0) 
				return false;
						 
			for(int i = 0 ; i < 10 && i < commenti.size() - this.getIndiceCommentoCorrente()/2; i = i + 2) {

				int indiceCorrente2 = i + getIndiceCommentoCorrente();
				((Pulsanti)ListaAreaTesto.get(i)).setText(commenti.get(indiceCorrente2));
				((Etichette)ListaAreaTesto.get(i + 1)).setText(commenti.get(indiceCorrente2 + 1));
			}
			return true;
		}
		
		public void settaPostVisualizzato(String iDpost, String path, String descrizionePost, int numeroLike, int numeroDislike, int numeroCommenti,ArrayList<String> commenti) {
			settaCommenti(commenti);
			idPost = iDpost;
			this.cambiaFoto(path);
			fotoPath = path;
			numeroMiPiace = numeroLike;
			numeroNonMiPiace = numeroDislike;
			numeroComm = numeroCommenti;
			containerSondaggio.setVisible(false);
			containerPost.setVisible(true);
		}
        public void settaSondaggioVisualizzato(String iDpost, String descrizionePost, String scelta1, String scelta2, String scelta3, String scelta4, int numeroLike, int numeroDislike, int numeroCommenti,ArrayList<String> commenti) {
            numeroMiPiace = numeroLike;
            numeroNonMiPiace = numeroDislike;
            numeroComm = numeroCommenti;
            settaCommenti(commenti);
            idPost = iDpost;
            
            aggiungiCommento = new AreaDiTesto(Frame.COLOREPRIMARIOTEMATICO, " nuova roba", 10, 20);
            JScrollPane scrollCommento = new JScrollPane(aggiungiCommento);
            containerSondaggio = new SpecificContainer();
            containerSondaggio.add(scrollCommento, BorderLayout.CENTER);
            
            SpecificContainer containerScelte = new SpecificContainer();
            containerScelte.setLayout(new GridLayout(4, 1));
            
            containerScelte.add( pulsantePrimaScelta = new Pulsanti(scelta1, Frame.COLOREPRIMARIOTEMATICO));
            containerScelte.add( pulsanteSecondaScelta = new Pulsanti(scelta2, Frame.COLOREPRIMARIOTEMATICO));
            containerScelte.add( pulsanteTerzaScelta = new Pulsanti(scelta3, Frame.COLOREPRIMARIOTEMATICO));
            containerScelte.add( pulsanteQuartaScelta = new Pulsanti(scelta4, Frame.COLOREPRIMARIOTEMATICO));
            
            containerSondaggio.add(containerScelte, BorderLayout.EAST);
            
            containerPost.setVisible(false);
            containerCenter.add(containerSondaggio, BorderLayout.CENTER);
            containerSondaggio.setVisible(true);

        }

		public ArrayList<JComponent> getListaAreaTesto() {
			return ListaAreaTesto;
		}

		public void setListaAreaTesto(ArrayList<JComponent> listaAreaTesto) {
			ListaAreaTesto = listaAreaTesto;
		}
		
		public JButton getHomePostVisualizzato() {
			return homePostVisualizzato;
		}

		public void setHomePostVisualizzato(JButton homePostVisualizzato) {
			this.homePostVisualizzato = homePostVisualizzato;
		}

		public JTextArea getAreaDescrizione() {
			return areaDescrizione;
		}

		public void setAreaDescrizione(JTextArea areaDescrizione) {
			this.areaDescrizione = areaDescrizione;
		}

		public SpecificContainer getContainerNorth() {
			return containerNorth;
		}


		public AreaDiTesto getAggiungiCommento() {
			return aggiungiCommento;
		}


		public void setAggiungiCommento(AreaDiTesto aggiungiCommento) {
			this.aggiungiCommento = aggiungiCommento;
		}
		
		public JButton getAggiungiCommentoButton() {
			return areaCommenti.getAggiungiCommento();
		}
		
		public JButton getAggiungiLikeButton() {
			return areaCommenti.getAggiungiLike();
		}

		public JButton getAggiungiDislikeButton() {
			return areaCommenti.getAggiungiDislike();
		}

		public String getIdPost() {
			return idPost;
		}

		public void setIdPost(String idPost) {
			this.idPost = idPost;
		}

		public JButton getImpostaImmagineProfiloButton() {
			return impostaImmagineProfiloButton;
		}
		
		public void setImpostaImmagineProfiloButton(Pulsanti impostaImmagineProfiloButton) {
			this.impostaImmagineProfiloButton = impostaImmagineProfiloButton;
		}
		

		public Pulsanti getIniziaSeguireButton() {
			return iniziaSeguireButton;
		}


		public void setIniziaSeguireButton(Pulsanti iniziaSeguireButton) {
			this.iniziaSeguireButton = iniziaSeguireButton;
		}


		public String getFotoPath() {
			return fotoPath;
		}
		
		public void cambiaFoto(String fotoPath) {
			this.fotoVisualizzata.setIcon(new ImageIcon(fotoPath));
		}


		public String getMessaggioBottoneSuperioreFollow() {
			return messaggioBottoneSuperioreFollow;
		}


		public void setMessaggioBottoneSuperioreFollow(String messaggioBottoneSuperioreFollow) {
			this.messaggioBottoneSuperioreFollow = messaggioBottoneSuperioreFollow;
		}


		public String getMessaggioBottoneSuperioreProfilo() {
			return messaggioBottoneSuperioreProfilo;
		}


		public void setMessaggioBottoneSuperioreProfilo(String messaggioBottoneSuperioreProfilo) {
			this.messaggioBottoneSuperioreProfilo = messaggioBottoneSuperioreProfilo;
		}
		
		public JButton getNextCommento() {
			return nextCommento;
		}

		public JButton getPrevCommento() {
			return prevCommento;
		}


		public int getIndiceCommentoCorrente() {
			return indiceCommentoCorrente;
		}


		public void incrementaIndiceCommento() {
			this.indiceCommentoCorrente = indiceCommentoCorrente + 2;

		}
		public void decrementaIndiceCommento() {
			this.indiceCommentoCorrente = indiceCommentoCorrente -2;
		}
		public void ripristinaIndiceCommento() {
			this.indiceCommentoCorrente = 0;
		}


		public int getNumeroCommentiTotali() {
			return numeroCommentiTotali;
		}


		public void setNumeroCommentiTotali(int numeroCommentiTotali) {
			this.numeroCommentiTotali = numeroCommentiTotali;
		}
}
