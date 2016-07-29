package graphlib.adt;

import graphlib.adt.graph.AbstractEdge;
import graphlib.adt.graph.AbstractNode;

public class SimpleEdge<Data> extends AbstractEdge<Data> {

	public SimpleEdge(AbstractGraph<Data> graph, AbstractNode<Data> fromNode, AbstractNode<Data> toNode) {
		super(graph, fromNode, toNode);
	}

}
