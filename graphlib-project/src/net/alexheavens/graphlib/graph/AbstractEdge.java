package net.alexheavens.graphlib.graph;

/**
 * Edge component in an undirected abstract graph.
 * 
 * @author Alexander Heavens
 *
 * @param <DataClass>
 *            Datatype stored at each node in the graph.
 */
public abstract class AbstractEdge<NodeClass extends Node<NodeClass, EdgeClass, GraphClass>, EdgeClass extends Edge<NodeClass, EdgeClass, GraphClass>, GraphClass extends Graph<NodeClass, EdgeClass, GraphClass>>
		implements Edge<NodeClass, EdgeClass, GraphClass> {

	private final NodeClass fromNode;
	private final NodeClass toNode;

	public AbstractEdge(NodeClass fromNode, NodeClass toNode) {
		this.fromNode = fromNode;
		this.toNode = toNode;
	}

	@Override
	public GraphClass getGraph() {
		return fromNode.getGraph();
	}

	@Override
	public NodeClass getFromNode() {
		return fromNode;
	}

	@Override
	public NodeClass getToNode() {
		return toNode;
	}

}
