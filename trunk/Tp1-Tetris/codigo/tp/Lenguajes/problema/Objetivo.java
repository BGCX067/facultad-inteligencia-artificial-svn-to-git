package problema;

import java.util.List;

import aima.search.framework.GoalTest;

public class Objetivo implements GoalTest {

	public boolean isGoalState(Object state) {
		return ((List<Letra>)state).size() == Parametros.longitud_cadena;
	}

}
