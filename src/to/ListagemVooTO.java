package to;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ListagemVooTO extends ArrayList<VooTO> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String toJSON(){
		JSONArray v = new JSONArray();
		Locale local = new Locale("pt","BR");
		DateFormat f = DateFormat.getDateInstance(DateFormat.MEDIUM, local);
		for(VooTO to:this){
			JSONObject obj = new JSONObject();
			try {
				obj.put("id", to.id);
				obj.put("codigo", to.codigo);
				obj.put("nome", to.nome);
				obj.put("data", f.format(to.data));
				obj.put("aeroportoOrigem",to.aeroportoOrigem.toJSONObject() );
				obj.put("aeroportoDestino", to.aeroportoDestino.toJSONObject());
				obj.put("aeronave", to.aeronave.toJSONObject() );
				v.put(obj);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return v.toString();	
	}
}

