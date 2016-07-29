package net.alexheavens.graphlib.test.adt;

import static org.junit.Assert.*;

import org.junit.Test;

import net.alexheavens.graphlib.adt.SimplePair;

public class PairTest {

	@Test
	public void testNew() {

		final Integer expFirstItem = 47;
		final Boolean expSecondItem = false;

		SimplePair<Integer, Boolean> testPair = new SimplePair<Integer, Boolean>(
				expFirstItem, expSecondItem);

		final Integer actFirstItem = testPair.getFirstItem();
		final Boolean actSecondItem = testPair.getSecondItem();

		assertEquals(expFirstItem, actFirstItem);
		assertEquals(expSecondItem, actSecondItem);

	}
	
	@Test
	public void testEquals(){

		final SimplePair<Double, Boolean> pairA = new SimplePair<>(34.555, false);
		final SimplePair<Double, Boolean> pairB = new SimplePair<>(34.555, false);
		final SimplePair<Double, Boolean> pairC = new SimplePair<>(34.554, false);
		final SimplePair<Double, Boolean> pairD = new SimplePair<>(34.555, true);
		final SimplePair<Double, Boolean> pairE = new SimplePair<>(34.555, null);
		
		assertEquals(pairA, pairB);
		assertNotEquals(pairA, pairC);
		assertNotEquals(pairA, pairD);
		assertNotEquals(pairA, pairE);
		
	}

}
