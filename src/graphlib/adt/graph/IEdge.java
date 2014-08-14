package graphlib.adt.graph;

import graphlib.adt.IGraph;

public interface IEdge <N extends INode<N, E, D>, E extends IEdge<N, E, D>, D>{

	public IGraph<N, E, D> getGraph();

	public N getFromNode();

	public N getToNode();

}
