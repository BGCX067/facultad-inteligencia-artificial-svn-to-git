package heuristica;

import tetris.*;

public class HeuristicaCuadradosMoviles extends HeuristicaMaximoPuntaje {

	public double getMaximoPuntaje(Pantalla pantalla){
		
		double maximo;
		int cuadrados;
		
		//Cuento cuantos cuadrados tengo en las piezas sin colocar:
		
		cuadrados = (pantalla.getPiezas().length - pantalla.getIndice()) * 4;
		
		//Cuento cuantos cuadrados tengo en la ventana:
	
		cuadrados = cuadrados + pantalla.getVentana().ocupados();
		
		//Con todos esos cuadrados hago la maxima cantidad posible de puntos:
		
		maximo = puntos(cuadrados);

		return maximo;
	}
}
