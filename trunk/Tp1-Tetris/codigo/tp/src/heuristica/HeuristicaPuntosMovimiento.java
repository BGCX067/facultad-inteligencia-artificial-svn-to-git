package heuristica;

import tetris.Pantalla;
import aima.search.framework.HeuristicFunction;

public class HeuristicaPuntosMovimiento implements HeuristicFunction {

	public double getHeuristicValue(Object estado) {
	 	return 1/ (((Pantalla) estado).getUltimaJugada().puntos+2);
	}

}
