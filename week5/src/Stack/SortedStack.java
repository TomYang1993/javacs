package Stack;

import java.util.Stack;

public class SortedStack<E extends Comparable<E>> {

    private Stack<E> stack;
    private Stack<E> tempStack;

    public SortedStack() {
        stack = new Stack<E>();
        tempStack = new Stack<E>();
    }

    public void push(E item) {
        while(!stack.empty() && stack.peek().compareTo(item) < 0) {
            tempStack.push(stack.pop());
        }
        stack.push(item);
        while(!tempStack.empty()){
            stack.push(tempStack.pop());
        }

    }

    public E poll() {
        return stack.pop();
    }
}
