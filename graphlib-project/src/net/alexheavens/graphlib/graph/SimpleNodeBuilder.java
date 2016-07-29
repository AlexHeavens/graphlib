package net.alexheavens.graphlib.graph;

public class SimpleNodeBuilder<DataClass> implements NodeBuilder<DataClass> {

	@Override
	public SimpleNode<DataClass> buildNode(AbstractGraph<DataClass> graph, DataClass nodeData) {
		return new SimpleNode<DataClass>(graph, nodeData);
	}

}
