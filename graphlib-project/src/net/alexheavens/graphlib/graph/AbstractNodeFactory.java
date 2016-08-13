package net.alexheavens.graphlib.graph;

import net.alexheavens.graphlib.adt.factory.AbstractDataTypeFactory;

public interface AbstractNodeFactory<DataClass>
		extends AbstractDataTypeFactory<AbstractNode<DataClass>, AbstractNodeFactoryParameterSet<DataClass>> {

	public AbstractNode<DataClass> generate(AbstractNodeFactoryParameterSet<DataClass> generateParameters);

}
