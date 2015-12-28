package problema;

import java.util.ArrayList;
import java.util.List;

import aEstrella.heuristica.FuncionHeuristica;
import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;
import aima.util.Pair;

public class Sucesor implements SuccessorFunction {

	public List<Successor> getSuccessors(Object state) {
		List<Successor> sucesores= new ArrayList<Successor>();
		List<Letra> cadena = (List<Letra>)state;
		
		for (Letra letraReal :Letra.values()) {
			/*for (Letra letraInterpretada: Letra.values()) {
				nuevoEstado(sucesores, cadena, letraReal, letraInterpretada);
			}*/	
			nuevoEstado(sucesores, cadena, letraReal);
		}
		return sucesores;
	}

	private void nuevoEstado(List<Successor> sucesores, List<Pair<Letra,Letra>> cadena, Letra letraReal, Letra letraInterpretada) {
		List<Pair<Letra,Letra>> nuevaCadena = new ArrayList<Pair<Letra,Letra>>(cadena);
		Letra letraAnterior = nuevaCadena.get(nuevaCadena.size()-1).getFirst();
		nuevaCadena.set(nuevaCadena.size()-1, new Pair<Letra,Letra>(letraAnterior,letraInterpretada)); 
		
		nuevaCadena.add(new Pair<Letra, Letra>(letraReal, null));
		sucesores.add(new Successor("agrego letra "+letraReal + " e interpreto a "+letraAnterior+" como " + letraInterpretada+ " y su peso es"+ new FuncionHeuristica().getHeuristicValue(nuevaCadena),nuevaCadena));
	}
	private void nuevoEstado(List<Successor> sucesores, List<Letra> cadena, Letra letraReal) {
		List<Letra> nuevaCadena = new ArrayList<Letra>(cadena);
		
		nuevaCadena.add(letraReal);
		sucesores.add(new Successor(" [ label = \""+ new FuncionHeuristica().getHeuristicValue(nuevaCadena)+" visita nro VALUE \" ]",nuevaCadena));
	}

}
