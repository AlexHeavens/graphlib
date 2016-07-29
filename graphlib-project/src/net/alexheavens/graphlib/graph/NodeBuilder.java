package net.alexheavens.graphlib.graph;

public interface NodeBuilder<DataClass> {

	public AbstractNode<DataClass> buildNode(AbstractGraph<DataClass> graph, DataClass nodeData);
	
}
