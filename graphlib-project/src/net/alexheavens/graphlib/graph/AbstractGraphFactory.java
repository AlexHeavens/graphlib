package net.alexheavens.graphlib.graph;

import net.alexheavens.graphlib.adt.factory.AbstractDataTypeFactory;
import net.alexheavens.graphlib.graph.strategy.GraphModificationParameters;
import net.alexheavens.graphlib.graph.strategy.GraphModificationStrategy;

public abstract class AbstractGraphFactory<DataClass> implements AbstractDataTypeFactory<AbstractGraph<DataClass>, AbstractGraphFactoryParameters<AbstractGraph<DataClass>>> {

	final AbstractNodeFactory<DataClass> nodeFactory;
	final EdgeFactory<DataClass> edgeFactory;
	
	public AbstractGraphFactory() {
		this(new SimpleNodeFactory<DataClass>(), new SimpleEdgeFactory<DataClass>());
	}
	
	public AbstractGraphFactory(AbstractNodeFactory<DataClass> nodeFactory, EdgeFactory<DataClass> edgeFactory){
		this.nodeFactory = nodeFactory;
		this.edgeFactory = edgeFactory;
	}
	
	@Override
	public AbstractGraph<DataClass> generate(final AbstractGraphFactoryParameters<AbstractGraph<DataClass>> generateParameters){
		
		final AbstractGraph<DataClass> newGraph = generateParameters.getStartingGraph();
		final GraphModificationStrategy<AbstractGraph<DataClass>> graphSetupStrategy = generateParameters.getSetupStrategy();
		final GraphModificationParameters<AbstractGraph<DataClass>> graphSetupParameters = generateParameters.getSetupParameters();

		graphSetupStrategy.apply(graphSetupParameters);
		
		return newGraph;
		
	}
	
}
