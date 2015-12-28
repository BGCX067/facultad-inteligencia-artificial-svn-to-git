package heuristica;

import tetris.*;
import aima.search.framework.HeuristicFunction;
import aima.search.framework.EvaluationFunction;
import aima.search.framework.Node;
import aima.search.framework.Problem;

public abstract class HeuristicaMaximoPuntaje implements HeuristicFunction , EvaluationFunction {
	
	/*
	
	El algoritmo A* expande solamente los nodos n cuya f(n) = g(n) + h(n) es minima. En consecuencia,
	teniendo en cuenta que maximizar la cantidad de puntos hechos es lo mismo que minimizar	la cantidad
	de puntos no hechos o perdidos, podemos definir a g(n) como los puntos perdidos desde el inicio hasta
	n y a h(n) como la minima cantidad de puntos, estimada, a perder desde el nodo n hasta el final.
	Luego, f(n) sera la minima cantidad de puntos, de vuelta estimada, a perder por una solucion que pase por
	el nodo n.
	
	Ahora bien, pasemos a la definicion mas precisa de h. Como cada vez que se mueve una pieza como
	maximo se pueden obtener 80 puntos, los puntos perdidos estaran dados por la diferencia entre 80 y los
	puntos hechos al mover la pieza. Si se tienen p piezas entonces la maxima cantidad	de puntos a perder de
	ahi hasta que se acaben las piezas son 80 * p y la minima cantidad es 80 * p - m, donde m es el maximo
	puntaje posible para esa pantalla.
	
	Desde luego, m sera estimado ya que en definitiva es lo que	requiere hallar	el problema. Esta familia
	de heuristicas se basa en sobrestimar m para asi tener una h(n)	subestimadora. Analiticamente, m* <= m sii
	80 * p - m <= 80 * p - m* sii h <= h*.
	
	Al final, cuando lleguemos a un nodo n que es objetivo, tendremos h(n) = 0 porque si no hay mas piezas
	no habran puntos que perder. De este modo, f(n) = g(n) = (80 - p_1) + (80 - p_2) + ... + (80 - p_200),
	siendo p_1, p_2, ... y p_200 los puntos hechos a lo largo del camino. La expresion anterior se puede
	reescribir como 200 * 80 - (p_1 + p_2 + ... + p_200), se puede ver que como se señalo al principio
	alcanzara un minimo	cuando (p_1 + p_2 + ... + p_200) sea maximo. De esta forma, al terminar el algoritmo A*
	al resultado se le aplica la funcion v(x) = 200 * 80 - x, consiguiendo lo buscado.
	
	 */
	
	public double getHeuristicValue(Object estado){
		
		Pantalla pantalla;
		double valor;
		int piezas;
		
		pantalla = (Pantalla) estado;
		piezas = pantalla.getPiezas().length - pantalla.getIndice();
		
		if(piezas > 0){
			valor = piezas * 80 - getMaximoPuntaje(pantalla);
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
	
	public abstract double getMaximoPuntaje(Pantalla pantalla);
	
	public double puntos(int cuadrados){
		
		double puntos;
		int lineas;
		int tetris;
		int quedaron;
		
		//Los cuadrados necesitados para formar una linea dependen de la ventana:
		
		lineas = cuadrados / Ventana.ancho;
		
		//Primero hago de a 4 lineas a la vez, un tetris, que da 80 puntos:
		
		tetris = lineas / 4;
		puntos = tetris * 80;
		
		//Despues, con las piezas que quedaron, hago de a 1 linea, 2 lineas o
		//3 lineas a la vez que da 10, 20 y 30 puntos, respectivamente:
		
		quedaron = lineas - tetris * 4;
		
		if(quedaron == 1){
			puntos = puntos + 10;
		} else if (quedaron == 2){
			puntos = puntos + 30;
		} else if (quedaron == 3){
			puntos = puntos + 50;	
		}
		
		return puntos;
	}
}
