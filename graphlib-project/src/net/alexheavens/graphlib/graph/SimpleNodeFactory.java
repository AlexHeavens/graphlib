package net.alexheavens.graphlib.graph;

public class SimpleNodeFactory<DataClass> implements AbstractNodeFactory<DataClass> {

	public SimpleNode<DataClass> generate(final AbstractGraph<DataClass> graph, final DataClass nodeData) {
		return new SimpleNode<DataClass>(graph, nodeData);
	}

	@Override
	public AbstractNode<DataClass> generate(final AbstractNodeFactoryParameterSet<DataClass> generateParameterSets) {

		final DataClass nodeData = generateParameterSets.getNodeData();
		final AbstractGraph<DataClass> graph = generateParameterSets.getGraph();

		return generate(graph, nodeData);

	}

}
