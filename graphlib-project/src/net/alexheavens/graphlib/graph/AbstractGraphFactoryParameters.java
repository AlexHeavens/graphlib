package net.alexheavens.graphlib.graph;

import net.alexheavens.graphlib.adt.factory.AbstractDataTypeParameterSet;
import net.alexheavens.graphlib.graph.strategy.GraphModificationParameters;
import net.alexheavens.graphlib.graph.strategy.GraphModificationStrategy;

public abstract class AbstractGraphFactoryParameters<GraphClass extends AbstractGraph<?>> implements AbstractDataTypeParameterSet{

	private final GraphClass startingGraph;
	private final GraphModificationStrategy<GraphClass> setupStrategy;
	private final GraphModificationParameters<GraphClass> setupParameters;
	
	public AbstractGraphFactoryParameters(final GraphClass startingGraph, final GraphModificationStrategy<GraphClass> setupStrategy, final GraphModificationParameters<GraphClass> setupParameters){
		this.startingGraph = startingGraph;
		this.setupStrategy = setupStrategy;
		this.setupParameters = setupParameters;
	}
	
	public GraphClass getStartingGraph(){
		return startingGraph;
	}
	
	public GraphModificationStrategy<GraphClass> getSetupStrategy(){
		return setupStrategy;
	}
	
	public GraphModificationParameters<GraphClass> getSetupParameters(){
		return setupParameters;
	}
	
}
