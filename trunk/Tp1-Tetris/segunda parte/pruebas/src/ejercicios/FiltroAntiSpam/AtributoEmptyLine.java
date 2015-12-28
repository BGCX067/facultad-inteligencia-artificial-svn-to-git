package ejercicios.FiltroAntiSpam;

public class AtributoEmptyLine extends AtributoAcumulativo {

	public AtributoEmptyLine(String name, String[] possibleValues,
			String defaultValue, String containCheck, int count) {
		super(name, possibleValues, defaultValue, containCheck, count);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String GetValue(String realValue, String oldValue){
		Integer ret = ( oldValue == null)?0:Integer.parseInt(oldValue);
		if( realValue.equals("")){
			ret ++;
		}
		return ret.toString();
	}
	
	@Override
	public String GetFinalValue(String value){
		
		if(Integer.parseInt(value)<=count)
		{
			return "'y'";
		}else{
			return "'n'";
		}
	}

}
