package chat.chatDiGruppo;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import Messaggio.Messaggio;
import Messaggio.MessaggioDiGruppo;
import chat.Chat;



public class ChatDiGruppo extends Chat{

	public ChatDiGruppo(MessaggioDiGruppo msg) {
		super();
		this.msg = msg;
	}

	private MessaggioDiGruppo msg;

	
	//Restituisce un ArrayList con tutti i messaggi relativi al gruppo specificato 

	
	//Legge tutti i messaggi ricevuti ogni minuto da un profilo precisato.
	//Dopo 5 minuti smette di farlo e si stoppa
	/*
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
}*/

	
	public MessaggioDiGruppo getMsg() {
		return msg;
	}

	public void setMsg(MessaggioDiGruppo msg) {
		this.msg = msg;
	}
	
}
		
	


