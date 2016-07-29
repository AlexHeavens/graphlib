package graphlib.adt;

import graphlib.adt.graph.AbstractEdge;
import graphlib.adt.graph.AbstractNode;

public interface IEdgeBuilder <Data> {

	AbstractEdge<Data> buildEdge(AbstractGraph<Data> graph, AbstractNode<Data> fromNode, AbstractNode<Data> toNode);
	
}
