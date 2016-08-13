package net.alexheavens.graphlib.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import net.alexheavens.graphlib.test.adt.AbstractBidirectionalPairTest;
import net.alexheavens.graphlib.test.adt.AbstractGraphTest;
import net.alexheavens.graphlib.test.adt.AbstractNodeFactoryTest;
import net.alexheavens.graphlib.test.adt.AbstractPairTest;

@RunWith(Suite.class)
@SuiteClasses({ AbstractBidirectionalPairTest.class, AbstractGraphTest.class, AbstractNodeFactoryTest.class,
		AbstractPairTest.class })
public class AllTests {

}
