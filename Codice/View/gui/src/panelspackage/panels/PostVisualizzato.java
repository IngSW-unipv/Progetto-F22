package panelspackage.panels;
	import javax.swing.*;
	import java.awt.*;
	import java.util.ArrayList;
	import panelspackage.panels.elements.GrigliaDiElementi;
import panelspackage.panels.elements.LabeledIcon;
import panelspackage.panels.elements.Pulsanti;
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
		int i;
		private String messaggioBottoneSuperioreFollow = "Inizia a seguire";
		private String messaggioBottoneSuperioreProfilo = "Imposta come immagine profilo";
		private JTextArea areaDescrizione;
		private AreaCommenti areaCommenti;
		private AreaDiTesto aggiungiCommento;
		private JButton homePostVisualizzato;
		private Pulsanti impostaImmagineProfiloButton, iniziaSeguireButton;
		private SpecificContainer containerNorth;
		private String fotoPath =  "immagini/kaguya.jpeg";
		private String idPost = "421";
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
			postCommentiConUtenti.add("ciccioGamer");
			postCommentiConUtenti.add("bello come un cornetto in faccia");
			
			postCommentiConUtenti.add("incelHero1978");
			postCommentiConUtenti.add("waifu");
			
			postCommentiConUtenti.add("kebabSniper");
			postCommentiConUtenti.add("aviatore");
			
			for( i = 0; i <  this.postCommentiConUtenti.size() - 1; i = i +2) {

				Etichette area = new Etichette(postCommentiConUtenti.get(i) +": " + postCommentiConUtenti.get(i + 1), Frame.COLOREPRIMARIOTEMATICO);
				ListaAreaTesto.add(area);
			}
			
			SpecificContainer containerEast = new SpecificContainer();
			this.add(containerEast, BorderLayout.EAST);
			
			GrigliaDiElementi dati =  new GrigliaDiElementi(ListaAreaTesto,5,1, ListaAreaTesto.size());
			
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
		
		
}
