package graphlib.adt.graph;

public interface IEdgeBuilder <Data> {

	public AbstractEdge<Data> buildEdge(AbstractGraph<Data> graph, AbstractNode<Data> fromNode, AbstractNode<Data> toNode);
	
}
