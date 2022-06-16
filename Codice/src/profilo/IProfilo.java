package profilo;

import java.util.ArrayList;

import Messaggio.Messaggio;
import Messaggio.enumeration.TipoMessaggio;
import chat.chatDiGruppo.gruppo.Gruppo;
import post.Post;
import post.commento.Commento;
import post.enumeration.TipoPost;
import post.multimedia.Multimedia;
import post.sondaggio.Sondaggio;
import profilo.exception.AccountDoesNotExist;
import profilo.exception.AzioneNonConsentita;
import profilo.exception.GruppoGiaPieno;
import profilo.exception.PostNonPresente;
import profilo.exception.PostNonVisibile;
import profilo.exception.ProfiloGiaInserito;
import profilo.exception.TastoNonEsistente;
import profilo.follow.Follow;

public interface IProfilo {
 
	public boolean scriviMessaggio(Messaggio m);
	public boolean rimuoviMessaggio(Messaggio m);
	public Messaggio cercaMessaggio(Messaggio m);
	public String ottieniTestoMessaggio(Messaggio m);
	public boolean pubblicaPost(Post p);
	public boolean rimuoviPost(Post p);
    public Post cercaPost(Post p) throws PostNonVisibile,PostNonPresente;
	public ArrayList<Post> selectAllPost(TipoPost t);
    public boolean pubblicaStoria(int time, Multimedia f);
    public String ottieniPercorso(Post p)throws PostNonVisibile;
    public ArrayList<Commento> selectAllCommentiSottoPost(Post p)throws PostNonVisibile;
	public ArrayList<String> testoCommentiPost(Post p)throws PostNonVisibile;
	public boolean vediVisibilita(Post p);
	public boolean modificaVisibilita(String idPost, TipoPost t, boolean b);
	public boolean aggiungiVotoSondaggio(String idSondaggio,int scelta, TipoPost t)throws TastoNonEsistente, AzioneNonConsentita;
	public void vediRisultatiSondaggio(Sondaggio s);
	public int[] ottieniConteggiSondaggio(String idSondaggio,TipoPost p);
    public Profilo cercaProfilo(Profilo p)throws AccountDoesNotExist;
    public boolean cambiaImmagineProfilo(String immagine);
    public String ottieniImmagineProfilo(Profilo p);
    public ArrayList<Messaggio> selezionaMessaggiProfilo(Profilo p, TipoMessaggio t);
	public ArrayList<String> selezionaTestoMessaggiProfilo(Profilo p, TipoMessaggio t);  
	public ArrayList<String> caricaTuttiiPostDiUnProfilo(String idProfilo, TipoPost f);
	public String vediNickname(Profilo p);
	public boolean modificaNickname(Profilo p, String n);
	public String vediDescrizione(Profilo p);
	public ArrayList<String> ProfiloNickCommento(Profilo p);
	public boolean profiloNonSeguito(String emailProfilo);
	public boolean accountEsistente(String emailProfilo) throws AccountDoesNotExist;
	public boolean segui(Profilo email)throws AccountDoesNotExist, AzioneNonConsentita;
	public boolean smettiDiSeguire(Profilo profiloSeguito) throws AccountDoesNotExist, AzioneNonConsentita;
	public ArrayList<String> vediMieiFollower(Follow f);
	public Follow cercaFollow(Follow f);
	public boolean rimuoviGruppo(Gruppo g);
	public boolean modificaPartecipantiGruppo(String idGruppo, String profilo1,String profilo2,String profilo3,String profilo4,String profilo5,String profilo6);
    public Gruppo cercaGruppo(Gruppo g);
	public ArrayList<Gruppo> selectAllGruppo();
	public boolean aggiungiLike(String idPost, TipoPost t)throws AzioneNonConsentita;
	public boolean aggiungiDislike(String idPost, TipoPost t)throws AzioneNonConsentita;
	public boolean rimuoviLike(String idPost, TipoPost t)throws AzioneNonConsentita;
	public boolean rimuoviDislike(String idPost, TipoPost t)throws AzioneNonConsentita;
	boolean creaGruppo(String descrizione, String nomeGruppo)
			throws AccountDoesNotExist;
	boolean rimuoviCommento(String idCommento);
	public Commento cercaCommento(String idCommento);
	boolean modificaDescrizione(String n);
	boolean aggiungiPartecipante(String idGruppo, String idProfilo) throws GruppoGiaPieno, ProfiloGiaInserito;
	boolean rimuoviPartecipante(String idGruppo, String idProfilo);
	boolean pubblicaCommento(String idProfilo, String idPost, String testoCommento, TipoPost t);
	boolean modificaDescrizione(String idGruppo, String descrizione);
    public int vediNumLike(String post, TipoPost t);
    public int vediNumDislike(String post, TipoPost t);
    public int vediNumPost(String profilo);
    public int vediNumFollower(String idProfilo);
    public int vediNumSeguiti(String idProfilo);

}

