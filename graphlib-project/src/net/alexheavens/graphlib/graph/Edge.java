package net.alexheavens.graphlib.graph;

import net.alexheavens.graphlib.adt.AbstractDataType;

public interface Edge <NodeClass extends Node<NodeClass, EdgeClass, GraphClass>, EdgeClass extends Edge<NodeClass,EdgeClass,GraphClass>,GraphClass extends Graph<NodeClass,EdgeClass,GraphClass>> extends AbstractDataType{

	public GraphClass getGraph();

	public NodeClass getFromNode();

	public NodeClass getToNode();

}
