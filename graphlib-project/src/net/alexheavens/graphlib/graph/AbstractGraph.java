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
public abstract class AbstractGraph<NodeClass extends Node<NodeClass, EdgeClass, GraphClass>, EdgeClass extends Edge<NodeClass,EdgeClass,GraphClass>,GraphClass extends Graph<NodeClass,EdgeClass,GraphClass>>
		implements Graph<NodeClass, EdgeClass, GraphClass> {

	private final AbstractNodeFactory<NodeClass,EdgeClass,GraphClass, AbstractNodeFactoryParameterSet<NodeClass,EdgeClass,GraphClass>> nodeFactory;
	private final EdgeFactory<NodeClass,EdgeClass> edgeFactory;

	private final Set<NodeClass> nodeSet;
	private final Set<EdgeClass> edgeSet;
	private final Map<SimplePair<NodeClass, EdgeClass>, NodeClass> nodeMap;
	private final Map<SimplePair<NodeClass, NodeClass>, EdgeClass> edgeMap;
	private final Map<NodeClass, Set<EdgeClass>> fromEdgeMap;

	/**
	 * 
	 * @param nodeFactory
	 *            Factory to produce consumer-specific Nodes on behalf of the
	 *            Graph.
	 * @param edgeFactory
	 */
	public AbstractGraph(AbstractNodeFactory<NodeClass,EdgeClass,GraphClass, AbstractNodeFactoryParameterSet<NodeClass,EdgeClass,GraphClass>> nodeFactory, EdgeFactory<NodeClass,EdgeClass> edgeFactory) {

		if (nodeFactory == null)
			throw new NullPointerException("nodeBuilder");
		if (edgeFactory == null)
			throw new NullPointerException("edgeBuilder");

		this.nodeFactory = nodeFactory;
		this.edgeFactory = edgeFactory;

		this.nodeSet = new HashSet<>();
		this.edgeSet = new HashSet<>();
		this.nodeMap = new HashMap<>();
		this.edgeMap = new HashMap<>();
		this.fromEdgeMap = new HashMap<>();
	}
	
	private GraphClass self(){
		return (GraphClass) this;
	}

	@Override
	public Set<NodeClass> getNodeSet() {
		return new HashSet<>(nodeSet);
	}

	@Override
	public int getNodeCount() {
		return nodeSet.size();
	}

	@Override
	public Set<EdgeClass> getEdgeSet() {
		return new HashSet<>(edgeSet);
	}

	@Override
	public Set<EdgeClass> getEdgeSet(final NodeClass fromNode) {
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
	public int getEdgeCount(NodeClass node) {
		return fromEdgeMap.get(node).size();
	}

	@Override
	public NodeClass getNode(final EdgeClass edge, final NodeClass toNode) {
		if (!edgeSet.contains(edge)) {
			throw new IllegalArgumentException("Invalid edge, does not exist in graph.");
		}
		if (!nodeSet.contains(toNode)) {
			throw new IllegalArgumentException("Invalid toNode, does not exist in graph.");
		}
		final SimplePair<NodeClass, EdgeClass> nodeEdgePair = new SimplePair<>(toNode,
				edge);
		return nodeMap.get(nodeEdgePair);
	}

	@Override
	public EdgeClass getEdge(final NodeClass fromNode,
			final NodeClass toNode) {
		if (!nodeSet.contains(fromNode)) {
			throw new IllegalArgumentException("Invalid fromNode, does not exist in graph.");
		}
		if (!nodeSet.contains(toNode)) {
			throw new IllegalArgumentException("Invalid toNode, does not exist in graph.");
		}
		final SimplePair<NodeClass, NodeClass> nodePair = new SimplePair<>(fromNode,
				toNode);
		return edgeMap.get(nodePair);
	}

	@Override
	public EdgeClass addEdge(final NodeClass fromNode,
			final NodeClass toNode) {

		final AbstractEdgeFactoryParameterSet<NodeClass,EdgeClass> edgeParameters = new AbstractEdgeFactoryParameterSet<>(
				fromNode, toNode);
		final EdgeClass newEdge = edgeFactory.generate(edgeParameters);

		final SimplePair<NodeClass, NodeClass> nodePair = new SimplePair<>(fromNode,
				toNode);
		final SimplePair<NodeClass, EdgeClass> nodeEdgePair = new SimplePair<>(toNode,
				newEdge);

		// Add node to all relevant data structures.
		edgeSet.add(newEdge);
		edgeMap.put(nodePair, newEdge);
		nodeMap.put(nodeEdgePair, fromNode);
		fromEdgeMap.get(fromNode).add(newEdge);

		return newEdge;
	}

	@Override
	public NodeClass addNode(final AbstractNodeFactoryParameterSet<NodeClass,EdgeClass,GraphClass> nodeGenParams) {

		final NodeClass newNode = nodeFactory.generate(nodeGenParams);

		// Add edge to all relevant data structure.
		nodeSet.add(newNode);
		fromEdgeMap.put(newNode, new HashSet<EdgeClass>());

		return newNode;
	}

	@Override
	public void removeEdge(EdgeClass edge) {
		assert (false); // TODO implement
	}

	@Override
	public boolean containsNode(NodeClass node) {
		return nodeSet.contains(node);
	}

}
