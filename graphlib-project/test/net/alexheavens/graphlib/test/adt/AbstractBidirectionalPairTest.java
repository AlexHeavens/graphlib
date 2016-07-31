package net.alexheavens.graphlib.test.adt;

import static org.junit.Assert.*;

import org.junit.Test;

import net.alexheavens.graphlib.adt.pair.AbstractBidirectionalPair;
import net.alexheavens.graphlib.adt.pair.SimpleBidirectionalPair;

public class AbstractBidirectionalPairTest {

	@Test
	public void testNew() {

		final Double expFirstItem = 25432152121.5451512;
		final Double expSecondItem = 4515151.451545;

		final AbstractBidirectionalPair<Double> testPair = new SimpleBidirectionalPair<Double>(expFirstItem,
				expSecondItem);

		final Double actFirstItem = testPair.getFirstItem();
		final Double actSecondItem = testPair.getSecondItem();

		assertEquals(expFirstItem, actFirstItem);
		assertEquals(expSecondItem, actSecondItem);

	}

	@Test
	public void testEquals() {

		final AbstractBidirectionalPair<Double> pairA = new SimpleBidirectionalPair<>(5146515.5212, 4534534.5434);
		final AbstractBidirectionalPair<Double> pairB = new SimpleBidirectionalPair<>(5146515.5212, 4534534.5434);
		final AbstractBidirectionalPair<Double> pairC = new SimpleBidirectionalPair<>(4534534.5434, 5146515.5212);
		final AbstractBidirectionalPair<Double> pairD = new SimpleBidirectionalPair<>(5146515.5212, 15121.51);
		final AbstractBidirectionalPair<Double> pairE = new SimpleBidirectionalPair<>(5146515d, 5146515.5212);
		final AbstractBidirectionalPair<Double> pairF = new SimpleBidirectionalPair<>(21515.1, 4534534.5434);
		final AbstractBidirectionalPair<Boolean> pairG = new SimpleBidirectionalPair<>(true, false);

		assertEquals(pairA, pairA);

		assertEquals(pairA, pairB);
		assertEquals(pairA, pairC);
		assertNotEquals(pairA, pairD);
		assertNotEquals(pairA, pairE);
		assertNotEquals(pairA, pairF);
		assertNotEquals(pairA, pairG);

		assertEquals(pairB, pairA);
		assertEquals(pairC, pairA);
		assertNotEquals(pairD, pairA);
		assertNotEquals(pairE, pairA);
		assertNotEquals(pairF, pairA);
		assertNotEquals(pairG, pairA);

	}

}
