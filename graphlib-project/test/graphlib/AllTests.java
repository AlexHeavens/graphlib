package graphlib;

import graphlib.adt.AbstractGraphTest;
import graphlib.adt.PairTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PairTest.class, AbstractGraphTest.class })
public class AllTests {

}
