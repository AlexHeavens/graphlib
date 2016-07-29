package graphlib.adt;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import graphlib.adt.graph.Edge;
import graphlib.adt.graph.Node;

public class Graph<T> implements IGraph<Node<T>, Edge<T>, T> {

	private final Set<Node<T>> nodeSet;
	private final Set<Edge<T>> edgeSet;
	private final Map<Pair<Node<T>, Edge<T>>, Node<T>> nodeMap;
	private final Map<Pair<Node<T>, Node<T>>, Edge<T>> edgeMap;
	private final Map<Node<T>, Set<Edge<T>>> fromEdgeMap;

	public Graph() {
		this.nodeSet = new HashSet<Node<T>>();
		this.edgeSet = new HashSet<Edge<T>>();
		this.nodeMap = new HashMap<Pair<Node<T>, Edge<T>>, Node<T>>();
		this.edgeMap = new HashMap<Pair<Node<T>, Node<T>>, Edge<T>>();
		this.fromEdgeMap = new HashMap<Node<T>, Set<Edge<T>>>();
	}

	@Override
	public Iterable<Node<T>> getNodeSet() {
		return nodeSet;
	}

	@Override
	public int getNodeCount() {
		return nodeSet.size();
	}

	@Override
	public Iterable<Edge<T>> getEdgeSet() {
		return edgeSet;
	}

	@Override
	public Iterable<Edge<T>> getEdgeSet(final Node<T> fromNode) {
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
	public int getEdgeCount(Node<T> node) {
		return fromEdgeMap.get(node).size();
	}

	@Override
	public Node<T> getNode(final Edge<T> edge, final Node<T> toNode) {
		if (!edgeSet.contains(edge)) {
			throw new IllegalArgumentException(
					"Invalid edge, does not exist in graph.");
		}
		if (!nodeSet.contains(toNode)) {
			throw new IllegalArgumentException(
					"Invalid toNode, does not exist in graph.");
		}
		Pair<Node<T>, Edge<T>> nodeEdgePair = new Pair<Node<T>, Edge<T>>(
				toNode, edge);
		return nodeMap.get(nodeEdgePair);
	}

	@Override
	public Edge<T> getEdge(final Node<T> fromNode, final Node<T> toNode) {
		if (!nodeSet.contains(fromNode)) {
			throw new IllegalArgumentException(
					"Invalid fromNode, does not exist in graph.");
		}
		if (!nodeSet.contains(toNode)) {
			throw new IllegalArgumentException(
					"Invalid toNode, does not exist in graph.");
		}
		final Pair<Node<T>, Node<T>> nodePair = new Pair<Node<T>, Node<T>>(fromNode,
				toNode);
		return edgeMap.get(nodePair);
	}

	@Override
	public Edge<T> addEdge(final Node<T> fromNode, final Node<T> toNode) {

		final Edge<T> newEdge = new Edge<T>(this, fromNode, toNode);

		final Pair<Node<T>, Node<T>> nodePair = new Pair<Node<T>, Node<T>>(
				fromNode, toNode);
		final Pair<Node<T>, Edge<T>> nodeEdgePair = new Pair<Node<T>, Edge<T>>(
				toNode, newEdge);

		// Add node to all relevant data structures.
		edgeSet.add(newEdge);
		edgeMap.put(nodePair, newEdge);
		nodeMap.put(nodeEdgePair, fromNode);
		fromEdgeMap.get(fromNode).add(newEdge);

		return newEdge;
	}

	@Override
	public Node<T> addNode(final T data) {

		final Node<T> newNode = new Node<T>(this, data);

		// Add edge to all relevant data structure.
		nodeSet.add(newNode);
		fromEdgeMap.put(newNode, new HashSet<Edge<T>>());

		return newNode;
	}

}
