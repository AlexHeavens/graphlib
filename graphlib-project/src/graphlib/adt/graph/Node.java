package graphlib.adt.graph;

import graphlib.adt.Graph;

/**
 * Node component of an abstract graph.
 * 
 * @author Alexander Heavens
 *
 * @param <D> Datatype stored at each node in the graph.
 */
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

	@Override
	public int getEdgeCount() {
		return graph.getEdgeCount(this);
	}

}
