package chat;

import profilo.Profilo;

public abstract class Chat {

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
	public abstract String ritornaIlMioIdProfilo();
}
