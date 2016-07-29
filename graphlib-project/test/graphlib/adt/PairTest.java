package graphlib.adt;

import static org.junit.Assert.*;

import org.junit.Test;

public class PairTest {

	@Test
	public void testNew() {

		final Integer expFirstItem = 47;
		final Boolean expSecondItem = false;

		Pair<Integer, Boolean> testPair = new Pair<Integer, Boolean>(
				expFirstItem, expSecondItem);

		final Integer actFirstItem = testPair.getFirstItem();
		final Boolean actSecondItem = testPair.getSecondItem();

		assertEquals(expFirstItem, actFirstItem);
		assertEquals(expSecondItem, actSecondItem);

	}
	
	@Test
	public void testEquals(){

		final Pair<Double, Boolean> pairA = new Pair<>(34.555, false);
		final Pair<Double, Boolean> pairB = new Pair<>(34.555, false);
		final Pair<Double, Boolean> pairC = new Pair<>(34.554, false);
		final Pair<Double, Boolean> pairD = new Pair<>(34.555, true);
		final Pair<Double, Boolean> pairE = new Pair<>(34.555, null);
		
		assertEquals(pairA, pairB);
		assertNotEquals(pairA, pairC);
		assertNotEquals(pairA, pairD);
		assertNotEquals(pairA, pairE);
		
	}

}
