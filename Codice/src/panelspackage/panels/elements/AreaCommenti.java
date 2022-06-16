package panelspackage.panels.elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AreaCommenti extends Container {
	
	JTextArea areaDescrizione = new JTextArea("");
	JButton aggiungiLike, aggiungiDislike,aggiungiCommento;
	JLabel numeroLike, numeroDislike, numeroCommenti;
	
	public AreaCommenti() {
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		areaDescrizione.setPreferredSize(new Dimension(400, 130));
		areaDescrizione.setEditable(false);
		areaDescrizione.setLineWrap(true);
		JScrollPane scrollAreaDescrizione = new JScrollPane(areaDescrizione, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		numeroLike = new JLabel("N.like");
		numeroLike.setForeground(Color.white);
		numeroDislike = new JLabel("N.dislike");
		numeroDislike.setForeground(Color.white);
		numeroCommenti = new JLabel("N.Commenti");
		numeroCommenti.setForeground(Color.white);
		aggiungiLike = new JButton("Aggiungi Like");
		aggiungiDislike = new JButton("Aggiungi dislike");
		aggiungiCommento = new JButton("Pubblica Commento");
	
		SpecificContainer containerBottoniPost = new SpecificContainer();
		SpecificContainer containerLikeDislikeComm = new SpecificContainer();
	
		containerLikeDislikeComm.setLayout(new GridLayout(2, 6));
		containerLikeDislikeComm.add(numeroLike);
		containerLikeDislikeComm.add(numeroDislike);
		containerLikeDislikeComm.add(numeroCommenti);
		containerLikeDislikeComm.add(aggiungiLike);
		containerLikeDislikeComm.add(aggiungiDislike);
	
		containerLikeDislikeComm.add(aggiungiCommento);
		add(containerLikeDislikeComm, BorderLayout.NORTH);
		add(scrollAreaDescrizione, BorderLayout.CENTER);
		add(containerBottoniPost, BorderLayout.SOUTH);	
	}

	public JTextArea getAreaDescrizione() {
		return areaDescrizione;
	}

	public JButton getAggiungiLike() {
		return aggiungiLike;
	}

	public JButton getAggiungiDislike() {
		return aggiungiDislike;
	}

	public JButton getAggiungiCommento() {
		return aggiungiCommento;
	}

	public JLabel getNumeroLike() {
		return numeroLike;
	}

	public void setNumeroLike(JLabel numeroLike) {
		this.numeroLike = numeroLike;
	}

	public JLabel getNumeroDislike() {
		return numeroDislike;
	}

	public void setNumeroDislike(JLabel numeroDislike) {
		this.numeroDislike = numeroDislike;
	}

	public JLabel getNumeroCommenti() {
		return numeroCommenti;
	}

	public void setNumeroCommenti(JLabel numeroCommenti) {
		this.numeroCommenti = numeroCommenti;
	}
	
}
