package chat.chatDiGruppo;

import chat.Chat;
import chat.enumeration.TipoChat;



public class ChatDiGruppo extends Chat{

	public ChatDiGruppo(String nomeChat) {
		super(nomeChat);
	}

	@Override
	public TipoChat getTipo() {
		return TipoChat.DIGRUPPO;
	}

	
}
		
	


