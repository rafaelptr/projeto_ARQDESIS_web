package to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class VooTO implements Serializable {
	
	/**
	 * 
	 */
	public static final long serialVersionUID = 1L;
	public int id;
	public String nome = "";
	public String codigo = "";
	public int aeronaveId;
	public AeronaveTO aeronave;
	public int aeroportoOrigemId;
	public AeroportoTO aeroportoOrigem;
	public int aeroportoDestinoId;
	public AeroportoTO aeroportoDestino;
	public double preco;
	public ArrayList<PassageiroTO> passageiros;
	public Date data;
}

