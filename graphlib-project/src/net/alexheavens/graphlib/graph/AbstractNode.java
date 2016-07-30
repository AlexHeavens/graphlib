package net.alexheavens.graphlib.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Node component of an abstract graph.
 * 
 * @author Alexander Heavens
 *
 * @param <DataClass> Datatype stored at each node in the graph.
 */
public abstract class AbstractNode<DataClass> implements Node<AbstractNode<DataClass>, AbstractEdge<DataClass>, DataClass> {

	private final AbstractGraph<DataClass> graph;
	private final DataClass data;

	public AbstractNode(final AbstractGraph<DataClass> graph, final DataClass data) {
		this.graph = graph;
		this.data = data;
	}

	@Override
	public AbstractGraph<DataClass> getGraph() {
		return graph;
	}

	@Override
	public Set<AbstractEdge<DataClass>> getEdgeSet() {
		return graph.getEdgeSet(this);
	}

	@Override
	public DataClass getData() {
		return data;
	}

	@Override
	public int getEdgeCount() {
		return graph.getEdgeCount(this);
	}

}
