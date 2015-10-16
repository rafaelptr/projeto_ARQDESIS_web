package to;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AeronaveTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8083397341719258773L;
	
	public int id;
	public String codigo = "";
	public String nome = "";
	public int qtdAssentosA;
	public int qtdAssentosB;
	public int qtdAssentosC;
	public int qtdAssentosHorizontais;
	public int qtdAssentosVerticais;
	public ArrayList<AssentoTO> assentos; 

	
	public JSONObject toJSONObject(){
		JSONObject obj = new JSONObject();
		try {
			obj.put("id", id);
			obj.put("codigo", codigo);
			obj.put("nome", nome);
			obj.put("qtdAssentosA",qtdAssentosA);
			obj.put("qtdAssentosB",qtdAssentosB);
			obj.put("qtdAssentosC",qtdAssentosC);
			obj.put("qtdAssentosHorizontais",qtdAssentosHorizontais);
			obj.put("qtdAssentosVerticais",qtdAssentosVerticais);
			obj.put("total",(qtdAssentosA + qtdAssentosB + qtdAssentosC));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;	
	}
}

