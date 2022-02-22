package chat;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

import javax.imageio.ImageIO;
import javax.swing.*;

public class UtilityChat implements IUtilityChat{

	//Metodo che converte Date in sql Date
		public Date convertiInSqlData(java.util.Date d) {
			java.sql.Date dataSql = new java.sql.Date(d.getTime());
			return dataSql;
		}
		
		//Metodo che converte LocalTime in sql Time
	    public Time convertiInSqlTime(LocalTime t) {
	    	Time time = Time.valueOf(t);
	    	return time;
	    }

		@Override
		public void visualizzaMultimedia() {
	        BufferedImage img;
			img = ImageIO.read(new File("f://images.jpg"));
			ImageIcon icon=new ImageIcon(img);
	        JFrame frame=new JFrame();
	        frame.setLayout(new FlowLayout());
	        frame.setSize(200,300);
	        JLabel lbl=new JLabel();
	        lbl.setIcon(icon);
	        frame.add(lbl);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}

	
	    
	    
}
