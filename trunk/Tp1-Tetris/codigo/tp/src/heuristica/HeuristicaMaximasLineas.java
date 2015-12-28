package heuristica;

import tetris.Pantalla;
import tetris.Ventana;
import aima.search.framework.EvaluationFunction;
import aima.search.framework.HeuristicFunction;
import aima.search.framework.Node;
import aima.search.framework.Problem;

public class HeuristicaMaximasLineas implements HeuristicFunction , EvaluationFunction {
	
	public double getHeuristicValue(Object estado){
		
		Pantalla pantalla;
		double valor;
		int piezas;
		
		pantalla = (Pantalla) estado;
		piezas = pantalla.getPiezas().length - pantalla.getIndice();
		
		if(piezas > 0){
			valor = piezas * 4 - getMaximasLineas(pantalla);
		} else {
			valor = 0;
		}
		
		return valor;
	}
	
	public Double getValue(Problem problema, Node nodo) {
		
		Double valor;
		
		valor = (Double) (nodo.getPathCost() + problema.getHeuristicFunction().getHeuristicValue(nodo.getState()));
		
		return valor;
	}
	
	public double getMaximasLineas(Pantalla pantalla){
		
		double maximo;
		int cuadrados;
			
		//Cuento cuantos cuadrados tengo en las piezas sin colocar:
			
		cuadrados = (pantalla.getPiezas().length - pantalla.getIndice()) * 4;
			
		//Cuento cuantos cuadrados tengo en la ventana:
		
		cuadrados = cuadrados + pantalla.getVentana().ocupados();
			
		//Con todos esos cuadrados hago la maxima cantidad posible de lineas:
			
		maximo = lineas(cuadrados);

		return maximo;
	}
	
	public double lineas(int cuadrados){
		
		int lineas;
		
		//Los cuadrados necesitados para formar una linea dependen de la ventana:
		
		lineas = cuadrados / Ventana.ancho;
		
		return lineas;
	}
}

