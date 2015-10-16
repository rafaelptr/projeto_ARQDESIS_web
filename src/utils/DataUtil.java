package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {

	public static String DataToString(Date data){
		String saida = "";
		if(data != null){
			try{
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			saida = df.format(data);
			}catch(Exception e){}
		}
		return saida;
	}
}

