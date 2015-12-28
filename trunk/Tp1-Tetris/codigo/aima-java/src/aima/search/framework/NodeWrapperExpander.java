package aima.search.framework;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ravi Mohan
 * 
 */

public class NodeWrapperExpander {

	public List<NodeWrapper> expandNode(NodeWrapper node, Problem problem) {

		List<NodeWrapper> nodes;
		List successors;
		Successor successor;
		Node aNode;
		Double stepCost;

		nodes = new ArrayList<NodeWrapper>();

		successors = problem.getSuccessorFunction().getSuccessors(
				node.getNode().getState());

		for (int i = 0; i < successors.size(); i++) {

			successor = (Successor) successors.get(i);

			aNode = new Node(node.getNode(), successor.getState());
			aNode.setAction(successor.getAction());

			stepCost = problem.getStepCostFunction().calculateStepCost(
					node.getNode().getState(), successor.getState(),
					successor.getAction());

			aNode.setStepCost(stepCost);
			aNode.addToPathCost(stepCost);

			nodes.add(new NodeWrapper(aNode));
		}

		return nodes;
	}
}