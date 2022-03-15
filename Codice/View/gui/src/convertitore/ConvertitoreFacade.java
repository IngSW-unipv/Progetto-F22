package convertitore;

import Messaggio.MessaggioDiGruppo;
import Messaggio.MessaggioPrivato;
import chat.chatDiGruppo.gruppo.Gruppo;
import convertitore.commentoChatUtility.CommentoUtility;
import convertitore.fotoUtility.FotoUtility;
import convertitore.profiloUtility.ProfiloUtility;
import convertitore.sondaggioUtility.SondaggioUtility;
import convertitore.testoUtility.TestoUtility;
import convertitore.videoUtility.VideoUtility;
import convertitore.gruppoUtility.GruppoUtility;
import convertitore.messaggioUtility.MessaggioUtility;
import db.commento.CommentoDB;
import db.foto.FotoDB;
import db.gruppo.GruppoDB;
import db.messaggioDiGruppo.MessaggioDiGruppoDB;
import db.messaggioPrivato.MessaggioPrivatoDB;
import db.profilo.ProfiloDB;
import db.sondaggioDoppiaScelta.SondaggioDoppiaVotazioneDB;
import db.sondaggioSceltaMultipla.SondaggioSceltaMultiplaDB;
import db.testo.TestoDB;
import db.video.VideoDB;
import post.Post;
import post.commento.Commento;
import post.multimedia.foto.Foto;
import post.multimedia.video.Video;
import post.sondaggio.SondaggioDoppiaVotazione;
import post.sondaggio.SondaggioSceltaMultipla;
import post.testo.Testo;
import profilo.Profilo;

public class ConvertitoreFacade {
	
	static public ProfiloDB converti(Profilo p) {
		return ProfiloUtility.convertiAProfiloDB(p);
	}
	static public Profilo convertiinverso(ProfiloDB pdb) {
		return ProfiloUtility.convertiAProfilo(pdb);
	}
	static public FotoDB converti(Foto f) {
		return FotoUtility.convertiAFotoDB(f);
	}
	static public Post convertiinverso(FotoDB fdb) {
		return FotoUtility.convertiAFoto(fdb);
	}
	static public CommentoDB converti(Commento c) {
		return CommentoUtility.convertiACommentoDB(c);
	}
	static public Commento convertiinverso(CommentoDB cdb) {
		return CommentoUtility.convertiACommento(cdb);
	}
	static public GruppoDB converti(Gruppo g) {
		return GruppoUtility.convertiAGruppoDB(g);
	}
	static public Gruppo convertiinverso(GruppoDB gdb) {
		return GruppoUtility.convertiAGruppo(gdb);
	}
	static public MessaggioPrivatoDB converti(MessaggioPrivato m) {
		return MessaggioUtility.convertiAMessPrivDB(m);
	}
	static public MessaggioPrivato convertiinverso(MessaggioPrivatoDB mdb) {
		return MessaggioUtility.convertiAMessPriv(mdb);
	}
	static public MessaggioDiGruppoDB converti(MessaggioDiGruppo m) {
		return MessaggioUtility.convertiAMessGrupDB(m);
	}
	static public MessaggioDiGruppo convertiinverso(MessaggioDiGruppoDB mdb) {
		return MessaggioUtility.convertiAMessGrp(mdb);
	}
	static public SondaggioDoppiaVotazioneDB converti(SondaggioDoppiaVotazione s) {
		return SondaggioUtility.convertiASondDopDB(s);
	}
	static public SondaggioDoppiaVotazione convertiinverso(SondaggioDoppiaVotazioneDB sdb) {
		return SondaggioUtility.convertiASondDop(sdb);
	}
	static public SondaggioSceltaMultiplaDB converti(SondaggioSceltaMultipla s) {
		return SondaggioUtility.convertiASondMulDB(s);
	}
	static public SondaggioSceltaMultipla convertiinverso(SondaggioSceltaMultiplaDB sdb) {
		return SondaggioUtility.convertiASondMul(sdb);
	}
	static public TestoDB converti(Testo t) {
		return TestoUtility.convertiATestoDB(t);
	}
	static public Testo convertiinverso(TestoDB tdb) {
		return TestoUtility.convertiATesto(tdb);
	}
	static public VideoDB converti(Video v) {
		return VideoUtility.covertiAVideoDB(v);
	}
	static public Video convertiinverso(VideoDB vdb) {
		return VideoUtility.convertiAVideo(vdb);
	}
}
