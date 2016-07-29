package graphlib.adt.graph;

public interface INodeBuilder<Data> {

	AbstractNode<Data> buildNode(AbstractGraph<Data> graph, Data nodeData);
	
}
