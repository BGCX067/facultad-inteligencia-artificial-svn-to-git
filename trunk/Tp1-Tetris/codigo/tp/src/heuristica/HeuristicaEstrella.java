package heuristica;

import java.util.*;
import tetris.Pantalla;

	public class HeuristicaEstrella extends HeuristicaMaximoPuntaje {

		/* 

		Esta heuristica no estima m, el maximo puntaje posible para esta pantalla, sino
		que mediante backtracking halla el m exacto. Es la heuristica teorica h*.
			
		*/
		
		public double getMaximoPuntaje(Pantalla pantalla) {
			
			double maximo;
			Set<Pantalla> soluciones;
			Iterator<Pantalla> iterador;
			
			soluciones = new HashSet<Pantalla>();
			pantalla.optima(soluciones);
			iterador = soluciones.iterator();
			maximo = iterador.next().getPuntaje() - pantalla.getPuntaje();
			
			return maximo;
		}
}
