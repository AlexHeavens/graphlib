package graphlib.adt;

import graphlib.adt.graph.AbstractNode;

public interface INodeBuilder<Data> {

	AbstractNode<Data> buildNode(AbstractGraph<Data> graph, Data nodeData);
	
}
