package net.alexheavens.graphlib.graph;

public class SimpleEdge<DataClass> extends AbstractEdge<SimpleNode<DataClass>,SimpleEdge<DataClass>,SimpleGraph<DataClass>> {

	public SimpleEdge(SimpleNode<DataClass> fromNode, SimpleNode<DataClass> toNode) {
		super(fromNode, toNode);
	}

}
