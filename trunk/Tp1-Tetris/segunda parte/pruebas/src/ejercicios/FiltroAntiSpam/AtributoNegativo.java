package ejercicios.FiltroAntiSpam;

public class AtributoNegativo extends Atributo {


	public AtributoNegativo(String name, String[] possibleValues,
			String defaultValue, String containCheck) {
		super(name, possibleValues, defaultValue, containCheck);
	}

	@Override
	public String GetFinalValue(String value) {
		if(value.equals(this.defaultValue)){
			return "'y'";
		}
		return value;
	}
	

	
	
}
