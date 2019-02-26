package Queue61B;

import java.util.Stack;

public class Queue<E>  {
    private Stack<E> stack = new Stack<>();

    public void push(E element) {
        stack.push(element);
    }

    public E poll() {
        E temp;
        E result;
        Stack<E> stackHolder = new Stack<>();
        while(!stack.empty()) {
            temp = stack.pop();
            stackHolder.push(temp);
        }
        result = stackHolder.pop();
        while(!stackHolder.empty()) {
            temp = stackHolder.pop();
            stack.push(temp);
        }
        return result;
    }

    public E pop() {
        return pop(stack.pop());
    }

    private E pop(E ele) {
      if(stack.empty()) {
          return ele;
      }
      E current = stack.pop();
      E toReturn = pop(current);
      stack.push(ele);
      return toReturn;
    }

}
