package convertitore;

import Messaggio.Messaggio;
import Messaggio.MessaggioDiGruppo;
import Messaggio.MessaggioPrivato;
import chat.chatDiGruppo.gruppo.Gruppo;
import convertitore.commentoChatUtility.CommentoUtility;
import convertitore.followUtility.FollowUtility;
import convertitore.fotoUtility.FotoUtility;
import convertitore.profiloUtility.ProfiloUtility;
import convertitore.sondaggioUtility.SondaggioUtility;
import convertitore.testoUtility.TestoUtility;
import convertitore.videoUtility.VideoUtility;
import convertitore.gruppoUtility.GruppoUtility;
import convertitore.messaggioUtility.MessaggioUtility;
import db.commento.CommentoDB;
import db.follow.FollowDB;
import db.foto.FotoDB;
import db.gruppo.GruppoDB;
import db.profilo.ProfiloDB;
import db.sondaggioDoppiaScelta.SondaggioDoppiaVotazioneDB;
import db.sondaggioSceltaMultipla.SondaggioSceltaMultiplaDB;
import db.testo.TestoDB;
import db.video.VideoDB;
import messaggio.IMessaggio;
import messaggio.messaggioDiGruppo.MessaggioDiGruppoDB;
import messaggio.messaggioPrivato.MessaggioPrivatoDB;
import post.commento.Commento;
import post.multimedia.foto.Foto;
import post.multimedia.video.Video;
import post.sondaggio.SondaggioDoppiaVotazione;
import post.sondaggio.SondaggioSceltaMultipla;
import post.testo.Testo;
import profilo.Profilo;
import profilo.follow.Follow;

public class ConvertitoreFacade {
	

	static private ConvertitoreFacade istance;
	
	private CommentoUtility cUtility;
	private FotoUtility fUtility;
	private GruppoUtility gUtility;
	private MessaggioUtility mUtility;
	private ProfiloUtility pUtility;
	private SondaggioUtility sUtility;
	private TestoUtility tUtility;
	private VideoUtility vUtility;
	private FollowUtility flUtility;
	
	private ConvertitoreFacade() {
		cUtility = new CommentoUtility();
		fUtility = new FotoUtility();
		gUtility = new GruppoUtility();
		mUtility = new MessaggioUtility();
		pUtility = new ProfiloUtility();
		sUtility = new SondaggioUtility();
		tUtility = new TestoUtility();
		vUtility = new VideoUtility();
		flUtility = new FollowUtility();
	}
	
	public static ConvertitoreFacade getIstance() {
		if(istance == null) {
			istance = new ConvertitoreFacade();
		}
		return istance;
	}

	public IMessaggio conversione(Messaggio m) {
		return mUtility.converti(m);
	}
	
	public ProfiloDB converti(Profilo p) {
		return pUtility.convertiAProfiloDB(p);
	}

	public Profilo convertiInverso(ProfiloDB pdb) {
		return pUtility.convertiAProfilo(pdb);
	}
	public FotoDB converti(Foto f) {
		return fUtility.convertiAFotoDB(f);
	}
	
	public Foto convertiInverso(FotoDB fdb) {
		return fUtility.convertiAFoto(fdb);
	}
	
	public CommentoDB converti(Commento c) {
		return cUtility.convertiACommentoDB(c);
	}

	public Commento convertiInverso(CommentoDB cdb) {
		return cUtility.convertiACommento(cdb);
	}
	public GruppoDB converti(Gruppo g) {
		return gUtility.convertiAGruppoDB(g);
	}

	public Gruppo convertiInverso(GruppoDB gdb) {
		return gUtility.convertiAGruppo(gdb);
	}
	/*public MessaggioPrivatoDB converti(MessaggioPrivato m) {
		return mUtility.convertiAMessPrivDB(m);
	}
*/
	public MessaggioPrivato convertiInverso(MessaggioPrivatoDB mdb) {
		return mUtility.convertiAMessPriv(mdb);
	}
	/*public MessaggioDiGruppoDB converti(MessaggioDiGruppo m) {
		return mUtility.convertiAMessGrupDB(m);
	}*/

	public MessaggioDiGruppo convertiInverso(MessaggioDiGruppoDB mdb) {
		return mUtility.convertiAMessGrp(mdb);
	}
	public SondaggioDoppiaVotazioneDB converti(SondaggioDoppiaVotazione s) {
		return sUtility.convertiASondDopDB(s);
	}

	public SondaggioDoppiaVotazione convertiInverso(SondaggioDoppiaVotazioneDB sdb) {
		return sUtility.convertiASondDop(sdb);
	}
	public SondaggioSceltaMultiplaDB converti(SondaggioSceltaMultipla s) {
		return sUtility.convertiASondMulDB(s);
	}

	public SondaggioSceltaMultipla convertiInverso(SondaggioSceltaMultiplaDB sdb) {
		return sUtility.convertiASondMul(sdb);
	}
	public TestoDB converti(Testo t) {
		return tUtility.convertiATestoDB(t);
	}

	public Testo convertiInverso(TestoDB tdb) {
		return tUtility.convertiATesto(tdb);
	}
	
	public VideoDB converti(Video v) {
		return vUtility.covertiAVideoDB(v);
	}
	public Video convertiInverso(VideoDB vdb) {
		return vUtility.convertiAVideo(vdb);
	}
	public FollowDB converti(Follow f) {
		return flUtility.convertiAFollowDB(f);
	}
	public Follow convertiinverso(FollowDB f) {
		return flUtility.convertiAFollow(f);
	}
}
