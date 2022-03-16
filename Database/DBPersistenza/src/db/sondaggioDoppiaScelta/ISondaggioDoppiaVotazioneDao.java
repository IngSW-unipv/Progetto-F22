package db.sondaggioDoppiaScelta;

import java.util.ArrayList;

public interface ISondaggioDoppiaVotazioneDao {
	public ArrayList<SondaggioDoppiaVotazioneDB> selectAll();
	public boolean pubblicaSondaggio(SondaggioDoppiaVotazioneDB p);
	public boolean rimuoviSondaggio(SondaggioDoppiaVotazioneDB p);
	public ArrayList<SondaggioDoppiaVotazioneDB> cercaSondaggio(String s);
}
