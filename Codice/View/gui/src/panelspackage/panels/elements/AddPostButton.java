package panelspackage.panels.elements;
import javax.swing.JButton;
import java.awt.Color;
public class AddPostButton extends JButton{
	
		public AddPostButton(String name, Color colore) {
			
			this.setForeground(colore);
			this.setLabel(name);
			this.setVisible(true);
		}
}
