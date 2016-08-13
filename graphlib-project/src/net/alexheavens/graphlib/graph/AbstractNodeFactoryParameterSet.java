package net.alexheavens.graphlib.graph;

import net.alexheavens.graphlib.adt.factory.AbstractDataTypeParameterSet;

public class AbstractNodeFactoryParameterSet<DataClass> implements AbstractDataTypeParameterSet {

	private final AbstractGraph<DataClass> graph;
	private final DataClass nodeData;

	public AbstractNodeFactoryParameterSet(final AbstractGraph<DataClass> graph, final DataClass nodeData) {
		if (graph == null)
			throw new NullPointerException("graph");
		if (nodeData == null)
			throw new NullPointerException("nodeData");
		this.graph = graph;
		this.nodeData = nodeData;
	}

	public AbstractGraph<DataClass> getGraph() {
		return graph;
	}

	public DataClass getNodeData() {
		return nodeData;
	}

}
