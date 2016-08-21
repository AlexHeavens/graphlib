package net.alexheavens.graphlib.graph;

public class SimpleNodeFactory<DataClass> implements AbstractNodeFactory<SimpleNode<DataClass>, SimpleEdge<DataClass>, SimpleGraph<DataClass>, SimpleNodeParameterSet<DataClass>> {

	public SimpleNode<DataClass> generate(final SimpleGraph<DataClass> graph, final DataClass nodeData) {
		return new SimpleNode<DataClass>(graph, nodeData);
	}

	@Override
	public SimpleNode<DataClass> generate(final SimpleNodeParameterSet<DataClass> generateParameterSets) {

		final SimpleGraph<DataClass> graph = generateParameterSets.getGraph();
		final DataClass nodeData = generateParameterSets.getNodeData();

		return generate(graph, nodeData);

	}

}
