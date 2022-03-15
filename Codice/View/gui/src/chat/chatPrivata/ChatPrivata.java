package chat.chatPrivata;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Messaggio.Messaggio;
import Messaggio.MessaggioPrivato;
import chat.Chat;


public class ChatPrivata extends Chat {
	
	public ChatPrivata( MessaggioPrivato msg) {
		super();
		this.msg = msg;
	}

	 private MessaggioPrivato msg;
	 
	 
	 //Ottiene la lista dei messaggi privati scambiati con un profilo specificato

	public MessaggioPrivato getMsg() {
		return msg;
	}

	public void setMsg(MessaggioPrivato msg) {
		this.msg = msg;
	}
}


	


