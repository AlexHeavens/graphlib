package net.alexheavens.graphlib.graph;

public class SimpleEdgeFactory<DataClass> implements EdgeFactory<SimpleNode<DataClass>,SimpleEdge<DataClass>> {

	public SimpleEdge<DataClass> generate(SimpleNode<DataClass> fromNode,
			SimpleNode<DataClass> toNode) {

		return new SimpleEdge<>(fromNode, toNode);
	}
	
	@Override
	public SimpleEdge<DataClass> generate(final AbstractEdgeFactoryParameterSet<SimpleNode<DataClass>,SimpleEdge<DataClass>> generateParameters){
		
		final SimpleNode<DataClass> fromNode = generateParameters.getFromNode();
		final SimpleNode<DataClass> toNode = generateParameters.getToNode();
		
		return generate(fromNode, toNode);
	}

}
