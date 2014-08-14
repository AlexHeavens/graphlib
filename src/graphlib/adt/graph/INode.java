package graphlib.adt.graph;

import graphlib.adt.IGraph;

public interface INode<N extends INode<N, E, D>, E extends IEdge<N, E, D>, D> {

	public IGraph<N, E, D> getGraph();

	public Iterable<E> getEdgeSet();

	public D getData();

}
