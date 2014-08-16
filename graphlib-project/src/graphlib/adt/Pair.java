package graphlib.adt;

import com.sun.org.apache.xalan.internal.utils.Objects;

public class Pair<A, B> implements IPair<A, B> {

	private final A firstItem;
	private final B secondItem;

	public Pair(final A firstItem, final B secondItem) {
		this.firstItem = firstItem;
		this.secondItem = secondItem;
	}

	@Override
	public A getFirstItem() {
		return firstItem;
	}

	@Override
	public B getSecondItem() {
		return secondItem;
	}

	@Override
	public boolean equals(final Object a) {
		boolean isEqual;
		if (a instanceof Pair<?, ?>) {
			final Pair<?, ?> aPair = (Pair<?, ?>) a;
			isEqual = Objects.equals(aPair.firstItem, firstItem)
					&& Objects.equals(aPair.secondItem, secondItem);
		} else {
			isEqual = false;
		}
		return isEqual;
	}

}
