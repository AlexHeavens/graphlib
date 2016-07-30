package net.alexheavens.graphlib.graph;

public interface Graph <NodeClass extends Node<NodeClass, EdgeClass, DataClass>, EdgeClass extends Edge<NodeClass, EdgeClass, DataClass>, DataClass> {

	public Iterable<NodeClass> getNodeSet();
	
	public int getNodeCount();

	public Iterable<EdgeClass> getEdgeSet();
	
	public int getEdgeCount();
	
	public int getEdgeCount(NodeClass node);
	
	public Iterable<EdgeClass> getEdgeSet(NodeClass fromNode);

	public NodeClass getNode(EdgeClass edge, NodeClass toNode);

	public EdgeClass getEdge(NodeClass fromNode, NodeClass toNode);
	
	public NodeClass addNode(DataClass data);
	
	public EdgeClass addEdge(NodeClass fromNode, NodeClass toNode);
	
	public void removeEdge(EdgeClass edge);

}
