package net.alexheavens.graphlib.graph;

import net.alexheavens.graphlib.adt.factory.AbstractDataTypeParameterSet;

public class AbstractEdgeFactoryParameterSet<NodeClass extends Node<NodeClass,EdgeClass,?>, EdgeClass extends Edge<NodeClass,EdgeClass,?>> implements AbstractDataTypeParameterSet {
	
	private final NodeClass fromNode;
	private final NodeClass toNode;
	
	public AbstractEdgeFactoryParameterSet(final NodeClass fromNode, final NodeClass toNode){
		this.fromNode = fromNode;
		this.toNode = toNode;
	}
	
	public NodeClass getFromNode(){
		return fromNode;
	}
	
	public NodeClass getToNode(){
		return toNode;
	}
	
}
