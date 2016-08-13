package net.alexheavens.graphlib.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Node component of an abstract graph.
 * 
 * @author Alexander Heavens
 *
 * @param <DataClass>
 *            Datatype stored at each node in the graph.
 */
public abstract class AbstractNode<DataClass>
		implements Node<AbstractNode<DataClass>, AbstractEdge<DataClass>, DataClass> {

	private final AbstractGraph<DataClass> graph;
	private final DataClass data;

	public AbstractNode(final AbstractGraph<DataClass> graph, final DataClass data) {
		this.graph = graph;
		this.data = data;
	}

	private boolean isAttached() {
		return graph.containsNode(this);
	}

	@Override
	public AbstractGraph<DataClass> getGraph() {
		return graph;
	}

	@Override
	public Set<AbstractEdge<DataClass>> getEdgeSet() {

		final Set<AbstractEdge<DataClass>> edgeSet;
		if (isAttached()) {
			edgeSet = graph.getEdgeSet();
		} else {
			edgeSet = new HashSet<>(0);
		}

		return edgeSet;

	}

	@Override
	public DataClass getData() {
		return data;
	}

	@Override
	public int getEdgeCount() {

		final int edgeCount;
		if (isAttached()) {
			edgeCount = graph.getEdgeCount();
		} else {
			edgeCount = 0;
		}

		return edgeCount;

	}

}
