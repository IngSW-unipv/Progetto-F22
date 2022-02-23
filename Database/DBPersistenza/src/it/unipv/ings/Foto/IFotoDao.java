package it.unipv.ings.Foto;

import java.util.ArrayList;

public interface IFotoDao {
	public ArrayList<Foto> selectAll();
	public boolean pubblicaFoto(Foto f);
	public boolean rimuoviFoto(Foto f);
}
