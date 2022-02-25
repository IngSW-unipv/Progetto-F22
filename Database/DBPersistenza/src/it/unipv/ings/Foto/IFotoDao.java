package it.unipv.ings.Foto;

import java.util.ArrayList;

public interface IFotoDao {
	public ArrayList<FotoDB> selectAll();
	public boolean pubblicaFoto(FotoDB f);
	public boolean rimuoviFoto(FotoDB f);
}
