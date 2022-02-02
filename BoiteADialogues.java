package aissa;

import javax.swing.JOptionPane;

// import javax.swing.JPanel;


public class BoiteADialogues {
	public static void main(java.lang.String[] args) {
		
		JOptionPane.showMessageDialog(null, "Salve\n a\n tutti!\n");
		JOptionPane.showMessageDialog(null, "Si ciao! Come stai?");
		JOptionPane.showMessageDialog(null, "Bene e te?");
		JOptionPane.showMessageDialog(null, " Bene anch'io, grazie.");
		java.lang.String nome = JOptionPane.showInputDialog(" Ma tu come ti chiami?");
		// Usare String.format
		java.lang.String messaggio = java.lang.String.format( "Bella nome %s", nome);
		JOptionPane.showMessageDialog(null, messaggio);
		java.lang.String nome1 = JOptionPane.showInputDialog(" Grazie mille. E tu come ti chiami?");
		java.lang.String messaggio1 = java.lang.String.format("Piacere %s", nome1);
		JOptionPane.showMessageDialog(null, messaggio1);
		java.lang.String citta = JOptionPane.showInputDialog(" Dove abiti Aicha");
		java.lang.String messaggio3 = java.lang.String.format(" Ah %s bella citta hein", citta);
		JOptionPane.showMessageDialog(null, messaggio3);
		JOptionPane.showInputDialog(" Possiamo dirlo. E tu?");
		JOptionPane.showMessageDialog(null," il mio treno sta arrivando quindi ciao a domani inchaallah.");
		JOptionPane.showMessageDialog(null, " Si arrivederci. Stato un piacere.");
		
		// On peut aussi utiliser Integer avec la classe parseInt
		
		
		
	}


}
