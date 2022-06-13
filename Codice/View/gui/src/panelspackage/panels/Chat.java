package panelspackage.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import packageframe.Frame;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.SpecificContainer;

@SuppressWarnings("serial")
public class Chat extends JPanel {

    private Pulsanti tornaHome, primaChatGruppo, secondaChatGruppo, terzaChatGruppo, quartaChatGruppo, quintaChatGruppo,
                     primaChatPrivata, secondaChatPrivata, terzaChatPrivata, quartaChatPrivata, quintaChatPrivata,
                     messaggioPrecedente, prossimoMessaggio;
    private ArrayList<JComponent> listaComponenti = new ArrayList<JComponent>();
    //private JComboBox<String> discussioni;
    private SpecificContainer containerCenter, containerNorth,containerSouth, containerGrigliaSouth;
    
    private int indiceMessaggioCorrente  = 0;

        public Chat() {
            avvio();
            initComponents();
    }
        
        public void avvio() {
        this.setOpaque(true);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.setBackground(Frame.COLOREPRIMARIOTEMATICO);   
    }
    
    public void initComponents() {
        
        containerNorth = new SpecificContainer();
        containerNorth.setLayout(new GridLayout(2, 1));
        this.add(containerNorth, BorderLayout.NORTH);
        
        
        
        containerCenter = new SpecificContainer(Color.CYAN);
        containerCenter.setLayout(new GridLayout(10, 2));
        listaComponenti.add(new Etichette("ChatDiGruppo1",Frame.COLORESECONDARIOTEMATICO));
        listaComponenti.add(primaChatGruppo = new Pulsanti("Apri", Frame.COLOREPRIMARIOTEMATICO));
        listaComponenti.add(new Etichette("ChatPersonale1", Frame.COLORESECONDARIOTEMATICO));
        listaComponenti.add(primaChatPrivata = new  Pulsanti("Apri", Frame.COLOREPRIMARIOTEMATICO));
        listaComponenti.add(new Etichette("ChatDiGruppo2", Frame.COLORESECONDARIOTEMATICO));
        listaComponenti.add(secondaChatGruppo = new  Pulsanti("Apri", Frame.COLOREPRIMARIOTEMATICO));
        listaComponenti.add(new Etichette("ChatPersonale2", Frame.COLORESECONDARIOTEMATICO));
        listaComponenti.add(secondaChatPrivata = new  Pulsanti("Apri", Frame.COLOREPRIMARIOTEMATICO));
        listaComponenti.add(new Etichette("ChatDiGruppo3", Frame.COLORESECONDARIOTEMATICO));
        listaComponenti.add(terzaChatGruppo = new  Pulsanti("Apri", Frame.COLOREPRIMARIOTEMATICO));
        listaComponenti.add(new Etichette("ChatPersonale3", Frame.COLORESECONDARIOTEMATICO));
        listaComponenti.add(terzaChatPrivata = new  Pulsanti("Apri", Frame.COLOREPRIMARIOTEMATICO));
        listaComponenti.add(new Etichette("ChatDiGruppo4", Frame.COLORESECONDARIOTEMATICO));
        listaComponenti.add(quartaChatGruppo = new  Pulsanti("Apri", Frame.COLOREPRIMARIOTEMATICO));
        listaComponenti.add(new Etichette("ChatPersonale4", Frame.COLORESECONDARIOTEMATICO));
        listaComponenti.add(quartaChatPrivata = new  Pulsanti("Apri", Frame.COLOREPRIMARIOTEMATICO));
        listaComponenti.add(new Etichette("ChatDiGruppo5", Frame.COLORESECONDARIOTEMATICO));
        listaComponenti.add(quintaChatGruppo = new  Pulsanti("Apri", Frame.COLOREPRIMARIOTEMATICO));
        listaComponenti.add(new Etichette("ChatPersonale5", Frame.COLORESECONDARIOTEMATICO));
        listaComponenti.add(quintaChatPrivata = new  Pulsanti("Apri", Frame.COLOREPRIMARIOTEMATICO));
        
        for(int i = 0; i < listaComponenti.size(); i++) {
            containerCenter.add(listaComponenti.get(i));
        }
        
        this.add(containerCenter, BorderLayout.CENTER); 
        
        
        containerSouth = new SpecificContainer();
        this.add(containerSouth, BorderLayout.SOUTH);
        tornaHome = new Pulsanti("Torna alla home", Frame.COLOREPRIMARIOTEMATICO);
        containerSouth.setLayout(new GridLayout(2, 1));
        containerSouth.add(tornaHome);
        

        containerGrigliaSouth = new SpecificContainer(Frame.COLORESECONDARIOTEMATICO);
        containerSouth.add(containerGrigliaSouth);
		containerGrigliaSouth.setLayout(new GridLayout(1,2));
		containerGrigliaSouth.add(messaggioPrecedente = new Pulsanti("<-", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.WEST);
		containerGrigliaSouth.add(prossimoMessaggio = new Pulsanti("->", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.EAST);

     
    }
        
        public void settaSchermataChat(ArrayList<String> gruppi) {
            for(int i=0; i < gruppi.size()/2 && i < 10; i++) {
                ((Etichette) listaComponenti.get(i*2)).setText(gruppi.get((i*2) +1));               
            }       
        }
        

        public Pulsanti getTornaHome() {
            return tornaHome;
        }

        public void setTornaHome(Pulsanti home) {
            this.tornaHome = home;
        }



        public SpecificContainer getContainerCenter() {
            return containerCenter;
        }

        public void setContainerCenter(SpecificContainer containerCenter) {
            this.containerCenter= containerCenter;
        }

        public SpecificContainer getContainerNorth() {
            return containerNorth;
        }

        public void setContainerNorth(SpecificContainer containerNorth) {
            this.containerNorth = containerNorth;
        }

        public SpecificContainer getContainerSouth() {
            return containerSouth;
        }

        public void setContainerSouth(SpecificContainer containerSouth) {
            this.containerSouth = containerSouth;
        }

        public Pulsanti getPrimaChatGruppo() {
            return primaChatGruppo;
        }

        public void setPrimaChatGruppo(Pulsanti primaChatGruppo) {
            this.primaChatGruppo = primaChatGruppo;
        }

        public Pulsanti getSecondaChatGruppo() {
            return secondaChatGruppo;
        }

        public void setSecondaChatGruppo(Pulsanti secondaChatGruppo) {
            this.secondaChatGruppo = secondaChatGruppo;
        }

        public Pulsanti getTerzaChatGruppo() {
            return terzaChatGruppo;
        }

        public void setTerzaChatGruppo(Pulsanti terzaChatGruppo) {
            this.terzaChatGruppo = terzaChatGruppo;
        }

        public Pulsanti getQuartaChatGruppo() {
            return quartaChatGruppo;
        }

        public void setQuartaChatGruppo(Pulsanti quartaChatGruppo) {
            this.quartaChatGruppo = quartaChatGruppo;
        }

        public Pulsanti getQuintaChatGruppo() {
            return quintaChatGruppo;
        }

        public void setQuintaChatGruppo(Pulsanti quintaChatGruppo) {
            this.quintaChatGruppo = quintaChatGruppo;
        }

        public Pulsanti getPrimaChatPrivata() {
            return primaChatPrivata;
        }

        public void setPrimaChatPrivata(Pulsanti primaChatPrivata) {
            this.primaChatPrivata = primaChatPrivata;
        }

        public Pulsanti getSecondaChatPrivata() {
            return secondaChatPrivata;
        }

        public void setSecondaChatPrivata(Pulsanti secondaChatPrivata) {
            this.secondaChatPrivata = secondaChatPrivata;
        }

        public Pulsanti getTerzaChatPrivata() {
            return terzaChatPrivata;
        }

        public void setTerzaChatPrivata(Pulsanti terzaChatPrivata) {
            this.terzaChatPrivata = terzaChatPrivata;
        }

        public Pulsanti getQuartaChatPrivata() {
            return quartaChatPrivata;
        }

        public void setQuartaChatPrivata(Pulsanti quartaChatPrivata) {
            this.quartaChatPrivata = quartaChatPrivata;
        }

        public Pulsanti getQuintaChatPrivata() {
            return quintaChatPrivata;
        }

        public void setQuintaChatPrivata(Pulsanti quintaChatPrivata) {
            this.quintaChatPrivata = quintaChatPrivata;
        }
        public int getIndiceMessaggioCorrente() {
			return indiceMessaggioCorrente;
		}

		public void decrementaIndiceMessaggioCorrente() {
			this.indiceMessaggioCorrente = this.indiceMessaggioCorrente - 2;
		}
		
		public void incrementaIndiceMessaggioCorrente() {
			this.indiceMessaggioCorrente = this.indiceMessaggioCorrente + 2;

		}

		public Pulsanti getMessaggioPrecedente() {
			return messaggioPrecedente;
		}

		public void setMessaggioPrecedente(Pulsanti messaggioPrecedente) {
			this.messaggioPrecedente = messaggioPrecedente;
		}

		public Pulsanti getProssimoMessaggio() {
			return prossimoMessaggio;
		}

		public void setProssimoMessaggio(Pulsanti prossimoMessaggio) {
			this.prossimoMessaggio = prossimoMessaggio;
		}

        
}   