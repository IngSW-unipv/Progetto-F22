package panelspackage.panels.elements;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.SwingConstants;
public class PannelloNotifiche extends JPanel {
	private Color ARANCIONE = new Color(255, 125, 0);
	private Color NERO = new Color(0, 0, 0);
	private Font fontTitolo;
	int i;
	//public Pulsanti[] listaPulsanti;
	private ArrayList<Pulsanti> listaPulsanti  = new ArrayList<Pulsanti>();
	private JLabel titoloNotifiche;
	private JButton eliminaNotifiche;
	
	public PannelloNotifiche(/*ArrayList<String> contenuto, ArrayList<String> tipo*/ ) {
		
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(NERO);
		
		fontTitolo = new Font("Arial", Font.BOLD | Font.ITALIC, 30);
		eliminaNotifiche = new JButton("Elimina notifiche");
		
		titoloNotifiche = new JLabel("NOTIFICHE", SwingConstants.CENTER);
		titoloNotifiche.setFont(fontTitolo);
		titoloNotifiche.setForeground(Color.WHITE);
		
		SpecificContainer containerNorth = new SpecificContainer();
		SpecificContainer containerSouth = new SpecificContainer();
		this.add(containerNorth, BorderLayout.NORTH);
		containerNorth.add(titoloNotifiche);
		this.add(containerSouth, BorderLayout.SOUTH);
		containerSouth.add(eliminaNotifiche);
		/*containerCenter.setLayout(new GridLayout(contenuto.size(),1));
		
		for (i = 0; i < 5; i ++) {
			listaPulsanti.add(new Pulsanti(contenuto.get(i), ARANCIONE));
			containerCenter.add(listaPulsanti.get(i));
		}*/
	}

	public ArrayList<Pulsanti> getListaPulsanti() {
		return listaPulsanti;
	}

	public void setListaPulsanti(ArrayList<Pulsanti> listaPulsanti) {
		this.listaPulsanti = listaPulsanti;
	}

}
