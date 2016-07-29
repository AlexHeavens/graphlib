package graphlib.adt.graph;

import graphlib.adt.Graph;

/**
 * Edge component in an undirected abstract graph.
 * 
 * @author Alexander Heavens
 *
 * @param <D> Datatype stored at each node in the graph.
 */
public class Edge<D> implements IEdge<Node<D>, Edge<D>, D> {

	private final Graph<D> graph;
	private final Node<D> fromNode;
	private final Node<D> toNode;

	public Edge(Graph<D> graph, Node<D> fromNode, Node<D> toNode) {
		this.graph = graph;
		this.fromNode = fromNode;
		this.toNode = toNode;
	}

	@Override
	public Graph<D> getGraph() {
		return graph;
	}

	@Override
	public Node<D> getFromNode() {
		return fromNode;
	}

	@Override
	public Node<D> getToNode() {
		return toNode;
	}

}
