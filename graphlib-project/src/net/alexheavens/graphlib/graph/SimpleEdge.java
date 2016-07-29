package net.alexheavens.graphlib.graph;

public class SimpleEdge<DataClass> extends AbstractEdge<DataClass> {

	public SimpleEdge(AbstractGraph<DataClass> graph, AbstractNode<DataClass> fromNode, AbstractNode<DataClass> toNode) {
		super(graph, fromNode, toNode);
	}

}
