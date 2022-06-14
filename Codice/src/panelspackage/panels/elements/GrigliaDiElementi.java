package panelspackage.panels.elements;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JComponent;

public class GrigliaDiElementi extends Container {
	

	int i;
	
	public GrigliaDiElementi(ArrayList<JComponent> listaComponenti, int row, int column, int numeroComponenti) {	
		this.setLayout(new GridLayout(row, column));
		
		for(i = 0; i < numeroComponenti; i++) {
			this.add(listaComponenti.get(i));
		}
	}
	
	
	public GrigliaDiElementi(HashMap<String, JComponent> listaComponenti, int row, int column, int numeroComponenti) {	
		this.setLayout(new GridLayout(row, column));
		
		listaComponenti.forEach((key, value) -> this.add(value));
	}
}
