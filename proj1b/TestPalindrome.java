import org.junit.Test;

import static junit.framework.TestCase.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {

        assertFalse(palindrome.isPalindrome("catc"));
        assertTrue(palindrome.isPalindrome("caac"));
    }

    @Test
    public void testIsPalindromeEdge() {

        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));
    }

    @Test
    public void testIsPalindromeOverloading() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("ab", cc));
        assertTrue(palindrome.isPalindrome("", cc));
        assertFalse(palindrome.isPalindrome("abcba", cc));
        assertTrue(palindrome.isPalindrome("gdseh", cc));

    }
}
