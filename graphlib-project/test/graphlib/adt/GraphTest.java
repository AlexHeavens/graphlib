package graphlib.adt;

import static org.junit.Assert.*;

import graphlib.adt.graph.AbstractGraph;
import graphlib.adt.graph.AbstractNode;
import graphlib.adt.graph.SimpleGraph;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Test;

public class GraphTest {

	@Test
	public void testBuildGraph() {

		final int expNodeCount = 100;
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

		// Create Nodes.
		final Map<Integer, AbstractNode<Integer>> testNodes = new HashMap<Integer, AbstractNode<Integer>>(
				expNodeCount);
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
	}

}
