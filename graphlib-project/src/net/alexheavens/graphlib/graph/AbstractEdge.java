package net.alexheavens.graphlib.graph;

/**
 * Edge component in an undirected abstract graph.
 * 
 * @author Alexander Heavens
 *
 * @param <DataClass> Datatype stored at each node in the graph.
 */
public abstract class AbstractEdge<DataClass> implements Edge<AbstractNode<DataClass>, AbstractEdge<DataClass>, DataClass> {

	private final AbstractGraph<DataClass> graph;
	private final AbstractNode<DataClass> fromNode;
	private final AbstractNode<DataClass> toNode;

	public AbstractEdge(AbstractGraph<DataClass> graph, AbstractNode<DataClass> fromNode, AbstractNode<DataClass> toNode) {
		this.graph = graph;
		this.fromNode = fromNode;
		this.toNode = toNode;
	}

	@Override
	public AbstractGraph<DataClass> getGraph() {
		return graph;
	}

	@Override
	public AbstractNode<DataClass> getFromNode() {
		return fromNode;
	}

	@Override
	public AbstractNode<DataClass> getToNode() {
		return toNode;
	}

}
