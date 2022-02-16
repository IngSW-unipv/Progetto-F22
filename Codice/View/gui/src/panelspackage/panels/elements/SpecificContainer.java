package panelspackage.panels.elements;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Color;

public class SpecificContainer extends Container {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SpecificContainer(Color colorePrimario, Color coloreSecondario) {
		this.setLayout(new BorderLayout());
		this.setBackground(colorePrimario);
		this.setForeground(coloreSecondario);
		this.setVisible(true);
	}
	
	public SpecificContainer(Color colorePrimario) {
		this.setLayout(new BorderLayout());
		this.setBackground(colorePrimario);
		this.setVisible(true);
	}
	
	public SpecificContainer() {
		this.setLayout(new BorderLayout());
		this.setVisible(true);	
	}
}