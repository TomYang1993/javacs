import org.junit.Test;

public class ArrayDequeTest {

    @Test
    public void testAddLast() {
        ArrayDeque<Integer> target = new ArrayDeque<>();

        target.addLast(1);
        target.addLast(4);
        target.addLast(7);
        target.addLast(14);
        target.addLast(24);
        target.addLast(56);
        target.addLast(24);
        target.addLast(56);

        int r1 = target.get(0);
//		target.addFirst(100);
//		target.removeFirst(100);
//		target.removeFirst(100);
//		target.removeFirst(100);
//		target.removeFirst(100);
//		target.removeLast(100);
//		target.removeLast(100);
//
        target.printDeque();
    }

    @Test
    public void testAddFirst() {
        ArrayDeque<Integer> target = new ArrayDeque<>();
        target.addFirst(3);
        target.addFirst(5);
        target.addFirst(11);
        target.addFirst(4);
        target.addFirst(7);
        target.addFirst(14);
        target.addFirst(24);
        target.addFirst(56);
        target.printDeque();

    }

    @Test
    public void testResizeNull() {
        ArrayDeque<Integer> target = new ArrayDeque<>();
        target.addFirst(3);
        target.addFirst(5);
        target.addFirst(11);
        target.addFirst(4);
        target.addFirst(7);
        target.addFirst(14);
        target.addFirst(24);
        target.addFirst(56);
        target.addFirst(6);
        int r1 = target.removeFirst();
        int r2 = target.removeLast();
        target.printDeque();

    }
}
