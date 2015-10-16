package to;

import java.io.Serializable;

public class PassageiroTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int id;
	public String nome = "";
	public String cpf = "";
	public int bilheteId;
	public BilheteTO bilhete;
}
