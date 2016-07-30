package net.alexheavens.graphlib.graph;

import java.util.Set;

public interface Node<NodeClass extends Node<NodeClass, EdgeClass, DataClass>, EdgeClass extends Edge<NodeClass, EdgeClass, DataClass>, DataClass> {

	public Graph<NodeClass, EdgeClass, DataClass> getGraph();

	public Set<EdgeClass> getEdgeSet();
	
	public int getEdgeCount();

	public DataClass getData();

}
