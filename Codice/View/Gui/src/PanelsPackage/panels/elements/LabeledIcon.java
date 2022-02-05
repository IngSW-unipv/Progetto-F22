package PanelsPackage.panels.elements;
import javax.swing.*;
import java.awt.*;
public class LabeledIcon extends JLabel {
	
	public LabeledIcon(String path) {
	ImageIcon icona = new ImageIcon(path);
	this.setIcon(icona);
	this.setVisible(true);
	}	
}
