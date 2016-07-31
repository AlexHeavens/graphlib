package net.alexheavens.graphlib.adt.pair;

import net.alexheavens.graphlib.adt.AbstractDataType;

public interface Pair<ClassA, ClassB> extends AbstractDataType{

	public ClassA getFirstItem();

	public ClassB getSecondItem();

}
