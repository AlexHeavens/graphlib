package net.alexheavens.graphlib.adt.factory;

import net.alexheavens.graphlib.adt.AbstractDataType;

public interface AbstractDataTypeFactory<AdtClass extends AbstractDataType, GenerateParameterSet extends AbstractDataTypeParameterSet> {

	public AdtClass generate(final GenerateParameterSet generateParameterSets);

}
