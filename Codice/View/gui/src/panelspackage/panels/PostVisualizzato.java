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
		private JTextArea areaDescrizione;
		private JButton homePostVisualizzato;
		private SpecificContainer containerNorth;
		private String fotoPath =  "immagini/kaguya.jpeg";
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

			Etichette etichetta = new Etichette("Post", ARANCIONE);
			containerNorth.add(etichetta, BorderLayout.WEST);
			
			SpecificContainer containerCenter = new SpecificContainer(ARANCIONE);
			this.add(containerCenter, BorderLayout.CENTER);

			
			//POST
			
			SpecificContainer containerPost = new SpecificContainer();
			containerCenter.add(containerPost, BorderLayout.CENTER);
			
			LabeledIcon post = new LabeledIcon(fotoPath);
			containerPost.add(post, BorderLayout.CENTER);

			AreaCommenti areaCommenti =  new AreaCommenti();
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
			
			GrigliaDiElementi Dati =  new GrigliaDiElementi(ListaAreaTesto,5,1, ListaAreaTesto.size());
			containerCenter.add(Dati, BorderLayout.EAST);
			
			SpecificContainer containerSouth = new SpecificContainer(NERO);
			this.add(containerSouth, BorderLayout.SOUTH);
			
			homePostVisualizzato = new Pulsanti("Home", ARANCIONE);
			containerSouth.add(homePostVisualizzato, BorderLayout.CENTER);
		
			
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
		
}
