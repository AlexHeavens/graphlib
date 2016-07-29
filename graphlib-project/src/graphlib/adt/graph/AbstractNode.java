package graphlib.adt.graph;

import graphlib.adt.AbstractGraph;

/**
 * Node component of an abstract graph.
 * 
 * @author Alexander Heavens
 *
 * @param <D> Datatype stored at each node in the graph.
 */
public abstract class AbstractNode<D> implements INode<AbstractNode<D>, AbstractEdge<D>, D> {

	private final AbstractGraph<D> graph;
	private final D data;

	public AbstractNode(final AbstractGraph<D> graph, final D data) {
		this.graph = graph;
		this.data = data;
	}

	@Override
	public AbstractGraph<D> getGraph() {
		return graph;
	}

	@Override
	public Iterable<AbstractEdge<D>> getEdgeSet() {
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
