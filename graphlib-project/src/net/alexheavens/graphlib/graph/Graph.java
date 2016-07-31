package net.alexheavens.graphlib.graph;

import java.util.Set;

import net.alexheavens.graphlib.adt.AbstractDataType;

/**
 * 
 * @author Alexander Heavens (alexander.heavens@gmail.com)
 *
 * @param <NodeClass>
 * @param <EdgeClass>
 * @param <DataClass>
 */
public interface Graph<NodeClass extends Node<NodeClass, EdgeClass, DataClass>, EdgeClass extends Edge<NodeClass, EdgeClass, DataClass>, DataClass>
		extends AbstractDataType {

	/**
	 * <p>
	 * Return a copy of the {@link java.util.Set Set} of {@link Node Nodes}
	 * across the whole Graph.
	 * </p>
	 * 
	 * @return New, full copy of the {@link java.util.Set Set} of {@link Node
	 *         Nodes} attached to the Graph.
	 */
	public Set<NodeClass> getNodeSet();

	public int getNodeCount();

	/**
	 * <p>
	 * Return a copy of the Set of {@link Edge Edges} attached to the Graph.
	 * </p>
	 * </p>
	 * 
	 * @return New, full copy of the {@link java.util.Set Set} of {@link Edge
	 *         Edges} attached to the Graph.
	 */
	public Set<EdgeClass> getEdgeSet();

	public int getEdgeCount();

	public int getEdgeCount(NodeClass node);

	/**
	 * <p>
	 * Return a copy of the Set of {@link Edge Edges} attached to a particular
	 * {@link Node Node}.
	 * </p>
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
