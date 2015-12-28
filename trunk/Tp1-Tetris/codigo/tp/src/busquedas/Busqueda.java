package busquedas;

import java.util.*;

import aima.search.framework.Problem;
import aima.search.framework.NodeWrapper;

public interface Busqueda {
	
	public static class Ejecucion {
		
		public final int maximo = 20;
		
		public NodeWrapper resultado;
		public int nodosExpandidos;
		public int nodosEnFrontera;
		public double tiempo;
		public Set<NodeWrapper> resultados;
		
		public void seleccionar(NodeWrapper nodo){
		
			Iterator<NodeWrapper> iterador;
			double minimo;
			Object[] temp;
			Random generador;
			int posicion;
			
			if(resultados == null){
				
				resultados = new HashSet<NodeWrapper>();
				resultados.add(nodo);
				
			} else {
				
				iterador = resultados.iterator();
				minimo = iterador.next().getNode().getPathCost();
				
				if(minimo > nodo.getNode().getPathCost()){
					
					resultados.clear();
					resultados.add(nodo);
					
				} else if (minimo == nodo.getNode().getPathCost()){
					
					resultados.add(nodo);
					
					if(resultados.size() > maximo){
						
						temp = resultados.toArray();
						resultados.clear();
						
						generador = new Random();
						posicion = generador.nextInt()% temp.length;
						posicion = posicion * Integer.signum(posicion);
						
						for(int i = 0; i < temp.length; i++)
							if(i != posicion) resultados.add(((NodeWrapper) temp[i]));
					}
				}
			}
		}
	}
	
	public Ejecucion buscar(Problem problema);
}
