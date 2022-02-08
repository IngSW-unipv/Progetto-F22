package panelspackage.panels.elements;
import javax.swing.JTextArea;
import java.awt.Color;
public class AreaDiTesto extends JTextArea {
	
	public AreaDiTesto(Color colore, String stringa) {
		this.setText(stringa);
		this.setBackground(colore);
		this.setVisible(true);
	}
}
