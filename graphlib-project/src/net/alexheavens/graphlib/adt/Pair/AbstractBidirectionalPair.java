package net.alexheavens.graphlib.adt.Pair;

import java.util.Objects;

public abstract class AbstractBidirectionalPair<DataClass> extends AbstractPair<DataClass, DataClass> {

	public AbstractBidirectionalPair(final DataClass firstItem, final DataClass secondItem) {
		super(firstItem, secondItem);
	}

	@Override
	public boolean equals(final Object a) {
		boolean isEqual;
		if (a instanceof AbstractPair<?, ?>) {
			final AbstractPair<?, ?> aPair = (AbstractPair<?, ?>) a;

			final Object aPairFirstItem = aPair.getFirstItem();
			final Object aPairSecondItem = aPair.getSecondItem();

			final DataClass currentFirstItem = getFirstItem();
			final DataClass currentSecondItem = getSecondItem();

			isEqual = Objects.equals(aPairFirstItem, currentFirstItem)
					&& Objects.equals(aPairSecondItem, currentSecondItem);

			if (!isEqual) {
				isEqual = Objects.equals(aPairFirstItem, currentSecondItem)
						&& Objects.equals(aPairSecondItem, currentFirstItem);
			}

		} else {
			isEqual = false;
		}
		return isEqual;
	}

}
