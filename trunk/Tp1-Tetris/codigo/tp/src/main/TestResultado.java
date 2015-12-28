package main;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import busquedas.AEstrella;

import heuristica.HeuristicaPenalizaHuecos;
import tetris.Objetivo;
import tetris.Pantalla;
import tetris.Sucesor;
import aima.search.framework.GraphSearch;
import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.framework.TreeSearch;
import aima.search.informed.AStarSearch;
import aima.search.informed.GreedyBestFirstSearch;
import junit.framework.TestCase;

public class TestResultado extends TestCase {

	private static final char[] piezas1 =

	{ 'T', 'T', 'T', 'Z', 'O', 'S', 'S', 'T', 'O', 'S', 'O', 'L', 'S', 'L',
			'S', 'I', 'L', 'T', 'L', 'O', 'L', 'T', 'Z', 'I', 'L', 'T', 'Z',
			'I', 'I', 'T', 'I', 'Z', 'O', 'L', 'Z', 'S', 'L', 'I', 'S', 'I',
			'I', 'O', 'I', 'L', 'T', 'I', 'I', 'L', 'O', 'L', 'I', 'S', 'Z',
			'I', 'O', 'T', 'T', 'S', 'L', 'S', 'T', 'O', 'O', 'L', 'I', 'Z',
			'T', 'T', 'T', 'S', 'O', 'T', 'L', 'O', 'L', 'L', 'O', 'I', 'S',
			'T', 'Z', 'L', 'O', 'O', 'L', 'O', 'Z', 'S', 'S', 'S', 'S', 'Z',
			'Z', 'I', 'I', 'T', 'S', 'Z', 'Z', 'L', 'S', 'S', 'T', 'S', 'Z',
			'S', 'I', 'O', 'S', 'L', 'O', 'L', 'T', 'Z', 'O', 'Z', 'I', 'S',
			'T', 'S', 'S', 'I', 'S', 'T', 'Z', 'O', 'T', 'T', 'T', 'L', 'S',
			'Z', 'L', 'I', 'Z', 'Z', 'Z', 'T', 'O', 'L', 'L', 'L', 'O', 'O',
			'O', 'T', 'T', 'T', 'T', 'Z', 'Z', 'I', 'T', 'T', 'Z', 'L', 'T',
			'T', 'O', 'L', 'S', 'T', 'I', 'Z', 'L', 'S', 'L', 'T', 'O', 'T',
			'Z', 'T', 'O', 'S', 'L', 'O', 'S', 'Z', 'I', 'T', 'O', 'L', 'I',
			'S', 'O', 'O', 'L', 'O', 'T', 'O', 'I', 'I', 'I', 'L', 'T', 'O',
			'I', 'S', 'L', 'S' };

	public void testResultadoNoCambia()
	{
		try {

			Problem problem = new Problem(new Pantalla(TestResultado.piezas1),
					new Sucesor(new HeuristicaPenalizaHuecos()),
					new Objetivo(), new HeuristicaPenalizaHuecos());

			Search search = new AStarSearch(new TreeSearch());
			Pantalla ultimo = (Pantalla) new AEstrella().buscar(problem).resultado.getNode().getState();
			System.out.print(ultimo);	
			//SearchAgent agent = new SearchAgent(problem, search);
			
	//		printInstrumentation(agent.getInstrumentation()); 
		} catch (Exception e) {
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
