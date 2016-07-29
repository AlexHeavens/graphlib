package graphlib.adt.graph;

public interface IEdgeBuilder <Data> {

	AbstractEdge<Data> buildEdge(AbstractGraph<Data> graph, AbstractNode<Data> fromNode, AbstractNode<Data> toNode);
	
}
