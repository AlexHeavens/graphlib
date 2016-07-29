package graphlib.adt.graph;

public interface IEdge <N extends INode<N, E, D>, E extends IEdge<N, E, D>, D>{

	public IGraph<N, E, D> getGraph();

	public N getFromNode();

	public N getToNode();

}
