package net.alexheavens.graphlib.test.adt;

import static org.junit.Assert.*;

import org.junit.Test;

import net.alexheavens.graphlib.adt.pair.AbstractPair;
import net.alexheavens.graphlib.adt.pair.SimplePair;

public class AbstractPairTest {

	@Test
	public void testNew() {

		final Integer expFirstItem = 47;
		final Boolean expSecondItem = false;

		SimplePair<Integer, Boolean> testPair = new SimplePair<Integer, Boolean>(expFirstItem, expSecondItem);

		final Integer actFirstItem = testPair.getFirstItem();
		final Boolean actSecondItem = testPair.getSecondItem();

		assertEquals(expFirstItem, actFirstItem);
		assertEquals(expSecondItem, actSecondItem);

	}

	@Test
	public void testEquals() {

		final AbstractPair<Double, Boolean> pairA = new SimplePair<>(34.555, false);
		final AbstractPair<Double, Boolean> pairB = new SimplePair<>(34.555, false);
		final AbstractPair<Double, Boolean> pairC = new SimplePair<>(34.554, false);
		final AbstractPair<Double, Boolean> pairD = new SimplePair<>(34.555, true);
		final AbstractPair<Double, Double> pairE = new SimplePair<>(34.555, 34d);
		final AbstractPair<Double, Double> pairF = new SimplePair<>(234234534.34534, 34.555);

		assertEquals(pairA, pairA);

		assertEquals(pairA, pairB);
		assertNotEquals(pairA, pairC);
		assertNotEquals(pairA, pairD);
		assertNotEquals(pairA, pairE);
		assertNotEquals(pairA, pairF);

		assertEquals(pairB, pairA);
		assertNotEquals(pairC, pairA);
		assertNotEquals(pairD, pairA);
		assertNotEquals(pairE, pairA);
		assertNotEquals(pairF, pairA);

	}

}
