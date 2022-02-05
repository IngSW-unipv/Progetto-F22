package PanelsPackage.panels.elements;
import javax.swing.*;
import java.awt.*;
public class AddPostButton extends JButton{
		public AddPostButton(String name, Color colore) {
			this.setForeground(colore);
			this.setLabel(name);
			this.setVisible(true);
		}
}
