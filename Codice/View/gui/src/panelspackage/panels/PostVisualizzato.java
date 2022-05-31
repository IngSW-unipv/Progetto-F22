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
		Color ARANCIONE = new Color(255, 125, 0);
		Color NERO = new Color(0, 0, 0);
		int indiceCommentoCorrente = 0;
		int numeroCommentiTotali = 5;
		private String messaggioBottoneSuperioreFollow = "Inizia a seguire";
		private String messaggioBottoneSuperioreProfilo = "Imposta come immagine profilo";
		private JTextArea areaDescrizione;
		private AreaCommenti areaCommenti;
		private AreaDiTesto aggiungiCommento;
		private JButton homePostVisualizzato,nextCommento, prevCommento;
		private Pulsanti impostaImmagineProfiloButton, iniziaSeguireButton;
		private SpecificContainer containerNorth;
		private String fotoPath =  "C:\\Users\\franc\\OneDrive\\Immagini\\imgbin-rias-.jpg", idPost = "405";
		private LabeledIcon post;
		private ArrayList<String> postCommentiConUtenti = new ArrayList<String>();
		
		int numeroMiPiace = 10, numeroNonMiPiace = 20, numeroComm = 3;
		
		public PostVisualizzato() {
			avvio();
			initComponents();
			}

		
		public void avvio() {
			this.setOpaque(true);
			this.setVisible(true);
			this.setLayout(new BorderLayout());
			this.setBackground(NERO);
		}
		
		public void initComponents() {
			
			SpecificContainer containerNorth = new SpecificContainer();
			this.add(containerNorth, BorderLayout.NORTH);
			
			impostaImmagineProfiloButton = new Pulsanti(messaggioBottoneSuperioreProfilo, Frame.COLOREPRIMARIOTEMATICO);
			impostaImmagineProfiloButton.setVisible(true);
			containerNorth.add(impostaImmagineProfiloButton);
			
			
			/*iniziaSeguireButton = new Pulsanti(messaggioBottoneSuperioreFollow, Frame.COLOREPRIMARIOTEMATICO);
			iniziaSeguireButton.setVisible(false);
			containerNorth.add(iniziaSeguireButton);*/

			SpecificContainer containerCenter = new SpecificContainer(ARANCIONE);
			this.add(containerCenter, BorderLayout.CENTER);

			
			//POST
			
			SpecificContainer containerPost = new SpecificContainer();
			containerCenter.add(containerPost, BorderLayout.CENTER);
			
			LabeledIcon post = new LabeledIcon(fotoPath);
			containerPost.add(post, BorderLayout.CENTER);

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
			
			GrigliaDiElementi dati =  new GrigliaDiElementi(ListaAreaTesto,6,2, ListaAreaTesto.size());
			
			ScrollPane scrollCommento = new ScrollPane();
			
			aggiungiCommento = new AreaDiTesto(Frame.COLOREPRIMARIOTEMATICO, "prova");
			aggiungiCommento.setRows(10);
			
			containerEast.add(dati, BorderLayout.CENTER);
			containerEast.add(aggiungiCommento, BorderLayout.SOUTH);
			
				
			SpecificContainer containerSouth = new SpecificContainer(NERO);
			this.add(containerSouth, BorderLayout.SOUTH);
			
			homePostVisualizzato = new Pulsanti("Home", ARANCIONE);
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
		
		public void settaCommenti(ArrayList<String> commenti) {
			this.setNumeroCommentiTotali(commenti.size()/2);
			
			for(int i = 0 ; i<  10 ; i = i + 2) {
				System.out.println("indice corrente" + i );
				System.out.println("indice usato" + ( i + getIndiceCommentoCorrente()) );

				((Pulsanti)ListaAreaTesto.get(i)).setText(commenti.get(i + getIndiceCommentoCorrente()));
				((Etichette)ListaAreaTesto.get(i + 1)).setText(commenti.get(i + 1 +getIndiceCommentoCorrente()));
			}
		}
		
		public void settaPostVisualizzato(String path, String descrizionePost, int numeroLike, int numeroDislike, int numeroCommenti) {
			fotoPath = path;
			numeroMiPiace = numeroLike;
			numeroNonMiPiace = numeroDislike;
			numeroComm = numeroCommenti;
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

		public void setFotoPath(String fotoPath) {
			this.fotoPath = fotoPath;
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
			this.indiceCommentoCorrente = indiceCommentoCorrente + -2;
		}


		public int getNumeroCommentiTotali() {
			return numeroCommentiTotali;
		}


		public void setNumeroCommentiTotali(int numeroCommentiTotali) {
			this.numeroCommentiTotali = numeroCommentiTotali;
		}
}
