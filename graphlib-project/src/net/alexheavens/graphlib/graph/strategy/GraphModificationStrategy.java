package net.alexheavens.graphlib.graph.strategy;

import net.alexheavens.graphlib.adt.strategy.AdtModificationStrategy;
import net.alexheavens.graphlib.graph.Graph;

public abstract class GraphModificationStrategy<GraphClass extends Graph<?, ?, ?>>
		implements AdtModificationStrategy<GraphClass, GraphModificationParameters<GraphClass>> {

}
