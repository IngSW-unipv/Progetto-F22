package chat.chatDiGruppo;

//import java.util.ArrayList;

//import Messaggio.MessaggioDiGruppo;

public class ChatDiGruppoTester {

	public static void main(String[] args) {
		ChatDiGruppo c = new ChatDiGruppo();
//		MessaggioDiGruppo m = new MessaggioDiGruppo("001", null, null, "Ciao Sara, come va?", null, null);
		
		//ArrayList<MessaggioDiGruppo> res = c.selectAll();
		//for(MessaggioDiGruppo msg : res) { 
		//		System.out.println(msg.toString());
		//	}
		
		//System.out.println(c.scriviMessaggio(m));
		
		c.selectAllRipetuto();
	}
}
