package graphlib.adt;

import graphlib.adt.graph.AbstractNode;

public class SimpleNode<Data> extends AbstractNode<Data> {

	public SimpleNode(AbstractGraph<Data> graph, Data data) {
		super(graph, data);
	}

}
