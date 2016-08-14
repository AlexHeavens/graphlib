package net.alexheavens.graphlib.graph.strategy;

import net.alexheavens.graphlib.adt.strategy.AdtModificationParameters;
import net.alexheavens.graphlib.graph.Graph;

public abstract class GraphModificationParameters<GraphClass extends Graph<?, ?, ?>>
		extends AdtModificationParameters<GraphClass> {

	public GraphModificationParameters(final GraphClass inputGraph) {
		super(inputGraph);
	}

	public GraphClass getGraph() {
		return getInputAdt();
	}

}
