package chat.chatPrivata;

//import java.util.ArrayList;

//import Messaggio.MessaggioPrivato;

public class ChatPrivataTester {

	public static void main(String[] args) {
		
		ChatPrivata p = new ChatPrivata();
		//MessaggioPrivato m = new MessaggioPrivato("004", null, null, null, null, null, null);
		//ArrayList<MessaggioPrivato> res = p.selectAll();
		//System.out.println(p.scriviMessaggio(m));
		
		//for(MessaggioPrivato msg : res) { 
		//	System.out.println(msg.toString());
		//}
		p.selectAllRipetuto();
	}	
}
