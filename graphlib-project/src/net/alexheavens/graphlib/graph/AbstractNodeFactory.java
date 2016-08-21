package net.alexheavens.graphlib.graph;

import net.alexheavens.graphlib.adt.factory.AbstractDataTypeFactory;

public interface AbstractNodeFactory<NodeClass extends Node<NodeClass, EdgeClass, GraphClass>, EdgeClass extends Edge<NodeClass,EdgeClass,GraphClass>,GraphClass extends Graph<NodeClass, EdgeClass, GraphClass>, NodeParameterClass extends AbstractNodeFactoryParameterSet<NodeClass, EdgeClass,GraphClass>>
		extends AbstractDataTypeFactory<NodeClass, NodeParameterClass> {

	public NodeClass generate(NodeParameterClass generateParameters);

}
