package graphlib.adt;

public class SimpleGraph<Data> extends AbstractGraph<Data> {

	public SimpleGraph() {
		super(new SimpleNodeBuilder<Data>(), new SimpleEdgeBuilder<Data>());
	}

}
