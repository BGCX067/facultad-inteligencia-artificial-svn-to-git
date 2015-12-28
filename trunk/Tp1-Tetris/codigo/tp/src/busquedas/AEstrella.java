package busquedas;

import java.util.*;
import aima.search.framework.Node;
import aima.search.framework.NodeWrapper;
import aima.search.framework.NodeWrapperExpander;
import aima.search.framework.Problem;

public class AEstrella implements Busqueda {
	
	public final int limite = 1;
	NodeWrapper hint;
	
	public Ejecucion buscar(Problem problema){
		
		Ejecucion ejecucion;
		PriorityQueue<NodeWrapper> frontera;
		PriorityQueue<NodeWrapper> temp;
		List<NodeWrapper> nodos;
		NodeWrapperExpander expansor;
		NodeWrapper minimo;
		NodeWrapper objetivo;
		double f;
		int veces;
		long t0;
		long t;
			
		boolean debugging = false;
		tetris.Pantalla pantalla;
		int piezas;
		int costo;
				
		ejecucion = new Ejecucion();
		expansor = new NodeWrapperExpander();
		
		//Pongo el nodo inicial en la frontera, que empieza vacia:
		
		frontera = new PriorityQueue<NodeWrapper>();
		minimo = new NodeWrapper(new Node(problema.getInitialState()));
		frontera.add(minimo);
		
		//De ser posible, busco un nodo objetivo con otra busqueda, menos costosa,
		//que sirva de aproximacion inicial al nodo objetivo con costo optimo:
		
		if(getHint() != null){
			objetivo = getHint();
		} else {
			objetivo = null;
		}
		
		ejecucion.nodosEnFrontera = 0;
		ejecucion.nodosExpandidos = 0;
		
		veces = 1;
		t0 = System.currentTimeMillis();
		
		do  {
			
			//Busco entre los nodos de la frontera un nodo con la minima f, lo saco y lo expando:
			
			minimo = frontera.remove();
			nodos = expansor.expandNode(minimo, problema);
			ejecucion.nodosExpandidos++;
			
			for(NodeWrapper nodo : nodos){
				
				//La funcion f es la suma del costo del nodo inicial a este nodo,
				//conocido como g, y el costo estimado de una solucion optima desde
				//este nodo a un nodo objetivo, conocido como h:
				
				f = nodo.getNode().getPathCost() + problema.getHeuristicFunction().getHeuristicValue(nodo.getNode().getState());
				nodo.setCost(f);
				
				if(debugging){
					
					pantalla = (tetris.Pantalla) nodo.getNode().getState();
					piezas = pantalla.getPiezas().length;
					costo = piezas * 80 - (int) nodo.getCost();
					if(pantalla.getPiezas().length-pantalla.getIndice() == 0)System.out.print(costo + "(SI), ");
					if(pantalla.getPiezas().length-pantalla.getIndice() != 0)System.out.print(costo + "(NO), ");
					//System.out.print(pantalla);
				}
				
				if(!problema.isGoalState(nodo.getNode().getState())){
					
					//Si un nodo ya tiene una f mayor al nodo objetivo no lo expandire nunca:
					
					if(objetivo == null || f < objetivo.getCost()) frontera.add(nodo);
				
				} else {
				
					//Si un nodo es objetivo obviamente tampoco lo voy a expandir. De
					//encontrar un nodo objetivo de f minima al anterior, me lo quedo:
				
					if(objetivo == null || f < objetivo.getCost()){
						objetivo = nodo;
						veces++;
						if (getHint() != null) System.out.print("Ultimo mejor resultado: " +
						((((tetris.Pantalla) nodo.getNode().getState()).getPiezas().length * 80) - objetivo.getNode().getPathCost()) + "\n");
					}
				}
			}
			
			//Si bien nunca se ponen en la frontera nodos que ya no pueden ser expandidos por
			//tener una f mayor al objetivo hallado hasta el momento, puede ocurrir que
			//ante un nuevo objetivo algunos nodos en la frontera pasen ahora si a tener una f
			//mayor y ya no puedan ser expandidos, ocupando memoria innecesariamente. Por eso,
			//conviene sacarlos cada una determinada cantidad de veces que se halla un nuevo objetivo.
			
			if(veces > limite){
				
				temp = new PriorityQueue<NodeWrapper>();
				
				for(NodeWrapper nodo : frontera)
					if(nodo.getCost() < objetivo.getCost())
						temp.add(nodo);
				
				frontera = temp;
				veces = 1;
			}
			
			if(frontera.size() > ejecucion.nodosEnFrontera) ejecucion.nodosEnFrontera = frontera.size();

			//Si llegue a un nodo objetivo cuya f es menor que la de todos los
			//nodos en la frontera, entonces encontre uno de costo optimo y termino:
			
			if(debugging){
				
				if(frontera.peek() != null){
					pantalla = (tetris.Pantalla) frontera.peek().getNode().getState();
					piezas = pantalla.getPiezas().length;
					costo = piezas * 80 - (int) frontera.peek().getCost();
					//System.out.print("\n" + pantalla);
					if(pantalla.getPiezas().length-pantalla.getIndice() == 0)System.out.print("\nActual: " + costo + "(SI)\n");
					if(pantalla.getPiezas().length-pantalla.getIndice() != 0)System.out.print("\nActual:" + costo + "(NO)\n");
				}
			
				if(objetivo != null){
					pantalla = (tetris.Pantalla) objetivo.getNode().getState();
					piezas = 200;
					costo = piezas * 80 - (int) objetivo.getCost();
					//System.out.print("\n" + pantalla);
					System.out.print("\nObjetivo: " + costo + "(SI)\n");
				}
			}
			
		} while (objetivo == null || !(frontera.isEmpty() || objetivo.getCost() < frontera.peek().getCost()));
		
		t = System.currentTimeMillis();
		
		ejecucion.tiempo = ((double)(t - t0))/1000;
		ejecucion.resultado = objetivo;
		
		return ejecucion;
	}

	public NodeWrapper getHint() {
		return hint;
	}

	public void setHint(NodeWrapper hint) {
		this.hint = hint;
	}
}
