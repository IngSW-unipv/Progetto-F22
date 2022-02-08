package panelspackage.panels.elements;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
public class LabeledIcon extends JLabel {
	
	public LabeledIcon(String path) {

	ImageIcon icona = new ImageIcon(path);
	this.setIcon(icona);
	this.setVisible(true);
	
	}	
}
