package heuristica;

import tetris.*;
import aima.search.framework.StepCostFunction;;

public class CostoMaximoPuntaje implements StepCostFunction {

	public Double calculateStepCost(Object desdeEstado, Object aEstado, String action) {
		
		Pantalla desdePantalla;
		Pantalla aPantalla;
		double perdidos;
		
		desdePantalla = (Pantalla) desdeEstado;
		aPantalla = (Pantalla) aEstado;
		
		/*
		
		La diferencia entre los puntos entre ambas pantallas se	corresponde con los	puntos
		hechos con la ultima movida de pieza. Entonces, si le restamos esos	puntos a
		80 tendremos los puntos no hechos o perdidos con la ultima movida de pieza.
		
		*/
		
		perdidos = 80 - (aPantalla.getPuntaje() - desdePantalla.getPuntaje());
		
		return perdidos;
	}

}
