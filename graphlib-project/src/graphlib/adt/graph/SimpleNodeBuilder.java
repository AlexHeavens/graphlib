package graphlib.adt.graph;

public class SimpleNodeBuilder<Data> implements INodeBuilder<Data> {

	@Override
	public SimpleNode<Data> buildNode(AbstractGraph<Data> graph, Data nodeData) {
		return new SimpleNode<Data>(graph, nodeData);
	}

}
