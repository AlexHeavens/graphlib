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
public abstract class AbstractNode<NodeClass extends Node<NodeClass, EdgeClass, GraphClass>, EdgeClass extends Edge<NodeClass,EdgeClass,GraphClass>,GraphClass extends Graph<NodeClass,EdgeClass,GraphClass>>
		implements Node<NodeClass,EdgeClass,GraphClass> {

	private final GraphClass graph;

	private NodeClass self(){
		return (NodeClass) this;
	}
	
	public AbstractNode(final GraphClass graph) {
		this.graph = graph;
	}

	private boolean isAttached() {
		return graph.containsNode(self());
	}

	@Override
	public GraphClass getGraph() {
		return graph;
	}

	@Override
	public Set<EdgeClass> getEdgeSet() {

		final Set<EdgeClass> edgeSet;
		if (isAttached()) {
			edgeSet = graph.getEdgeSet();
		} else {
			edgeSet = new HashSet<>(0);
		}

		return edgeSet;

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
