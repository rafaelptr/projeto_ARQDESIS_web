package to;

import java.io.Serializable;

public class BilheteTO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int id; 
	public String codigo = "";
	public int passageiroId;
	public PassageiroTO passageiro;
	public int pagamentoId;
	public PagamentoTO pagamento;
}
