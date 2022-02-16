package panelspackage.panels.elements;
import javax.swing.JTextArea;
import java.awt.Color;
public class AreaDiTesto extends JTextArea {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AreaDiTesto(Color colore, String stringa) {
		this.setText(stringa);
		this.setBackground(colore);
		this.setVisible(true);
	}
	
	public AreaDiTesto(Color colore, String stringa, int i) {
		this.setText(stringa);
		this.setBackground(colore);
		this.setVisible(true);
	}
	
}
