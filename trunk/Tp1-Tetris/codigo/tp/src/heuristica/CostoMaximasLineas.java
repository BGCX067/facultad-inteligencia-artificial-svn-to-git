package heuristica;

import tetris.*;
import aima.search.framework.StepCostFunction;;

public class CostoMaximasLineas implements StepCostFunction {

	public Double calculateStepCost(Object desdeEstado, Object aEstado, String action) {
		
		Pantalla desdePantalla;
		Pantalla aPantalla;
		double lineas;
		
		desdePantalla = (Pantalla) desdeEstado;
		aPantalla = (Pantalla) aEstado;
		
		/*
		
		La diferencia entre las lineas entre ambas pantallas se	corresponde con las lineas
		hechas con la ultima movida de pieza. Entonces, si le restamos esas lineas a
		4 tendremos las lineas no hechas o perdidas con la ultima movida de pieza.
		
		*/
		
		lineas = 4 - (aPantalla.getLineas() - desdePantalla.getLineas());
		
		return lineas;
	}

}