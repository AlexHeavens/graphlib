package net.alexheavens.graphlib.graph;

public interface Edge <NodeClass extends Node<NodeClass, EdgeClass, DataClass>, EdgeClass extends Edge<NodeClass, EdgeClass, DataClass>, DataClass>{

	public Graph<NodeClass, EdgeClass, DataClass> getGraph();

	public NodeClass getFromNode();

	public NodeClass getToNode();

}
