package net.alexheavens.graphlib.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.alexheavens.graphlib.adt.pair.SimplePair;

/**
 * Undirected graph containing an associated data object at each node.
 * 
 * @author Alexander Heavens
 *
 * @param <DataClass>
 *            Datatype stored at each node in the graph.
 */
public abstract class AbstractGraph<DataClass>
		implements Graph<AbstractNode<DataClass>, AbstractEdge<DataClass>, DataClass> {

	private final NodeBuilder<DataClass> nodeBuilder;
	private final EdgeBuilder<DataClass> edgeBuilder;

	private final Set<AbstractNode<DataClass>> nodeSet;
	private final Set<AbstractEdge<DataClass>> edgeSet;
	private final Map<SimplePair<AbstractNode<DataClass>, AbstractEdge<DataClass>>, AbstractNode<DataClass>> nodeMap;
	private final Map<SimplePair<AbstractNode<DataClass>, AbstractNode<DataClass>>, AbstractEdge<DataClass>> edgeMap;
	private final Map<AbstractNode<DataClass>, Set<AbstractEdge<DataClass>>> fromEdgeMap;
	
	/**
	 * 
	 * @param nodeBuilder
	 * @param edgeBuilder
	 */
	public AbstractGraph(NodeBuilder<DataClass> nodeBuilder, EdgeBuilder<DataClass> edgeBuilder) {

		if (nodeBuilder == null)
			throw new NullPointerException("nodeBuilder");
		if (edgeBuilder == null)
			throw new NullPointerException("edgeBuilder");

		this.nodeBuilder = nodeBuilder;
		this.edgeBuilder = edgeBuilder;

		this.nodeSet = new HashSet<>();
		this.edgeSet = new HashSet<>();
		this.nodeMap = new HashMap<>();
		this.edgeMap = new HashMap<>();
		this.fromEdgeMap = new HashMap<>();
	}

	@Override
	public Set<AbstractNode<DataClass>> getNodeSet() {
		return new HashSet<>(nodeSet);
	}

	@Override
	public int getNodeCount() {
		return nodeSet.size();
	}

	@Override
	public Set<AbstractEdge<DataClass>> getEdgeSet() {
		return new HashSet<>(edgeSet);
	}

	@Override
	public Set<AbstractEdge<DataClass>> getEdgeSet(final AbstractNode<DataClass> fromNode) {
		if (!nodeSet.contains(fromNode)) {
			throw new IllegalArgumentException("Invalid fromNode, does not exist in graph.");
		}
		return new HashSet<>(fromEdgeMap.get(fromNode));
	}

	@Override
	public int getEdgeCount() {
		return edgeSet.size();
	}

	@Override
	public int getEdgeCount(AbstractNode<DataClass> node) {
		return fromEdgeMap.get(node).size();
	}

	@Override
	public AbstractNode<DataClass> getNode(final AbstractEdge<DataClass> edge, final AbstractNode<DataClass> toNode) {
		if (!edgeSet.contains(edge)) {
			throw new IllegalArgumentException("Invalid edge, does not exist in graph.");
		}
		if (!nodeSet.contains(toNode)) {
			throw new IllegalArgumentException("Invalid toNode, does not exist in graph.");
		}
		final SimplePair<AbstractNode<DataClass>, AbstractEdge<DataClass>> nodeEdgePair = new SimplePair<>(
				toNode, edge);
		return nodeMap.get(nodeEdgePair);
	}

	@Override
	public AbstractEdge<DataClass> getEdge(final AbstractNode<DataClass> fromNode,
			final AbstractNode<DataClass> toNode) {
		if (!nodeSet.contains(fromNode)) {
			throw new IllegalArgumentException("Invalid fromNode, does not exist in graph.");
		}
		if (!nodeSet.contains(toNode)) {
			throw new IllegalArgumentException("Invalid toNode, does not exist in graph.");
		}
		final SimplePair<AbstractNode<DataClass>, AbstractNode<DataClass>> nodePair = new SimplePair<>(
				fromNode, toNode);
		return edgeMap.get(nodePair);
	}

	@Override
	public AbstractEdge<DataClass> addEdge(final AbstractNode<DataClass> fromNode,
			final AbstractNode<DataClass> toNode) {

		final AbstractEdge<DataClass> newEdge = edgeBuilder.buildEdge(this, fromNode, toNode);

		final SimplePair<AbstractNode<DataClass>, AbstractNode<DataClass>> nodePair = new SimplePair<>(
				fromNode, toNode);
		final SimplePair<AbstractNode<DataClass>, AbstractEdge<DataClass>> nodeEdgePair = new SimplePair<>(
				toNode, newEdge);

		// Add node to all relevant data structures.
		edgeSet.add(newEdge);
		edgeMap.put(nodePair, newEdge);
		nodeMap.put(nodeEdgePair, fromNode);
		fromEdgeMap.get(fromNode).add(newEdge);

		return newEdge;
	}

	@Override
	public AbstractNode<DataClass> addNode(final DataClass data) {

		final AbstractNode<DataClass> newNode = nodeBuilder.buildNode(this, data);

		// Add edge to all relevant data structure.
		nodeSet.add(newNode);
		fromEdgeMap.put(newNode, new HashSet<AbstractEdge<DataClass>>());

		return newNode;
	}

	@Override
	public void removeEdge(AbstractEdge<DataClass> edge) {
		assert(false); // TODO implement
	}

}
