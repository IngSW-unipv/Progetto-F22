package profilo;

import java.util.HashMap;

public interface IProfilo {

	public HashMap<String, String> modificaFollow(Profilo p);
	public boolean modificaLike(Profilo p);
}
