package heuristica;

public class HeuristicaEstadistica extends HeuristicaCuadradosNoMoviles {
	
	private double porcentaje;
	
	public HeuristicaEstadistica(double porcentaje){
		
		this.porcentaje = porcentaje;
	}
	
	public double puntos(int cuadrados){
		
		double puntos;
		
		puntos = super.puntos(cuadrados) * (porcentaje/100);
		
		return  puntos;
	}
}
