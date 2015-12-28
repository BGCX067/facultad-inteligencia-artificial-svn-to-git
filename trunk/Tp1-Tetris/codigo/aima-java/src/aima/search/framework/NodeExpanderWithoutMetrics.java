package aima.search.framework;	

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ravi Mohan
 * 
 */

public class NodeExpanderWithoutMetrics {

	public List<NodeWrapper> expandNode(Node node, Problem problem) {

		List<NodeWrapper> nodes;
		List successors;
		Successor successor;
		Node aNode;
		Double stepCost;

		nodes = new ArrayList<NodeWrapper>();

		successors = problem.getSuccessorFunction().getSuccessors(
				node.getState());

		for (int i = 0; i < successors.size(); i++) {

			successor = (Successor) successors.get(i);

			aNode = new Node(node, successor.getState());
			aNode.setAction(successor.getAction());

			stepCost = problem.getStepCostFunction().calculateStepCost(
					node.getState(), successor.getState(),
					successor.getAction());

			aNode.setStepCost(stepCost);
			aNode.addToPathCost(stepCost);

			nodes.add(new NodeWrapper(aNode));
		}

		return nodes;
	}
}