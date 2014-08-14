package graphlib.adt.graph;

import graphlib.adt.Graph;

public class Node<D> implements INode<Node<D>, Edge<D>, D> {

	private final Graph<D> graph;
	private final D data;

	public Node(final Graph<D> graph, final D data) {
		this.graph = graph;
		this.data = data;
	}

	@Override
	public Graph<D> getGraph() {
		return graph;
	}

	@Override
	public Iterable<Edge<D>> getEdgeSet() {
		return graph.getEdgeSet(this);
	}

	@Override
	public D getData() {
		return data;
	}

}
