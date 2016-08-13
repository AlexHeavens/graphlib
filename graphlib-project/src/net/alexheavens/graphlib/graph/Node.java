package net.alexheavens.graphlib.graph;

import java.util.Set;

import net.alexheavens.graphlib.adt.AbstractDataType;

public interface Node<NodeClass extends Node<NodeClass, EdgeClass, DataClass>, EdgeClass extends Edge<NodeClass, EdgeClass, DataClass>, DataClass> extends AbstractDataType{

	public Graph<NodeClass, EdgeClass, DataClass> getGraph();

	public Set<EdgeClass> getEdgeSet();
	
	public int getEdgeCount();

	public DataClass getData();

}
