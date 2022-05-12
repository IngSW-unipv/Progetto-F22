package panelspackage.panels;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class DiscussioniFrame extends JFrame implements ActionListener{

	private JPanel panello;
	private JButton chiamate;
	//private JLabel discussioni;
	private JComboBox<String> discussioni ;
	
	
	public DiscussioniFrame() {
		panello = new JPanel();
		panello.setLayout(null);
		this.add(panello);
		
		//discussioni = new JLabel("Discussioni");
		//panello.add(discussioni);
		//this.add(discussioni);
		
		discussioni = new JComboBox<>();
		panello.add(discussioni);
		discussioni.addItem("Discussioni");
		discussioni.addItem("Chat di gruppo");
		discussioni.addItem("Chat personali");
		//discussioni.setModel(new DefaultComboBoxModel<>(new String[] {"Chat personali", "Chat di gruppo", "Discussioni"})); 
		discussioni.setFont(new Font("Arial", 1, 14));
		discussioni.setBounds(139, 104, 169, 30);
	    discussioni.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					System.out.println(discussioni.getSelectedItem().toString() + " è selezionato");
				}
				
			}
	    	
	    });
	    this.add(discussioni);
	    
	    chiamate = new JButton("Chiamate");
	    panello.add(chiamate);
	    this.add(chiamate);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	
	public static void main(String[] args) {
		
		DiscussioniFrame chat = new DiscussioniFrame();
		chat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chat.setVisible(true);
		chat.setSize(500, 500);
		chat.setLayout(new FlowLayout(FlowLayout.LEADING));
	}

}

	

