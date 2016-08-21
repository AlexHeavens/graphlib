package net.alexheavens.graphlib.graph;

import net.alexheavens.graphlib.adt.factory.AbstractDataTypeParameterSet;

public class AbstractNodeFactoryParameterSet<NodeClass extends Node<NodeClass, EdgeClass, GraphClass>, EdgeClass extends Edge<NodeClass,EdgeClass,GraphClass>, GraphClass extends Graph<NodeClass, EdgeClass, GraphClass>>
		implements AbstractDataTypeParameterSet {

	private final GraphClass graph;

	public GraphClass getGraph() {
		return graph;
	}

	public AbstractNodeFactoryParameterSet(final GraphClass graph) {
		this.graph = graph;
	}

}
