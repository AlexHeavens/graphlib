package net.alexheavens.graphlib.graph;

import net.alexheavens.graphlib.adt.factory.AbstractDataTypeFactory;

public interface EdgeFactory<DataClass>
		extends AbstractDataTypeFactory<AbstractEdge<DataClass>, AbstractEdgeFactoryParameterSet<DataClass>> {

	public AbstractEdge<DataClass> generate(AbstractEdgeFactoryParameterSet<DataClass> generateParameters);

}
