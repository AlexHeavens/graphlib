package net.alexheavens.graphlib.graph;

import net.alexheavens.graphlib.adt.factory.AbstractDataTypeParameterSet;

public class AbstractEdgeFactoryParameterSet<DataClass> implements AbstractDataTypeParameterSet {
	
	private final AbstractNode<DataClass> fromNode;
	private final AbstractNode<DataClass> toNode;
	
	public AbstractEdgeFactoryParameterSet(final AbstractNode<DataClass> fromNode, final AbstractNode<DataClass> toNode){
		this.fromNode = fromNode;
		this.toNode = toNode;
	}

	public AbstractGraph<DataClass> getGraph(){
		return fromNode.getGraph();
	}
	
	public AbstractNode<DataClass> getFromNode(){
		return fromNode;
	}
	
	public AbstractNode<DataClass> getToNode(){
		return toNode;
	}
	
}
