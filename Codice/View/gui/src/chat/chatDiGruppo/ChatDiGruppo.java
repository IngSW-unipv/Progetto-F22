package chat.chatDiGruppo;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Messaggio.Messaggio;
import Messaggio.MessaggioDiGruppo;
import Messaggio.utility.MessaggioUtility;
import chat.Chat;
import db.messaggioDiGruppo.MessaggioDiGruppoDB;
import db.messaggioDiGruppo.MessaggioDiGruppoDao;
import profilo.Profilo;


public class ChatDiGruppo extends Chat{

	public ChatDiGruppo(Profilo profiloAttivo, MessaggioDiGruppo msg) {
		super(profiloAttivo);
		this.msg = msg;
	}

	private MessaggioDiGruppo msg;
	


	public ArrayList<MessaggioDiGruppoDB> cercaMessaggio(MessaggioDiGruppo m) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		MessaggioUtility u = new MessaggioUtility();
		return mdao.cercaMessaggioDiGruppo(u.convertiMDG(m));
	}

	
	public void ottieniMessaggio(MessaggioDiGruppo m) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		MessaggioUtility u = new MessaggioUtility();
		mdao.ottieniTesto(u.convertiMDG(m));
		
	}


	public boolean caricaMessaggio(MessaggioDiGruppo m) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		MessaggioUtility u = new MessaggioUtility();
		return  mdao.scriviMessaggioDiGruppo(u.convertiMDG(m));
		
	}

	public boolean eliminaMessaggio(MessaggioDiGruppo m) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		MessaggioUtility u = new MessaggioUtility();
		return mdao.rimuoviMessaggioDiGruppo(u.convertiMDG(m));
		
	}

	@Override
	public void leggiTuttiMessaggi() {
		
			Timer timer = new Timer();
			MessaggioDiGruppoDao gdao = new MessaggioDiGruppoDao();   
			timer.schedule(new TimerTask() {
				int i = 0;
			    public void run() {
			       
	               ArrayList<MessaggioDiGruppoDB> show = gdao.selectAll();
	               for(MessaggioDiGruppoDB msg : show)
	            	   System.out.println(msg.toString());
	                   i++;
	                   if(i == 5)
	            	      timer.cancel();
			   
			    }
			 }, 0, 60 * 1000);
	}

	
	//Restituisce un ArrayList con tutti i messaggi relativi al gruppo specificato 
	public ArrayList<MessaggioDiGruppoDB> listaMessaggiDiUnGruppo(MessaggioDiGruppo m) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		MessaggioUtility u = new MessaggioUtility();
		return mdao.selectAllIdGruppo(u.convertiMDG(m));
	}

	
	//Legge tutti i messaggi ricevuti ogni minuto da un profilo precisato.
	//Dopo 5 minuti smette di farlo e si stoppa
		
	public void leggiMessaggiDiGruppo(MessaggioDiGruppo m) {
		
		Timer timer = new Timer();
		MessaggioDiGruppoDao gdao = new MessaggioDiGruppoDao(); 
		MessaggioUtility u = new MessaggioUtility();
		timer.schedule(new TimerTask() {
			int i = 0;
		    public void run() {
		       
               ArrayList<MessaggioDiGruppoDB> show = gdao.selectAllIdGruppo(u.convertiMDG(m));
               for(MessaggioDiGruppoDB msg : show)
            	   System.out.println(msg.toString());
                   i++;
                   if(i == 5)
            	      timer.cancel();
		   
		    }
		 }, 0, 60 * 1000);
}


	public ArrayList<MessaggioDiGruppoDB> ottieniListaTuttiMessaggii() {
		MessaggioDiGruppoDao gdao = new MessaggioDiGruppoDao();
		return gdao.selectAll();
	}
	
	
	public MessaggioDiGruppo getMsg() {
		return msg;
	}

	public void setMsg(MessaggioDiGruppo msg) {
		this.msg = msg;
	}
	
	}
		
	


