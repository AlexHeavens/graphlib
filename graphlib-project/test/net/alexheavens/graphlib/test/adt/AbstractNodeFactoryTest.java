package net.alexheavens.graphlib.test.adt;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.Set;

import org.junit.Test;

import net.alexheavens.graphlib.graph.AbstractEdge;
import net.alexheavens.graphlib.graph.AbstractGraph;
import net.alexheavens.graphlib.graph.AbstractNode;
import net.alexheavens.graphlib.graph.AbstractNodeFactory;
import net.alexheavens.graphlib.graph.AbstractNodeFactoryParameterSet;
import net.alexheavens.graphlib.graph.SimpleGraph;
import net.alexheavens.graphlib.graph.SimpleNodeFactory;

public class AbstractNodeFactoryTest {

	@Test
	public void testNewStandalone() {

		//// TEST INPUTS
		final long randomSeed = 2349785765l;
		final Random testRandom = new Random(randomSeed);
		final int testNodeCount = 100;
		final AbstractGraph<Integer> testGraph = new SimpleGraph<>();
		final AbstractNodeFactory<Integer> testNodeFactory = new SimpleNodeFactory<>();

		//// INIT TEST NODE DATA
		final Integer[] testData = new Integer[testNodeCount];
		for (int i = 0; i < testNodeCount; i++) {
			testData[i] = testRandom.nextInt();
		}

		final AbstractNode<?>[] testNodes = new AbstractNode<?>[testNodeCount];

		for (int i = 0; i < testNodeCount; i++) {

			//// NODE GEN
			final AbstractNodeFactoryParameterSet<Integer> testNodeGenParams = new AbstractNodeFactoryParameterSet<Integer>(
					testGraph, testData[i]);

			final AbstractNode<Integer> testNode = testNodeFactory.generate(testNodeGenParams);
			testNodes[i] = testNode;

			assertTrue(testData[i] == testNode.getData());
			assertTrue(testGraph == testNode.getGraph());
			assertEquals(0, testNode.getEdgeCount());
			final Set<AbstractEdge<Integer>> edgeSet = testNode.getEdgeSet();
			assertEquals(0, edgeSet.size());

			//// CHECK GRAPH STATE
			// Creating a Node outside of Graph addnode has no effect on the
			// Graph.
			assertEquals(0, testGraph.getNodeCount());
			assertEquals(0, testGraph.getEdgeCount());
			assertFalse(testGraph.containsNode(testNode));

			final Set<AbstractNode<Integer>> nodeSet = testGraph.getNodeSet();
			assertFalse(nodeSet.contains(testNode));
			assertEquals(0, nodeSet.size());
		}

	}

	@Test
	public void testGraphAddNode() {

		final long randomSeed = 345435345l;
		final Random testRandom = new Random(randomSeed);
		final int testNodeCount = 100;
		final AbstractGraph<Integer> testGraph = new SimpleGraph<>();

		//// INIT TEST NODE DATA
		final Integer[] testData = new Integer[testNodeCount];
		for (int i = 0; i < testNodeCount; i++) {
			testData[i] = testRandom.nextInt();
		}

		final AbstractNode<?>[] testNodes = new AbstractNode<?>[testNodeCount];

		for (int i = 0; i < testNodeCount; i++) {

			//// NODE GEN
			final AbstractNode<Integer> testNode = testGraph.addNode(testData[i]);
			testNodes[i] = testNode;

			assertTrue(testData[i] == testNodes[i].getData());
			assertTrue(testGraph == testNodes[i].getGraph());
			assertEquals(0, testNodes[i].getEdgeCount());
			final Set<AbstractEdge<Integer>> edgeSet = testNode.getEdgeSet();
			assertEquals(0, edgeSet.size());

			//// CHECK GRAPH STATE
			assertEquals(i + 1, testGraph.getNodeCount());
			assertEquals(0, testGraph.getEdgeCount());
			assertTrue(testGraph.containsNode(testNode));

			final Set<AbstractNode<Integer>> nodeSet = testGraph.getNodeSet();
			assertTrue(nodeSet.contains(testNode));
			assertEquals(i + 1, nodeSet.size());
		}

	}

	@Test
	public void testInvalidParameters() {

		final AbstractGraph<Integer> testGraph = new SimpleGraph<>();
		final int testData = 3892574;

		try {
			new AbstractNodeFactoryParameterSet<Integer>(testGraph, null);
			fail("Able to create AbstractNodeFactoryParameterSet will null nodeData.");
		} catch (NullPointerException nullException) {
			assertEquals("nodeData", nullException.getMessage());
		}

		try {
			new AbstractNodeFactoryParameterSet<Integer>(null, testData);
			fail("Able to create AbstractNodeFactoryParameterSet will null graph.");
		} catch (NullPointerException nullException) {
			assertEquals("graph", nullException.getMessage());
		}

	}

}
