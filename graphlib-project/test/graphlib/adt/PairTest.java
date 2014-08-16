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

}
