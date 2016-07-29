package net.alexheavens.graphlib.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import net.alexheavens.graphlib.test.adt.AbstractGraphTest;
import net.alexheavens.graphlib.test.adt.PairTest;

@RunWith(Suite.class)
@SuiteClasses({ PairTest.class, AbstractGraphTest.class })
public class AllTests {

}
