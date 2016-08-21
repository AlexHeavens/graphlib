package net.alexheavens.graphlib.graph;

public class SimpleNode<DataClass> extends AbstractNode<SimpleNode<DataClass>, SimpleEdge<DataClass>, SimpleGraph<DataClass>> {

	private DataClass data;

	public SimpleNode(final SimpleGraph<DataClass> graph, final DataClass data) {
		super(graph);
	}

	public DataClass getData() {
		return data;
	}

	public void setData(DataClass data) {
		this.data = data;
	}

}
