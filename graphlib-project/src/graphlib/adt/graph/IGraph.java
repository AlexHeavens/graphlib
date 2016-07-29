package graphlib.adt.graph;

public interface IGraph <N extends INode<N, E, D>, E extends IEdge<N, E, D>, D> {

	public Iterable<N> getNodeSet();
	
	public int getNodeCount();

	public Iterable<E> getEdgeSet();
	
	public int getEdgeCount();
	
	public int getEdgeCount(N node);
	
	public Iterable<E> getEdgeSet(N fromNode);

	public N getNode(E edge, N toNode);

	public E getEdge(N fromNode, N toNode);
	
	public N addNode(D data);
	
	public E addEdge(N fromNode, N toNode);

}
