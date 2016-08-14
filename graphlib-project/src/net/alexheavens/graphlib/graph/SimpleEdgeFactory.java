package net.alexheavens.graphlib.graph;

public class SimpleEdgeFactory<DataClass> implements EdgeFactory<DataClass> {

	public AbstractEdge<DataClass> generate(AbstractGraph<DataClass> graph, AbstractNode<DataClass> fromNode,
			AbstractNode<DataClass> toNode) {

		return new SimpleEdge<>(graph, fromNode, toNode);
	}
	
	@Override
	public AbstractEdge<DataClass> generate(final AbstractEdgeFactoryParameterSet<DataClass> generateParameters){
		
		final AbstractGraph<DataClass> graph = generateParameters.getGraph();
		final AbstractNode<DataClass> fromNode = generateParameters.getFromNode();
		final AbstractNode<DataClass> toNode = generateParameters.getToNode();
		
		return new SimpleEdge<>(graph, fromNode, toNode);
	}

}
