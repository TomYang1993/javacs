import org.junit.Test;
import static org.junit.Assert.*;

public class TestSort {

    @Test
    public void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};
        Sort.sort(input);
//        org.junit.Assert.assertArrayEquals(expected, input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testFindSmallest() {
//        String[] input = {"i", "have", "an", "egg"};
//        String expected = "an";
//        String actual = Sort.findSmallest(input);
//        org.junit.Assert.assertEquals(expected, actual);
//
//        String[] input2 = {"i", "ate", "lots", "of", "eggs"};
//        String expected2 = "ate";
//        String actual2 = Sort.findSmallest(input2);
//        org.junit.Assert.assertEquals(expected2, actual2);

        String[] input2 = {"i", "ate", "lots", "of", "eggs"};
        int expected2 = 1;
        int actual2 = Sort.findSmallest(input2, 0);
        assertEquals(expected2, actual2);
    }

}
