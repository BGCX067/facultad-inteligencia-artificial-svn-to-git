package aima.search.framework;


public class NodeWrapper implements Comparable {

	double cost;
	Node node;

	public NodeWrapper(Node node) {

		this.node = node;
		this.cost = -1;
	}

	public double getCost() {

		return cost;
	}

	public void setCost(double costo) {

		this.cost = costo;
	}

	public Node getNode() {

		return node;
	}

	public void setNode(Node nodo) {

		this.node = nodo;
	}

	public int compareTo(Object object) {

		return (int) (cost - ((NodeWrapper) object).cost);
	}

	@Override
	public NodeWrapper clone() {

		NodeWrapper aNode = new NodeWrapper(node);
		aNode.setCost(cost);
		return aNode;
	}
}