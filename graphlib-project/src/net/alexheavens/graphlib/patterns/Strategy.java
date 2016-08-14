package net.alexheavens.graphlib.patterns;

public interface Strategy <ParameterClass extends StrategyParameters> {
	
	public void apply(ParameterClass parameters);

}
