package test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import busquedas.AEstrella;

import problema.Letra;
import problema.Objetivo;
import problema.Sucesor;
import tetris.Pantalla;
import aEstrella.costo.FuncionCosto;
import aEstrella.heuristica.FuncionHeuristica;
import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.framework.TreeSearch;
import aima.search.informed.AStarSearch;
import aima.search.informed.GreedyBestFirstSearch;
import aima.util.Pair;
import junit.framework.TestCase;

public class BuscarCadenaTest extends TestCase {
	
	public void testCadenaMasProbable()
	{
		
		ArrayList<Letra> list = new ArrayList<Letra>();
		list.add(Letra.Empty);
		Problem problem = new Problem(list,
				new Sucesor(),
				new Objetivo(),new FuncionCosto(), new FuncionHeuristica());

		Search search = new AStarSearch(new TreeSearch());
		try {
			List<Letra> ultimo = (List<Letra>) new AEstrella().buscar(problem).resultado.getNode().getState();
			System.out.print(ultimo);	
			
			SearchAgent agent = new SearchAgent(problem, search);

		printActions(agent.getActions());
		printInstrumentation(agent.getInstrumentation()); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private static void printInstrumentation(Properties properties) {
		
		Iterator keys = properties.keySet().iterator();
		
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String property = properties.getProperty(key);
			System.out.println(key + " : " + property);
		}

	}

	private static void printActions(List actions) {
		
		for (int i = 0; i < actions.size(); i++) {
			String action = (String) actions.get(i);
			System.out.println(action);
		}
	}
}
