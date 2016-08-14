package net.alexheavens.graphlib.graph;

public class SimpleGraph<DataClass> extends AbstractGraph<DataClass> {

	public SimpleGraph() {
		super(new SimpleNodeFactory<DataClass>(), new SimpleEdgeFactory<DataClass>());
	}

}
