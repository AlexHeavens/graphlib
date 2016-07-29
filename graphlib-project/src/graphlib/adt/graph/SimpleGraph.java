package graphlib.adt.graph;

public class SimpleGraph<Data> extends AbstractGraph<Data> {

	public SimpleGraph() {
		super(new SimpleNodeBuilder<Data>(), new SimpleEdgeBuilder<Data>());
	}

}
