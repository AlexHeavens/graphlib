package net.alexheavens.graphlib.test.adt;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

import net.alexheavens.graphlib.adt.Pair.BidirectionalPair;
import net.alexheavens.graphlib.adt.Pair.SimpleBidirectionalPair;
import net.alexheavens.graphlib.graph.AbstractEdge;
import net.alexheavens.graphlib.graph.AbstractGraph;
import net.alexheavens.graphlib.graph.AbstractNode;
import net.alexheavens.graphlib.graph.EdgeBuilder;
import net.alexheavens.graphlib.graph.NodeBuilder;
import net.alexheavens.graphlib.graph.SimpleEdgeBuilder;
import net.alexheavens.graphlib.graph.SimpleGraph;
import net.alexheavens.graphlib.graph.SimpleNodeBuilder;

public class AbstractGraphTest {

	private AbstractGraph<Integer> generateRandomGraph(int randomSeed, int nodeCount) {

		assert (nodeCount >= 0);
		

		final Random randomGen = new Random(randomSeed);

		final AbstractGraph<Integer> testGraph = new SimpleGraph<Integer>();

		for (int i = 0; i < nodeCount; i++) {
			testGraph.addNode(randomGen.nextInt());
		}
		
		for (final AbstractNode<Integer> nodeA : testGraph.getNodeSet()){
			for (final AbstractNode<Integer> nodeB : testGraph.getNodeSet()){
			  if(nodeA != nodeB && randomGen.nextBoolean()){
				  testGraph.addEdge(nodeA, nodeB);
			  }
			}
		}
		
		return testGraph;

	}

	@Test
	public void testBuildConnectedGraph() {

		//// GRAPH CREATION
		final int expNodeCount = 4;
		final int randomSeed = 251545;
		final Random randomGen = new Random(randomSeed);

		final AbstractGraph<Integer> testGraph = new SimpleGraph<Integer>();

		// Node counts.
		assertEquals(0, testGraph.getNodeCount());
		assertEquals(0, testGraph.getEdgeCount());

		// Prime Node data with pseudo random data.
		final Integer[] expNodeData = new Integer[expNodeCount];
		for (int i = 0; i < expNodeData.length; i++) {
			expNodeData[i] = randomGen.nextInt();
		}

		//// NODE CREATION
		final Map<Integer, AbstractNode<Integer>> testNodes = new HashMap<Integer, AbstractNode<Integer>>(expNodeCount);
		for (int i = 0; i < expNodeCount; i++) {

			final AbstractNode<Integer> testNode = testGraph.addNode(expNodeData[i]);

			// Assert correct Node state as added.
			assertEquals(expNodeData[i], testNode.getData());
			assertTrue(expNodeData[i] == testNode.getData());
			assertEquals(0, testNode.getEdgeCount());

			// Assert correct Graph state as added.
			assertEquals(i + 1, testGraph.getNodeCount());
			assertEquals(0, testGraph.getEdgeCount());

			testNodes.put(i, testNode);
		}

		// Assert correct Node state once added entirely.
		for (Integer testNodeId : testNodes.keySet()) {
			final AbstractNode<Integer> testNode = testNodes.get(testNodeId);

			// Assert correct Node state as added.
			assertEquals(expNodeData[testNodeId], testNode.getData());
			assertTrue(expNodeData[testNodeId] == testNode.getData());
			assertEquals(0, testNode.getEdgeCount());
		}

		//// EDGE CREATION (STEP 1)
		// Fully connect our existing nodes.
		final Set<BidirectionalPair<AbstractNode<Integer>>> connectedNodePairSet = new HashSet<>();
		assertEquals(0, testGraph.getEdgeCount());

		for (final AbstractNode<Integer> nodeA : testGraph.getNodeSet()) {
			for (final AbstractNode<Integer> nodeB : testGraph.getNodeSet()) {
				final BidirectionalPair<AbstractNode<Integer>> nodeABPair = new SimpleBidirectionalPair<>(nodeA, nodeB);
				if (nodeA != nodeB && !connectedNodePairSet.contains(nodeABPair)) {

					final AbstractEdge<Integer> newEdge = testGraph.addEdge(nodeA, nodeB);

					assertEquals(testGraph, newEdge.getGraph());
					assertEquals(nodeA, newEdge.getFromNode());
					assertEquals(nodeB, newEdge.getToNode());

					connectedNodePairSet.add(nodeABPair);
					assertEquals(connectedNodePairSet.size(), testGraph.getEdgeCount());

				}

			}
		}

		final int totalExpectedEdgeCount = (expNodeCount - 1) * expNodeCount / 2;
		assertEquals(totalExpectedEdgeCount, testGraph.getEdgeCount());

	}

	@Test
	public void testInvalidBuilders() {

		final NodeBuilder<Integer> testNodeBuilder = new SimpleNodeBuilder<>();
		final EdgeBuilder<Integer> testEdgeBuilder = new SimpleEdgeBuilder<>();

		try {

			@SuppressWarnings("unused")
			final AbstractGraph<Integer> testGraph = new AbstractGraph<Integer>(null, testEdgeBuilder) {
			};
			fail("Able to create AbstractGraph with null nodeBuilder");

		} catch (final NullPointerException nullException) {
			assertEquals("nodeBuilder", nullException.getMessage());
		}

		try {

			@SuppressWarnings("unused")
			final AbstractGraph<Integer> testGraph = new AbstractGraph<Integer>(testNodeBuilder, null) {
			};
			fail("Able to create AbstractGraph with null edgeBuilder");

		} catch (final NullPointerException nullException) {
			assertEquals("edgeBuilder", nullException.getMessage());
		}

	}

	@Test
	public void testGetEdgeSet() {
		
		final int randomSeed = 77576578;
		final int nodeCount = 20;
		final AbstractGraph<Integer> testGraph = generateRandomGraph(randomSeed, nodeCount);
		
		// Must always get a new (but identical) Set when retrieving edges.
		final Set<AbstractEdge<Integer>> edgeSetA = testGraph.getEdgeSet();
		final Set<AbstractEdge<Integer>> edgeSetB = testGraph.getEdgeSet();
		
		assertFalse(edgeSetA == edgeSetB);
		assertEquals(edgeSetA,edgeSetB);
		
		// Difficult to do stringent edge checks with random graph.
		assertEquals(testGraph.getEdgeCount(), edgeSetA.size());
		
	}

}
