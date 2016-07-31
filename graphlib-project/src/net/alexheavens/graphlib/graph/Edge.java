package net.alexheavens.graphlib.graph;

import net.alexheavens.graphlib.adt.AbstractDataType;

public interface Edge <NodeClass extends Node<NodeClass, EdgeClass, DataClass>, EdgeClass extends Edge<NodeClass, EdgeClass, DataClass>, DataClass> extends AbstractDataType{

	public Graph<NodeClass, EdgeClass, DataClass> getGraph();

	public NodeClass getFromNode();

	public NodeClass getToNode();

}
