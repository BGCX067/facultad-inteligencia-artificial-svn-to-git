package busquedas.costo;

import aima.search.framework.StepCostFunction;

public class ConstantCost implements StepCostFunction{

	public Double calculateStepCost(Object fromState, Object toState,
			String action) {
		// TODO Auto-generated method stub
		return new Double(1);
	}
}
