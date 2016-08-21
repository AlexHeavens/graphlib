package net.alexheavens.graphlib.graph;

public class SimpleGraph<DataClass> extends AbstractGraph<SimpleNode<DataClass>, SimpleEdge<DataClass>, SimpleGraph<DataClass>> {

	private AbstractNodeFactory<SimpleNode<DataClass>,SimpleEdge<DataClass>,SimpleGraph<DataClass>, AbstractNodeFactoryParameterSet<SimpleNode<DataClass>,SimpleEdge<DataClass>,SimpleGraph<DataClass>>> newNodeFactory(){
		return new SimpleNodeFactory<>();
	}
	
	private EdgeFactory<SimpleNode<DataClass>,SimpleEdge<DataClass>> newEdgeFactory(){
		return new SimpleEdgeFactory<>();
	}
	
	public SimpleGraph() {
		this(null, null);
	}
	
	public SimpleGraph(AbstractNodeFactory<SimpleNode<DataClass>,SimpleEdge<DataClass>,SimpleGraph<DataClass>, AbstractNodeFactoryParameterSet<SimpleNode<DataClass>,SimpleEdge<DataClass>,SimpleGraph<DataClass>>> nodeFactory, EdgeFactory<SimpleNode<DataClass>,SimpleEdge<DataClass>> edgeFactory){
		super(nodeFactory,edgeFactory);
	}

}
