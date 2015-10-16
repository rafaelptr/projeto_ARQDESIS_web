package to;

import java.io.Serializable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AeroportoTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int id;
	public String codigo = "";
	public String nome = "";
	public String nomeCompleto = "";
	public String estado = "";
	public String pais = "";
	
	public JSONObject toJSONObject(){
		JSONObject obj = new JSONObject();
		try {
			obj.put("id", id);
			obj.put("codigo", codigo);
			obj.put("nome", nome);
			obj.put("nomeCompleto",nomeCompleto);
			obj.put("estado",estado);
			obj.put("pais",pais);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;	
	}
}
