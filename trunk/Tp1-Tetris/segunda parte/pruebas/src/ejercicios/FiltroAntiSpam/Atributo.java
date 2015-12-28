package ejercicios.FiltroAntiSpam;

import java.util.ArrayList;

public class Atributo {
	protected String name;
	protected String defaultValue;
	private String[] possibleValues;
	protected  String containCheck ;
	public Atributo(String name, String[] possibleValues, String defaultValue, String containCheck){
		this.name = name;
		this.possibleValues = possibleValues;
		this.defaultValue = defaultValue;
		this.containCheck = containCheck;
	}
	public String GetValue2(String realValue, String oldValue){
		if(oldValue != null && oldValue != defaultValue){
			return oldValue;
		}
		else{
			if(realValue.contains(containCheck)){

				for (String  elem : possibleValues) {
					if(realValue.toLowerCase().contains(elem.toLowerCase())){
						return "'"+elem+"'";
					}
				} 
						
			}
			return defaultValue;
		}
	}
	//@Override
	public String toString2() {
		return  " '"+name+ "' "+ imprimir(possibleValues);
	}
	public String GetValue(String realValue, String oldValue){
		if("'y'".equals(oldValue)){
			return "'y'";
		}
		else{
			if(!defaultValue.equals(oldValue) || realValue.toLowerCase().contains(containCheck.toLowerCase())){

				for (String  elem : possibleValues) {
					if(realValue.toLowerCase().contains(elem.toLowerCase())){
						return "'y'";
					}
				} 
				return "'n'";		
			}
			return defaultValue;
		}
	}
	@Override
	public String toString() {
		return  " '"+name+ "' {'y', 'n'} ";// + imprimir(possibleValues);
	}

	private String imprimir(Object[] values) {
		String ret = "{";
		for (Object object : values) {
			ret += "'"+object +"',";
		}
		ret = ret.substring(0,ret.lastIndexOf(","));
		ret += "}";
		return ret;
	}

	public String GetFinalValue(String value) {
		return value;
	}
		
}
