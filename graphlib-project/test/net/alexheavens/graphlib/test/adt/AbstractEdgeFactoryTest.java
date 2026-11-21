package net.alexheavens.graphlib.test.adt;

import static org.junit.Assert.*;

import org.junit.Test;

import net.alexheavens.graphlib.graph.AbstractEdge;
import net.alexheavens.graphlib.graph.AbstractEdgeFactoryParameterSet;
import net.alexheavens.graphlib.graph.AbstractGraph;
import net.alexheavens.graphlib.graph.AbstractNode;
import net.alexheavens.graphlib.graph.EdgeFactory;
import net.alexheavens.graphlib.graph.SimpleEdgeFactory;
import net.alexheavens.graphlib.graph.SimpleGraph;

public class AbstractEdgeFactoryTest {

	@Test
	public void testStandaloneEdge() {

		final AbstractGraph<Integer> testGraph = new SimpleGraph<>();
		final AbstractNode<Integer> testFromNode = testGraph.addNode(1);
		final AbstractNode<Integer> testToNode = testGraph.addNode(2);
		final EdgeFactory<Integer> testEdgeFactory = new SimpleEdgeFactory<>();

		final AbstractEdgeFactoryParameterSet<Integer> testParams = new AbstractEdgeFactoryParameterSet<>(
				testFromNode, testToNode);
		final AbstractEdge<Integer> testEdge = testEdgeFactory.generate(testParams);

		assertSame(testGraph, testEdge.getGraph());
		assertSame(testFromNode, testEdge.getFromNode());
		assertSame(testToNode, testEdge.getToNode());

		// Creating an Edge outside of Graph addEdge has no effect on the Graph.
		assertEquals(0, testGraph.getEdgeCount());
	}

}
