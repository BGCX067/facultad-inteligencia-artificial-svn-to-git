package ejercicios.FiltroAntiSpam;

public class AtributoAcumulativo extends Atributo {
int count ;
	public AtributoAcumulativo(String name, String[] possibleValues,
			String defaultValue, String containCheck, int count) {
		super(name, possibleValues, defaultValue, containCheck);
		this.count  = count;
	}
	
	
	public String GetValue(String realValue, String oldValue){
		Integer ret = ( oldValue == null)?0:Integer.parseInt(oldValue);
		if( realValue.contains(this.containCheck)){
			ret ++;
		}
		return ret.toString();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return   " '"+name+ "' integer";
	}
	@Override
	public String GetFinalValue(String value){
		
		return String.valueOf( count);
		/*
		if(Integer.parseInt(value)<=count)
		{
			return "'y'";
		}else{
			return "'n'";
		}*/
	}
}
