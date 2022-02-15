package it.unipv.po.profile;

import java.util.List;
import java.util.HashMap;

import it.unipv.po.user.*;

public class Profilo {
	
	private Utente u;
	private String pwd;
	private String nickname;
	private String descrizione;
	private int numeroFollower;
	private int numeroSeguiti;
	private int numeroPost;
	private boolean connesso = true;
	//private List <Post> ListaPost;
	//private HashMap <Profilo, Chat> ListaChat;
	private EnumProfilo tipoProfilo;

	public Profilo(String nickname, String pwd) {
		u = new Utente();
		this.pwd = pwd;
		numeroFollower = 0;
		numeroSeguiti = 0;
		numeroPost = 0;
		//ListaPost ArrayList<Post>= new ArrayList<Post>();
		//ListaChat = new HashMap<Profilo, Chat>;
	}
	
	public void inserisciPwd(String pwd) {
		u.getCredenziali().setPwd(pwd);
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getNumeroFollower() {
		return numeroFollower;
	}

	public void setNumeroFollower(int numeroFollower) {
		this.numeroFollower = numeroFollower;
	}

	public int getNumeroSeguiti() {
		return numeroSeguiti;
	}

	public void setNumeroSeguiti(int numeroSeguiti) {
		this.numeroSeguiti = numeroSeguiti;
	}

	public int getNumeroPost() {
		return numeroPost;
	}

	public void setNumeroPost(int numeroPost) {
		this.numeroPost = numeroPost;
	}

	public EnumProfilo getTipoProfilo() {
		return tipoProfilo;
	}

	public void setTipoProfilo(EnumProfilo tipoProfilo) {
		this.tipoProfilo = tipoProfilo;
	}
}
