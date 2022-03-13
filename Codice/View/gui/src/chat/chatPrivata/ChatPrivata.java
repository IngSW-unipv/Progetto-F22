package chat.chatPrivata;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Messaggio.Messaggio;
import Messaggio.MessaggioPrivato;
import Messaggio.utility.MessaggioUtility;
import chat.Chat;
import db.messaggioPrivato.MessaggioPrivatoDB;
import db.messaggioPrivato.MessaggioPrivatoDao;
import profilo.Profilo;

public class ChatPrivata extends Chat {
	
	public ChatPrivata(Profilo profiloAttivo, MessaggioPrivato msg) {
		super(profiloAttivo);
		this.msg = msg;
	}

	 private MessaggioPrivato msg;
	 
	 
	 //Ottiene la lista dei messaggi privati scambiati con un profilo specificato
		public ArrayList<MessaggioPrivatoDB> selectAllNomeProfilo(MessaggioPrivato m) {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		MessaggioUtility u = new MessaggioUtility();
		return mdao.selectAllNomeProfilo(u.convertiMPDB(m));
	}
	
	
	public ArrayList <MessaggioPrivatoDB> ottieniListaTuttiMessaggii() {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		return mdao.selectAll();
	
	}
	
	
	public ArrayList<MessaggioPrivatoDB> cercaMessaggio(MessaggioPrivato m) {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		MessaggioUtility u = new MessaggioUtility();
		return mdao.cercaMessaggioPrivato(u.convertiMPDB(m));
	}

	public void ottieniMessaggio(MessaggioPrivato m) {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		MessaggioUtility u = new MessaggioUtility();
		mdao.ottieniMessaggio(u.convertiMPDB(m));
	}


	public boolean caricaMessaggio(MessaggioPrivato m) {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		MessaggioUtility u = new MessaggioUtility();
		
		return mdao.scriviMessaggioPrivato(u.convertiMPDB(m));

	}

	
	public boolean eliminaMessaggio(MessaggioPrivato m) {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		MessaggioUtility u = new MessaggioUtility();

		return mdao.rimuoviMessaggioPrivato(u.convertiMPDB(m));

	}
	

	@Override
	public void leggiTuttiMessaggi() {
		Timer timer = new Timer();
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();   
		timer.schedule( new TimerTask() {
			int i = 0;
		    public void run() {
		       
               ArrayList<MessaggioPrivatoDB> show = mdao.selectAll();
               for(MessaggioPrivatoDB msg : show)
            	   System.out.println(msg.toString());
                   i++;
                   if(i == 5)
            	      timer.cancel();
		   
		    }
		 }, 0, 60 * 1000);
	}

	//Legge tutti i messaggi ricevuti ogni minuto da un profilo precisato.
	//Dopo 5 minuti smette di farlo e si stoppa
	
	public void leggiMessaggiPrivati(MessaggioPrivato m) {
		Timer timer = new Timer();
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();  
		MessaggioUtility u = new MessaggioUtility();
		timer.schedule( new TimerTask() {
			int i = 0;
		    public void run() {
		       
               ArrayList<MessaggioPrivatoDB> show = mdao.selectAllNomeProfilo(u.convertiMPDB(m));
               for(MessaggioPrivatoDB msg : show)
            	   System.out.println(msg.toString());
                   i++;
                   if(i == 5)
            	      timer.cancel();
		   
		    }
		 }, 0, 60 * 1000);
	}


	public MessaggioPrivato getMsg() {
		return msg;
	}

	public void setMsg(MessaggioPrivato msg) {
		this.msg = msg;
	}
	

	}


	


