package panelspackage.panels.elements;
import javax.swing.JButton;
import java.awt.Color;
public class AddPostButton extends JButton{
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@SuppressWarnings("deprecation")
		public AddPostButton(String name, Color colore) {
			
			this.setForeground(colore);
			this.setLabel(name);
			this.setVisible(true);
			
		}
}
