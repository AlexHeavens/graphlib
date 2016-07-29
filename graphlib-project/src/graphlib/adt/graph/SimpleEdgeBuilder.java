package graphlib.adt.graph;

public class SimpleEdgeBuilder<Data> implements IEdgeBuilder<Data> {

	@Override
	public AbstractEdge<Data> buildEdge(AbstractGraph<Data> graph, AbstractNode<Data> fromNode,
			AbstractNode<Data> toNode) {

		return new SimpleEdge<>(graph, fromNode, toNode);
	}

}
