package net.alexheavens.graphlib.adt;

import java.util.Objects;

public class SimplePair<ClassA, ClassB> implements Pair<ClassA, ClassB> {

	private final ClassA firstItem;
	private final ClassB secondItem;

	public SimplePair(final ClassA firstItem, final ClassB secondItem) {
		this.firstItem = firstItem;
		this.secondItem = secondItem;
	}

	@Override
	public ClassA getFirstItem() {
		return firstItem;
	}

	@Override
	public ClassB getSecondItem() {
		return secondItem;
	}

	@Override
	public boolean equals(final Object a) {
		boolean isEqual;
		if (a instanceof SimplePair<?, ?>) {
			final SimplePair<?, ?> aPair = (SimplePair<?, ?>) a;
			isEqual = Objects.equals(aPair.firstItem, firstItem)
					&& Objects.equals(aPair.secondItem, secondItem);
		} else {
			isEqual = false;
		}
		return isEqual;
	}

}
