package net.alexheavens.graphlib.graph;

import net.alexheavens.graphlib.adt.factory.AbstractDataTypeFactory;

public interface EdgeFactory<NodeClass extends Node<NodeClass, EdgeClass, ?>, EdgeClass extends Edge<NodeClass, EdgeClass, ?>>
		extends AbstractDataTypeFactory<EdgeClass, AbstractEdgeFactoryParameterSet<NodeClass, EdgeClass>> {

	public EdgeClass generate(AbstractEdgeFactoryParameterSet<NodeClass, EdgeClass> generateParameters);

}
