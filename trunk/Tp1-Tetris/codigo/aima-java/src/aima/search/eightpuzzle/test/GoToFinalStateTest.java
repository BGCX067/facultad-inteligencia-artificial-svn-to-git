package test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import problema.EightPuzzleBoard;
import problema.EightPuzzleGoal;
import problema.EightPuzzleSuccessorFunction;

import busquedas.costo.ConstantCost;
import busquedas.heuristicas.CeroHeuristicFunction;
import busquedas.heuristicas.ManhattanHeuristicFunction;
import busquedas.heuristicas.MisplacedTilleHeuristicFunction;

import aima.search.framework.GraphSearch;
import aima.search.framework.HeuristicFunction;
import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.framework.TreeSearch;
import aima.search.informed.AStarSearch;
import aima.search.informed.GreedyBestFirstSearch;
import aima.search.uninformed.BreadthFirstSearch;
import aima.search.uninformed.DepthFirstSearch;
import aima.search.uninformed.DepthLimitedSearch;
import junit.framework.TestCase;

public class GoToFinalStateTest extends TestCase {
	public EightPuzzleBoard  GetInitialState()
	{
		return new EightPuzzleBoard(new int[] { 2,8,3,1,6,4,7,0,5});
		//return new EightPuzzleBoard(new int[] { 1, 4, 2,7, 5, 8, 3, 0, 6 });
	}
	

	public void testBreadthFirstCeroHeuristic()
	{   GraphSearch gSearch = new GraphSearch();
		gSearch.setDebugMode(false, "BreadthFirst_CeroHeuristic");
		ApplySearch(new BreadthFirstSearch(gSearch),"BreadthFirst_CeroHeuristic");
	}
	
	public void testDepthFirstCeroHeuristic()
	{
		GraphSearch gSearch = new GraphSearch();
		gSearch.setDebugMode(false, "DepthFirstCeroHeuristic");
	
		ApplySearch(new DepthFirstSearch(gSearch),"DepthFirst_CeroHeuristic");
	}	
	public void testGreedyBestFirstCeroHeuristic()
	{
		GraphSearch gSearch = new GraphSearch();
		gSearch.setDebugMode(false, "GreedyBestFirst_CeroHeuristic");
			ApplySearch(new GreedyBestFirstSearch(gSearch), new CeroHeuristicFunction(),"GreedyBestFirst_CeroHeuristic");
	}
	public void testGreedyBestFirstManhattanHeuristic()
	{
		GraphSearch gSearch = new GraphSearch();
		gSearch.setDebugMode(false, "GreedyBestFirst_ManhattanHeuristic");
		ApplySearch(new GreedyBestFirstSearch(gSearch), new ManhattanHeuristicFunction(),"GreedyBestFirst_ManhattanHeuristic");
	}
	public void testGreedyBestFirstMisplacedHeuristic()
	{
		GraphSearch gSearch = new GraphSearch();
		gSearch.setDebugMode(false, "GreedyBestFirst_MisplacedHeuristic");
		ApplySearch(new GreedyBestFirstSearch(gSearch), new MisplacedTilleHeuristicFunction(),"GreedyBestFirst_MisplacedHeuristic");
	}
	
	public void testAStarFirstCeroHeuristic()
	{
		GraphSearch gSearch = new GraphSearch();
		gSearch.setDebugMode(false, "AStarFirst_CeroHeuristic");
		ApplySearch(new AStarSearch(gSearch), new CeroHeuristicFunction(),"AStarFirst_CeroHeuristic");
	}
	public void testAStarFirstManhattanHeuristic()
	{
		GraphSearch gSearch = new GraphSearch();
		gSearch.setDebugMode(false, "AStarFirst_ManhattanHeuristic");
		ApplySearch(new AStarSearch(gSearch), new ManhattanHeuristicFunction(),"AStarFirst_ManhattanHeuristic");
	}
	public void testAStarFirstMisplacedHeuristic()
	{
		GraphSearch gSearch = new GraphSearch();
		gSearch.setDebugMode(false, "AStarFirst_MisplacedHeuristic");
		ApplySearch(new AStarSearch(gSearch), new MisplacedTilleHeuristicFunction(),"AStarFirst_MisplacedHeuristic");
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
	private void ApplySearch(Search search, HeuristicFunction heuristic,String searchName) {
		System.out.println("Empezando busqueda "+ searchName);
		try {
			WriteFileBegin(searchName);

			Problem problem = new Problem(GetInitialState(),
					new EightPuzzleSuccessorFunction(),
					new EightPuzzleGoal(),heuristic);
			
			SearchAgent agent = new SearchAgent(problem, search);
			WriteFileEnd(searchName);

			//printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void ApplySearch(Search search, String searchName) {
		System.out.println("Empezando busqueda "+ searchName);
		try {
			
			WriteFileBegin(searchName);

			Problem problem = new Problem(GetInitialState(),
					new EightPuzzleSuccessorFunction(),
					new EightPuzzleGoal());
			
			SearchAgent agent = new SearchAgent(problem, search);

			WriteFileEnd(searchName);
			//printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void WriteFileEnd(String searchName) throws IOException {
		BufferedWriter out;
		out = new BufferedWriter(new FileWriter(searchName+".dot",true));
		out.write("}");
		out.close();
	}

	private void WriteFileBegin(String searchName) throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(searchName+".dot"));
		out.write("digraph "+searchName+" {");
		out.newLine();
		out.close();
	}
}
