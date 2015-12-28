package busquedas;

import java.util.*;

import tetris.Objetivo;
import aima.search.framework.Node;
import aima.search.framework.NodeWrapper;
import aima.search.framework.NodeWrapperExpander;
import aima.search.framework.Problem;

public class VorazPrimeroElMejor implements Busqueda {
	
	NodeWrapper cota;
	
	public Ejecucion buscar(Problem problema){
		
		Ejecucion ejecucion;
		PriorityQueue<NodeWrapper> frontera;
		List<NodeWrapper> nodos;
		NodeWrapperExpander expansor;
		NodeWrapper minimo;
		NodeWrapper objetivo;
		double f;
		long t0;
		long t;
				
		ejecucion = new Ejecucion();
		expansor = new NodeWrapperExpander();
		
		//Pongo el nodo inicial en la frontera, que empieza vacia:
		
		frontera = new PriorityQueue<NodeWrapper>();
		minimo = new NodeWrapper(new Node(problema.getInitialState()));
		frontera.add(minimo);
		
		objetivo = null;
		
		ejecucion.nodosEnFrontera = 0;
		ejecucion.nodosExpandidos = 0;
		
		t0 = System.currentTimeMillis();

		do  {
			
			//Busco entre los nodos de la frontera un nodo con la minima f, lo saco y lo expando:
			
			minimo = frontera.remove();
			nodos = expansor.expandNode(minimo, problema);
			ejecucion.nodosExpandidos++;
			
			for(NodeWrapper nodo : nodos){
				
				//La funcion f es el costo estimado de una solucion optima desde
				//este nodo a un nodo objetivo, conocido como h:
					
				f = problema.getHeuristicFunction().getHeuristicValue(nodo.getNode().getState());
				nodo.setCost(f);

				if(!problema.isGoalState(nodo.getNode().getState())){
				
					//Si el nodo no es objetivo y no se especifico una cota, entonces lo pongo en la
					//frontera. En caso contrario, cuando si se especifico una cota, lo pondre en la
					//frontera solo si su costo hasta el momento es menor que el de la cota:
					
					if(getCota() == null || nodo.getNode().getPathCost() < getCota().getNode().getPathCost())
						frontera.add(nodo);
					
				} else {
				
					//Si el nodo es objetivo y no se especifico una cota, entonces ya puedo terminar,
					//aunque espero a ver todos los nodos por si aparece otro que tambien sea objetivo
					//y tenga un costo menor. En caso contrario, cuando si se especifico una cota, para
					//terminar tiene que ocurrir ademas que el costo del objetivo sea menor que el de la cota:
				
					if ((objetivo == null || nodo.getNode().getPathCost() <= objetivo.getNode().getPathCost()) &&
						(getCota() == null || nodo.getNode().getPathCost() < getCota().getNode().getPathCost())){
							
						objetivo = nodo;
						ejecucion.seleccionar(nodo);
					}
				}
			}
			
			if(frontera.size() > ejecucion.nodosEnFrontera) ejecucion.nodosEnFrontera = frontera.size();
			
		} while (objetivo == null && !frontera.isEmpty());
		
		t = System.currentTimeMillis();
		
		ejecucion.tiempo = ((double)(t - t0))/1000;
		ejecucion.resultado = objetivo;
		
		return ejecucion;
	}

	public NodeWrapper getCota() {
		return cota;
	}

	public void setCota(NodeWrapper cota) {
		this.cota = cota;
	}
}