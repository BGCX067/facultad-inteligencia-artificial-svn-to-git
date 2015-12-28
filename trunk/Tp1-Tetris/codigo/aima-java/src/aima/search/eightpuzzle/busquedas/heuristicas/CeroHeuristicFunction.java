package busquedas.heuristicas;

import problema.EightPuzzleBoard;
import aima.basic.XYLocation;
import aima.search.framework.HeuristicFunction;

public class CeroHeuristicFunction  implements HeuristicFunction {

	public double getHeuristicValue(Object state) {
		return 0;
	}
}
