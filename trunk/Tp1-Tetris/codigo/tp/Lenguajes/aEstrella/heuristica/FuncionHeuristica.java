package aEstrella.heuristica;

import java.util.List;

import problema.Letra;
import problema.Parametros;
import aima.search.framework.HeuristicFunction;
import aima.util.Pair;

public class FuncionHeuristica implements HeuristicFunction{

	public double getHeuristicValue(Object state) {
		List<Letra> cadena = (List<Letra>)state;
		
/* De esa maneras te queda que P'(vk|vi) = Sumatoriaj Pconf(vk|vj) * Psecu(vj|vi)
esto es la nueva probabilidad de que la letra vi esté seguida de la vk es
la sumatoria de la probalidad de que vi haya estado seguida por la letra vj
pero fue confundida por la vk.
 */
		double prob = 0;
		double probSiguVjVi = 0;
		double probConfVkVj =0;
		Letra vi = cadena.get(cadena.size()-2);
		Letra vk = cadena.get(cadena.size()-1);
		for (Letra vj : Letra.values()) {
			probSiguVjVi  = Parametros.probProximaLetra[vi.ordinal()][vj.ordinal()];
			probConfVkVj = Parametros.probConfusionLetra[vj.ordinal()][vk.ordinal()];
			prob += probConfVkVj*probSiguVjVi;
		}	
		
		return - Math.log(prob);
		//return 1/prob;
	}

}
