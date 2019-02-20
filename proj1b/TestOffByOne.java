import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.

    @Test
    public void testOffByOne() {
        assertFalse(offByOne.equalChars('a','a'));
        assertTrue(offByOne.equalChars('b','a'));
        assertFalse(offByOne.equalChars('A','A'));
    }



}
