package panelspackage.panels.elements;
import javax.swing.*;

public class LabeledIcon extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LabeledIcon(String path) {

	ImageIcon icona = new ImageIcon(path);
	this.setIcon(icona);
	this.setVisible(true);
	
	}	
}
