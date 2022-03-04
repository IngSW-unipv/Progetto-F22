package chat;

import profilo.Profilo;

public abstract class Chat implements IChat{

	private Profilo profiloAttivo;
	
	public Chat(Profilo profiloAttivo) {
		this.profiloAttivo = profiloAttivo;
	}

	public Profilo getProfiloAttivo() {
		return profiloAttivo;
	}

	public void setProfiloAttivo(Profilo profiloAttivo) {
		this.profiloAttivo = profiloAttivo;
	}	

}
