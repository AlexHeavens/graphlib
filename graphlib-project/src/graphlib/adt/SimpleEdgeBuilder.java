package graphlib.adt;

import graphlib.adt.graph.AbstractEdge;
import graphlib.adt.graph.AbstractNode;

public class SimpleEdgeBuilder<Data> implements IEdgeBuilder<Data> {

	@Override
	public AbstractEdge<Data> buildEdge(AbstractGraph<Data> graph, AbstractNode<Data> fromNode,
			AbstractNode<Data> toNode) {

		return new SimpleEdge<>(graph, fromNode, toNode);
	}

}
