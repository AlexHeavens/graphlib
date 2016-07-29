package graphlib.adt.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import graphlib.adt.Pair;

/**
 * Undirected graph containing an associated data object at each node.
 * 
 * @author Alexander Heavens
 *
 * @param <T> Datatype stored at each node in the graph.
 */
public abstract class AbstractGraph<T> implements IGraph<AbstractNode<T>, AbstractEdge<T>, T> {

	private final INodeBuilder<T> nodeBuilder;
	private final IEdgeBuilder<T> edgeBuilder;
	
	private final Set<AbstractNode<T>> nodeSet;
	private final Set<AbstractEdge<T>> edgeSet;
	private final Map<Pair<AbstractNode<T>, AbstractEdge<T>>, AbstractNode<T>> nodeMap;
	private final Map<Pair<AbstractNode<T>, AbstractNode<T>>, AbstractEdge<T>> edgeMap;
	private final Map<AbstractNode<T>, Set<AbstractEdge<T>>> fromEdgeMap;

	public AbstractGraph(INodeBuilder<T> nodeBuilder, IEdgeBuilder<T> edgeBuilder) {
		this.nodeBuilder = nodeBuilder;
		this.edgeBuilder = edgeBuilder;
		
		this.nodeSet = new HashSet<AbstractNode<T>>();
		this.edgeSet = new HashSet<AbstractEdge<T>>();
		this.nodeMap = new HashMap<Pair<AbstractNode<T>, AbstractEdge<T>>, AbstractNode<T>>();
		this.edgeMap = new HashMap<Pair<AbstractNode<T>, AbstractNode<T>>, AbstractEdge<T>>();
		this.fromEdgeMap = new HashMap<AbstractNode<T>, Set<AbstractEdge<T>>>();
	}

	@Override
	public Iterable<AbstractNode<T>> getNodeSet() {
		return nodeSet;
	}

	@Override
	public int getNodeCount() {
		return nodeSet.size();
	}

	@Override
	public Iterable<AbstractEdge<T>> getEdgeSet() {
		return edgeSet;
	}

	@Override
	public Iterable<AbstractEdge<T>> getEdgeSet(final AbstractNode<T> fromNode) {
		if (!nodeSet.contains(fromNode)) {
			throw new IllegalArgumentException(
					"Invalid fromNode, does not exist in graph.");
		}
		return fromEdgeMap.get(fromNode);
	}

	@Override
	public int getEdgeCount() {
		return edgeSet.size();
	}

	@Override
	public int getEdgeCount(AbstractNode<T> node) {
		return fromEdgeMap.get(node).size();
	}

	@Override
	public AbstractNode<T> getNode(final AbstractEdge<T> edge, final AbstractNode<T> toNode) {
		if (!edgeSet.contains(edge)) {
			throw new IllegalArgumentException(
					"Invalid edge, does not exist in graph.");
		}
		if (!nodeSet.contains(toNode)) {
			throw new IllegalArgumentException(
					"Invalid toNode, does not exist in graph.");
		}
		Pair<AbstractNode<T>, AbstractEdge<T>> nodeEdgePair = new Pair<AbstractNode<T>, AbstractEdge<T>>(
				toNode, edge);
		return nodeMap.get(nodeEdgePair);
	}

	@Override
	public AbstractEdge<T> getEdge(final AbstractNode<T> fromNode, final AbstractNode<T> toNode) {
		if (!nodeSet.contains(fromNode)) {
			throw new IllegalArgumentException(
					"Invalid fromNode, does not exist in graph.");
		}
		if (!nodeSet.contains(toNode)) {
			throw new IllegalArgumentException(
					"Invalid toNode, does not exist in graph.");
		}
		final Pair<AbstractNode<T>, AbstractNode<T>> nodePair = new Pair<AbstractNode<T>, AbstractNode<T>>(fromNode,
				toNode);
		return edgeMap.get(nodePair);
	}

	@Override
	public AbstractEdge<T> addEdge(final AbstractNode<T> fromNode, final AbstractNode<T> toNode) {

		final AbstractEdge<T> newEdge = edgeBuilder.buildEdge(this, fromNode, toNode);

		final Pair<AbstractNode<T>, AbstractNode<T>> nodePair = new Pair<AbstractNode<T>, AbstractNode<T>>(
				fromNode, toNode);
		final Pair<AbstractNode<T>, AbstractEdge<T>> nodeEdgePair = new Pair<AbstractNode<T>, AbstractEdge<T>>(
				toNode, newEdge);

		// Add node to all relevant data structures.
		edgeSet.add(newEdge);
		edgeMap.put(nodePair, newEdge);
		nodeMap.put(nodeEdgePair, fromNode);
		fromEdgeMap.get(fromNode).add(newEdge);

		return newEdge;
	}

	@Override
	public AbstractNode<T> addNode(final T data) {

		final AbstractNode<T> newNode = nodeBuilder.buildNode(this, data);

		// Add edge to all relevant data structure.
		nodeSet.add(newNode);
		fromEdgeMap.put(newNode, new HashSet<AbstractEdge<T>>());

		return newNode;
	}

}
