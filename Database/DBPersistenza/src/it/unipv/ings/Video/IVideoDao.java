package it.unipv.ings.Video;

import java.util.ArrayList;

public interface IVideoDao {
	public ArrayList<Video> selectAll();
	public boolean pubblicaVideo(Video v);
	public boolean inserisciChiavi(Video v);
	public boolean rimuoviVideo(Video v);
}
