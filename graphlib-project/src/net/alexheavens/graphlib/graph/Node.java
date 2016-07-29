package net.alexheavens.graphlib.graph;

public interface Node<NodeClass extends Node<NodeClass, EdgeClass, DataClass>, EdgeClass extends Edge<NodeClass, EdgeClass, DataClass>, DataClass> {

	public Graph<NodeClass, EdgeClass, DataClass> getGraph();

	public Iterable<EdgeClass> getEdgeSet();
	
	public int getEdgeCount();

	public DataClass getData();

}