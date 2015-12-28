/*
 * Created on Sep 8, 2004
 *
 */
package aima.search.framework;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ravi Mohan
 * 
 */

public abstract class QueueSearch extends NodeExpander {
	private static String QUEUE_SIZE = "queueSize";

	private static String MAX_QUEUE_SIZE = "maxQueueSize";

	private static String PATH_COST = "pathCost";
	private boolean debugMode;
	private String fileName;

	public void setDebugMode(boolean debugMode, String fileName) {
		this.debugMode = debugMode;
		this.fileName = fileName + ".dot";
	}

	public List<String> search(Problem problem, NodeStore fringe) {
		clearInstrumentation();
		fringe.add(new Node(problem.getInitialState()));
		setQueueSize(fringe.size());
		int i = 0;
		while (!(fringe.isEmpty())) {
			Node node = fringe.remove();
			setQueueSize(fringe.size());
			if (debugMode) {
				i = DebbugMode(i, node);
			}
			if (problem.isGoalState(node.getState())) {
				setPathCost(node.getPathCost());
				return SearchUtils.actionsFromNodes(node.getPathFromRoot());
			}
			addExpandedNodesToFringe(fringe, node, problem);
			setQueueSize(fringe.size());
		}
		return new ArrayList<String>();// Empty List indicates Failure
	}

	private int DebbugMode(int i, Node node) {
		try {

			// Ej2:
			if (node.getState() instanceof List) {
				if (node.getParent() != null) {

					int sizeList = ((List) node.getState()).size();
					System.out.println(((List) node.getState())
							.get(sizeList - 2)
							+ "_"
							+ (sizeList - 2)
							+ "->"
							+ ((List) node.getState()).get(sizeList - 1)
							+ "_"
							+ (sizeList - 1)
							+ node.getAction().replace("VALUE",
									new Integer(i).toString()) + ";");
				} else {
					System.out.println("Empty_0" + ";");

				}
			} else {
				// Ej1:

				BufferedWriter out;
				out = new BufferedWriter(new FileWriter(fileName, true));

				if (node.getState().getClass().toString().equalsIgnoreCase(
						"class problema.EightPuzzleBoard")) {
					if (node.getParent() != null) {

						out.write("\"" + node.getParent().getState().toString()
								+ "\" -> \"" + node.getState().toString()
								+ "\" [ label =\"" + node.getAction() + "\"];");
					} else {
						out.write("\"" + node.getState().toString() + "\";");
					}
					out.newLine();
					out.close();
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i++;
		return i;
	}

	@Override
	public void clearInstrumentation() {
		super.clearInstrumentation();
		metrics.set(QUEUE_SIZE, 0);
		metrics.set(MAX_QUEUE_SIZE, 0);
		metrics.set(PATH_COST, 0);
	}

	public int getQueueSize() {
		return metrics.getInt("queueSize");
	}

	public void setQueueSize(int queueSize) {

		metrics.set(QUEUE_SIZE, queueSize);
		int maxQSize = metrics.getInt(MAX_QUEUE_SIZE);
		if (queueSize > maxQSize) {
			metrics.set(MAX_QUEUE_SIZE, queueSize);
		}
	}

	public int getMaxQueueSize() {
		return metrics.getInt(MAX_QUEUE_SIZE);
	}

	public double getPathCost() {
		return metrics.getDouble(PATH_COST);
	}

	public void setPathCost(Double pathCost) {
		metrics.set(PATH_COST, pathCost);
	}

	public abstract void addExpandedNodesToFringe(NodeStore fringe, Node node,
			Problem p);
}