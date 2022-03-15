package panelspackage.panels;
	import javax.swing.*;
	import java.awt.*;
	import java.util.ArrayList;
	import panelspackage.panels.elements.GrigliaDiElementi;
import panelspackage.panels.elements.LabeledIcon;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.AreaDiTesto;
	import panelspackage.panels.elements.Etichette;
	import panelspackage.panels.elements.SpecificContainer;
	
public class PostVisualizzato extends JPanel{

	
		ArrayList<JComponent> ListaAreaTesto = new ArrayList<JComponent>();
		ArrayList<String> dati = new ArrayList<String>();
		Color ARANCIONE = new Color(255, 125, 0);
		Color NERO = new Color(0, 0, 0);
		int i;
		private JTextArea areaDescrizione;
		private JButton homePostVisualizzato;
		private SpecificContainer containerNorth;
		private String percorsoPost;
		public PostVisualizzato(String percorsoPost) {
			//String postImmagine, String postCommenti[], String utentiCommenti[], int numeroMiPiace, int numeroNonMipiace
			//da eliminare
			this.percorsoPost = percorsoPost;
			String postcommenti[];
			String utentiCommenti[];
			int numeroMiPiace = 10;
			int numeroNonMiPiace = 20;
			
			
			
			//commento
			this.setOpaque(true);
			this.setVisible(true);
			this.setLayout(new BorderLayout());
			this.setBackground(NERO);	
			
			SpecificContainer containerNorth = new SpecificContainer();
			this.add(containerNorth, BorderLayout.NORTH);

			Etichette etichetta = new Etichette("Post", ARANCIONE);
			containerNorth.add(etichetta, BorderLayout.WEST);
			
			SpecificContainer containerCenter = new SpecificContainer(ARANCIONE);
			this.add(containerCenter, BorderLayout.CENTER);

			
			//POST
			
			SpecificContainer containerPost = new SpecificContainer();
			containerCenter.add(containerPost, BorderLayout.CENTER);
			
			LabeledIcon post = new LabeledIcon(percorsoPost);
			containerPost.add(post, BorderLayout.CENTER);
			SpecificContainer containerCosePost = new SpecificContainer();
			JTextArea areaDescrizione = new JTextArea("DESCRIZIONE POST\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.");
			areaDescrizione.setPreferredSize(new Dimension(400, 130));
			areaDescrizione.setEditable(false);
			areaDescrizione.setLineWrap(true);
			JScrollPane scrollAreaDescrizione = new JScrollPane(areaDescrizione, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			JLabel numeroLike = new JLabel("N.like");
			numeroLike.setForeground(Color.white);
			JLabel numeroDislike = new JLabel("N.dislike");
			numeroDislike.setForeground(Color.white);
			JLabel numeroCommenti = new JLabel("N.Commenti");
			numeroCommenti.setForeground(Color.white);
			JButton aggiungiLike = new JButton("+ Like");
			JButton aggiungiDislike = new JButton("- Like");

			JButton  aggiungiCommento = new JButton("+ Commento");
			
			SpecificContainer containerBottoniPost = new SpecificContainer();
			SpecificContainer containerLikeDislikeComm = new SpecificContainer();
			
			containerLikeDislikeComm.setLayout(new GridLayout(2, 6));
			containerLikeDislikeComm.add(numeroLike);
			containerLikeDislikeComm.add(numeroDislike);
			containerLikeDislikeComm.add(numeroCommenti);
			containerLikeDislikeComm.add(aggiungiLike);
			containerLikeDislikeComm.add(aggiungiDislike);
			
			containerLikeDislikeComm.add(aggiungiCommento);
			containerCosePost.add(containerLikeDislikeComm, BorderLayout.NORTH);
			containerCosePost.add(scrollAreaDescrizione, BorderLayout.CENTER);
			containerCosePost.add(containerBottoniPost, BorderLayout.SOUTH);
			containerPost.add(containerCosePost, BorderLayout.SOUTH);		
			
			
			//COMMENTI

			/*for( i = 0; i <  postCommenti.length; i++) {
				Etichette area = new Etichette(utentiCommenti[i] +": " + postCommenti[i], COLOREPRIMARIOTEMATICO);
				ListaAreaTesto.add(area);
			}*/
			
			GrigliaDiElementi Dati =  new GrigliaDiElementi(ListaAreaTesto,5,1, ListaAreaTesto.size());
			containerCenter.add(Dati, BorderLayout.EAST);
			
			SpecificContainer containerSouth = new SpecificContainer(NERO);
			this.add(containerSouth, BorderLayout.SOUTH);
			
			homePostVisualizzato = new Pulsanti("Home", ARANCIONE);
			containerSouth.add(homePostVisualizzato, BorderLayout.CENTER);
		}

		public ArrayList<JComponent> getListaAreaTesto() {
			return ListaAreaTesto;
		}

		public void setListaAreaTesto(ArrayList<JComponent> listaAreaTesto) {
			ListaAreaTesto = listaAreaTesto;
		}

		
		
		
		//GETTER E SETTER PULSANTI
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
