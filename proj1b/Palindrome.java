public class Palindrome {

    public Deque<Character> wordToDeque(String word) {

        Deque<Character> deq = new LinkedListDeque<Character>();

        for(int i = 0;i < word.length(); i++) {
            deq.addLast(word.charAt(i));
        }

        return deq;
    }

    public boolean isPalindrome() {



        return false;
    }
}
