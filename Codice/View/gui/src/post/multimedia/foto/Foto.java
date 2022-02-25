package post.multimedia.foto;

import java.sql.Date;
import java.sql.Time;

import it.unipv.ings.Foto.FotoDB;
import it.unipv.ings.Foto.FotoDao;
import post.multimedia.Multimedia;

public class Foto extends Multimedia{

	public Foto(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, int numLike,
			int numDislike, boolean visibile, boolean condivisibile, String profilo, int tempoCancellazione,
			String percorso, boolean isStory, String idFoto) {
		super(idPost, dataPubblicazione, oraPubblicazione, descrizione, numLike, numDislike, visibile, condivisibile, profilo,
				tempoCancellazione, percorso, isStory);
		this.idFoto = idFoto;
	}

	private String idFoto;

	public String getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(String idFoto) {
		this.idFoto = idFoto;
	}
	
	public boolean pubblicaFoto(FotoDB f) {
		boolean b;
		FotoDao fdao = new FotoDao();
		b = fdao.pubblicaFoto(f);
		return b;
	}
	
	public boolean rimuoviFoto(FotoDB f) {
		boolean b;
		FotoDao fdao = new FotoDao();
		b = fdao.rimuoviFoto(f);
		return b;
	}
	
	public boolean settaDurataStoria(int time, Foto f) {
		UtilityFoto u = new UtilityFoto();
		this.setStory(true);
		this.setTempoCancellazione(time);
		this.pubblicaFoto(u.convertiToFotoDB(f));
		try {
		    Thread.sleep(time * 60 * 60 * 1000);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
		this.rimuoviFoto(u.convertiToFotoDB(f));	
		return true;
	}
}
