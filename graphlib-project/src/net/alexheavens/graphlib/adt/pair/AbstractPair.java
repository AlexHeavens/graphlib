package net.alexheavens.graphlib.adt.pair;

import java.util.Objects;

public class AbstractPair<ClassA, ClassB> implements Pair<ClassA, ClassB> {

	private final ClassA firstItem;
	private final ClassB secondItem;

	public AbstractPair(final ClassA firstItem, final ClassB secondItem) {
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
		if (a instanceof AbstractPair<?, ?>) {
			final AbstractPair<?, ?> aPair = (AbstractPair<?, ?>) a;
			isEqual = Objects.equals(aPair.getFirstItem(), firstItem)
					&& Objects.equals(aPair.getSecondItem(), secondItem);
		} else {
			isEqual = false;
		}
		return isEqual;
	}
	
	@Override
	public int hashCode(){
		return firstItem.hashCode() + secondItem.hashCode();
	}

}
