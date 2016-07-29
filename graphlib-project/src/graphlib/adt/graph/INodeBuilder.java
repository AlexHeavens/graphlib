package graphlib.adt.graph;

public interface INodeBuilder<Data> {

	public AbstractNode<Data> buildNode(AbstractGraph<Data> graph, Data nodeData);
	
}
