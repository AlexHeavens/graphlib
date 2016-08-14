package net.alexheavens.graphlib.adt.strategy;

import net.alexheavens.graphlib.adt.AbstractDataType;
import net.alexheavens.graphlib.patterns.StrategyParameters;

public abstract class AdtModificationParameters<Adt extends AbstractDataType> implements StrategyParameters {

	private final Adt inputAdt;

	public AdtModificationParameters(final Adt inputAdt) {
		this.inputAdt = inputAdt;
	}

	public Adt getInputAdt() {
		return inputAdt;
	}

}
