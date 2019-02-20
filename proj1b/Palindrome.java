public class Palindrome {

    public static Deque<Character> wordToDeque(String word) {

        Deque<Character> deq = new LinkedListDeque<Character>();

        for(int i = 0;i < word.length(); i++) {
            deq.addLast(word.charAt(i));
        }

        return deq;
    }



    public static boolean isPalindrome(String word) {

        Deque<Character> deq = wordToDeque(word);

        for(int i = 0;i < word.length(); i++) {
            if(!deq.removeLast().equals(word.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
