package db.video;

import java.util.ArrayList;

public interface IVideoDao {
	public ArrayList<VideoDB> selectAll();
	public boolean pubblicaVideo(VideoDB v);
	public boolean rimuoviVideo(VideoDB v);
}
