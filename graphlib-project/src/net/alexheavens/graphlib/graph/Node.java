package net.alexheavens.graphlib.graph;

import java.util.Set;

import net.alexheavens.graphlib.adt.AbstractDataType;

public interface Node<NodeClass extends Node<NodeClass, EdgeClass, GraphClass>, EdgeClass extends Edge<NodeClass,EdgeClass,GraphClass>,GraphClass extends Graph<NodeClass,EdgeClass,GraphClass>> extends AbstractDataType{

	public GraphClass getGraph();

	public Set<EdgeClass> getEdgeSet();
	
	public int getEdgeCount();

}
