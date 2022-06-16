package panelspackage.panels.elements;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.SwingConstants;
public class PannelloNotifiche extends JPanel {
	private Color NERO = new Color(0, 0, 0);
	private Font fontTitolo;
	private HashMap<String, JButton> mappaPulsanti  = new HashMap<String, JButton>();
	private JLabel titoloNotifiche;
	private JButton eliminaNotifiche;
	private JButton homeNotifiche;
	
	public PannelloNotifiche() {
		
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(NERO);
		
		fontTitolo = new Font("Arial", Font.BOLD | Font.ITALIC, 30);
		eliminaNotifiche = new JButton("Elimina notifiche");
		
		homeNotifiche = new JButton("Torna alla home");
		
		titoloNotifiche = new JLabel("NOTIFICHE", SwingConstants.CENTER);
		titoloNotifiche.setFont(fontTitolo);
		titoloNotifiche.setForeground(Color.WHITE);
		
		SpecificContainer containerNorth = new SpecificContainer();
		SpecificContainer containerSouth = new SpecificContainer();
		SpecificContainer containerPulsanti = new SpecificContainer();
		
		this.add(containerNorth, BorderLayout.NORTH);
		containerNorth.add(titoloNotifiche);
		this.add(containerSouth, BorderLayout.SOUTH);
		containerSouth.add(containerPulsanti);
		containerPulsanti.setLayout(new GridLayout(2, 1));
		containerPulsanti.add(eliminaNotifiche);
		containerPulsanti.add(homeNotifiche);
		
		mappaPulsanti.put("eliminaNotifiche", eliminaNotifiche);
		mappaPulsanti.put("homeNotifiche", homeNotifiche);
		
	}

	public JButton getEliminaNotifiche() {
		return (JButton) mappaPulsanti.get("eliminaProfilo");
	}
	
	public JButton getHomeNotifiche() {
		return (JButton) mappaPulsanti.get("homeNotifiche");
	}

}
