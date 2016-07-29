package net.alexheavens.graphlib.graph;

public interface EdgeBuilder <Data> {

	public AbstractEdge<Data> buildEdge(AbstractGraph<Data> graph, AbstractNode<Data> fromNode, AbstractNode<Data> toNode);
	
}
