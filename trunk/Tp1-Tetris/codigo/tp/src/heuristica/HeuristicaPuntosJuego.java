package heuristica;

import tetris.Pantalla;
import aima.search.framework.HeuristicFunction;

public class HeuristicaPuntosJuego implements HeuristicFunction {

	public double getHeuristicValue(Object estado) {

		Pantalla pantalla;
		
		double puntos;
		
		pantalla = (Pantalla) estado;
		
		puntos = 1/(pantalla.getPuntaje() + 1);
		
		return puntos;
	}
}
