package net.alexheavens.graphlib.adt.strategy;

import net.alexheavens.graphlib.adt.AbstractDataType;
import net.alexheavens.graphlib.patterns.Strategy;

public interface AdtModificationStrategy<DataClass extends AbstractDataType, ParameterClass extends AdtModificationParameters>
		extends Strategy<ParameterClass> {

}
