package net.alexheavens.graphlib.graph;

import java.util.Set;

public interface Graph<NodeClass extends Node<NodeClass, EdgeClass, DataClass>, EdgeClass extends Edge<NodeClass, EdgeClass, DataClass>, DataClass> {

	public Iterable<NodeClass> getNodeSet();

	public int getNodeCount();

	public Set<EdgeClass> getEdgeSet();

	public int getEdgeCount();

	public int getEdgeCount(NodeClass node);

	/**
	 * Return a copy of the Set of {@link Edge Edges} attached to a particular
	 * {@link Node Node}.
	 * 
	 * @param fromNode
	 *            Node from which the set of Edges is returned.
	 * @return New copy of Edges from fromNode.
	 */
	public Set<EdgeClass> getEdgeSet(NodeClass fromNode);

	public NodeClass getNode(EdgeClass edge, NodeClass toNode);

	public EdgeClass getEdge(NodeClass fromNode, NodeClass toNode);

	public NodeClass addNode(DataClass data);

	public EdgeClass addEdge(NodeClass fromNode, NodeClass toNode);

	public void removeEdge(EdgeClass edge);

}
