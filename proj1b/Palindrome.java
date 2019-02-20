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

    public boolean isPalindrome(String word, CharacterComparator cc) {
        for(int i = 0; i < word.length()/2; i++) {
            if(!cc.equalChars(word.charAt(i),word.charAt(word.length() -1 -i))){
                return false;
            }
        }
        return true;
    }
}
