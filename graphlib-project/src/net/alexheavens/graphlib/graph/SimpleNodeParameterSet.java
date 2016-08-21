package net.alexheavens.graphlib.graph;

public class SimpleNodeParameterSet<NodeDataClass> extends AbstractNodeFactoryParameterSet<SimpleNode<NodeDataClass>,SimpleEdge<NodeDataClass>,SimpleGraph<NodeDataClass>> {

	private final NodeDataClass nodeData;
	
	public SimpleNodeParameterSet(SimpleGraph<NodeDataClass> graph, NodeDataClass nodeData) {
		super(graph);
		this.nodeData = nodeData;
	}

	public NodeDataClass getNodeData() {
		return nodeData;
	}

}
