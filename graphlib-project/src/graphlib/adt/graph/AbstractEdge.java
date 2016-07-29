package graphlib.adt.graph;

/**
 * Edge component in an undirected abstract graph.
 * 
 * @author Alexander Heavens
 *
 * @param <D> Datatype stored at each node in the graph.
 */
public abstract class AbstractEdge<D> implements IEdge<AbstractNode<D>, AbstractEdge<D>, D> {

	private final AbstractGraph<D> graph;
	private final AbstractNode<D> fromNode;
	private final AbstractNode<D> toNode;

	public AbstractEdge(AbstractGraph<D> graph, AbstractNode<D> fromNode, AbstractNode<D> toNode) {
		this.graph = graph;
		this.fromNode = fromNode;
		this.toNode = toNode;
	}

	@Override
	public AbstractGraph<D> getGraph() {
		return graph;
	}

	@Override
	public AbstractNode<D> getFromNode() {
		return fromNode;
	}

	@Override
	public AbstractNode<D> getToNode() {
		return toNode;
	}

}
