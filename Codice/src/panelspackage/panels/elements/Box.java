package panelspackage.panels.elements;
import javax.swing.*;

import java.awt.Color;

public class Box extends JComboBox {
	int i;
	public Box(String[] strings, Color colore) {
		for (i = 0; i < strings.length; i++) {
			this.addItem(strings[i]);
		}
		this.setBackground(colore);
	}

}
