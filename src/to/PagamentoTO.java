package to;

import java.io.Serializable;

public class PagamentoTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int id;
	public String status = "";
	public String tipo = "";
	public int cartaoId;
	public CartaoTO cartao;
	public String codigoTransacao = "";
}
