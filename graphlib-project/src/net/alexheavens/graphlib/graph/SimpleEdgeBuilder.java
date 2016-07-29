package net.alexheavens.graphlib.graph;

public class SimpleEdgeBuilder<DataClass> implements EdgeBuilder<DataClass> {

	@Override
	public AbstractEdge<DataClass> buildEdge(AbstractGraph<DataClass> graph, AbstractNode<DataClass> fromNode,
			AbstractNode<DataClass> toNode) {

		return new SimpleEdge<>(graph, fromNode, toNode);
	}

}
