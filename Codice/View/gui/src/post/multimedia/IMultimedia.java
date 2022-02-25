package post.multimedia;

import post.multimedia.video.Video;

public interface IMultimedia {

	//Permette di fare diventare i multimedia delle storie. 
	//Cioè quest'ultimi si cancelleranno in automatica dopo un periodo di tempo deciso dall'utente
	public abstract boolean settaDurataStoria(int time, Video v);
	
}
