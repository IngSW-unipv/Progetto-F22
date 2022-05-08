package panelspackage.panels;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;




@SuppressWarnings("serial")
public class AreaChatGui extends JFrame{
	
	private JButton profilo;
	private JButton chiama;
	private JPanel areaChat;
	private JTextArea messaggi;
	private JTextField scriviMessaggio;
	private JButton invia;
	private JButton esci;
	
	  public AreaChatGui() {
			esci = new JButton();
			esci.setFont(new Font("Arial", 1, 12));
			esci.setBackground(Color.red);
			esci.setIcon(new ImageIcon("C:\\Users\\aissa\\OneDrive\\Immagini\\torna.png"));
			esci.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ChatGui c = new ChatGui();
					c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					c.setVisible(true);
					c.setSize(500, 500);
					c.setLayout(new FlowLayout(FlowLayout.LEADING));
					
				}
			});
			this.add(esci);
			
			profilo = new JButton("Profilo");
			profilo.setFont(new Font("Arial", 1, 12));
			profilo.setBackground(new Color(204, 255, 255));
			profilo.setIcon(new ImageIcon("C:\\Users\\aissa\\OneDrive\\Immagini\\profiler.png"));
			profilo.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
			    }
			});
			this.add(profilo);
			
			chiama = new JButton("Chiama");
			chiama.setFont(new Font("Arial", 1, 12));
			chiama.setIcon(new ImageIcon("C:\\Users\\aissa\\OneDrive\\Immagini\\Appelico.png"));
			chiama.setBackground(new Color(255, 153, 255));
			
			this.add(chiama);
			
			areaChat = new JPanel();
			areaChat.setLayout(null);
			this.add(areaChat);
			
			
			messaggi = new JTextArea(20, 40);
			areaChat.add(messaggi);
			messaggi.setBackground(Color.pink);
			//messaggi.setLayout(new FlowLayout( FlowLayout.RIGHT));
			this.add(messaggi);
			
			scriviMessaggio = new JTextField(30);
			scriviMessaggio.setFont(new java.awt.Font("Arial", 1, 12)); 
			scriviMessaggio.setText("Scrivi messaggio");
			scriviMessaggio.setBackground(Color.LIGHT_GRAY);
			scriviMessaggio.addActionListener(new ActionListener() {
				
		        @Override
				public void actionPerformed(ActionEvent e) {
					String input = scriviMessaggio.getText();
					messaggi.setText(input);
					
				}
		  });
			
			this.add(scriviMessaggio);
			
			 //scriviMessaggio.setHorizontalAlignment(scriviMessaggio.LEADING);
		    //scriviMessaggio.setAlignmentX((float) 0.5);
			//scriviMessaggio.setAlignmentY((float) 0.5);
			//areaChat.add(scriviMessaggio);
			
			invia = new JButton("Invia");
			invia.setFont(new Font("Times New Roman", 1, 14));
			invia.setBackground(Color.cyan);
			invia.setBorderPainted(isBackgroundSet());
		    this.add(invia);
		    
		    invia.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				String test = scriviMessaggio.getText();
				if( !(test.equals("Scrivi messaggio"))) {
				System.out.println(" Il pulsante risponde");
				messaggi.setText(test);
				}
			    
					
				}
			});
		    
		    //areaChat.add(invia);
		    
		   // scroll = new JScrollPane();
		    
		    //GridBagConstraints grid = new GridBagConstraints();
		    //grid.gridwidth = GridBagConstraints.REMAINDER;
		    //grid.fill = GridBagConstraints.HORIZONTAL;
		    //add(scriviMessaggio);
		    //grid.fill = GridBagConstraints.BOTH;
			//grid.weightx = 1.0;
			//grid.weighty = 1.0;
			//add(scroll,grid);
		}
		
		public static void main(String[] args) {
			AreaChatGui chat = new AreaChatGui();
			chat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			chat.setVisible(true);
			chat.setSize(500, 500);
			chat.setLayout(new FlowLayout( FlowLayout.LEADING));
			//chat.pack();
		}

		public JPanel getAreaChat() {
			return areaChat;
		}

		public void setAreaChat(JPanel areaChat) {
			this.areaChat = areaChat;
		}

		public JTextArea getMessaggi() {
			return messaggi;
		}

		public void setMessaggi(JTextArea messaggi) {
			this.messaggi = messaggi;
		}

		public JTextField getScriviMessaggio() {
			return scriviMessaggio;
		}

		public void setScriviMessaggio(JTextField scriviMessaggio) {
			this.scriviMessaggio = scriviMessaggio;
		}

		public JButton getInvia() {
			return invia;
		}

		public void setInvia(JButton invia) {
			this.invia = invia;
		}

	}



