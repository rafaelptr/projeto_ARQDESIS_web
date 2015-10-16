package to;

import java.io.Serializable;

public class AssentoTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int id;
	public String classe = "";
	public int aeronaveId;
	public AeronaveTO aeronave;
	public String localizacao = "";
}
