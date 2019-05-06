package synthesizer;
import org.junit.Test;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Double> arb = new ArrayRingBuffer(10);
        arb.enqueue(0.2);
        arb.enqueue(0.56);
        arb.enqueue(0.1);
        arb.enqueue(1.4);
        arb.enqueue(4.5);
        arb.dequeue();
        arb.dequeue();
        arb.enqueue(2.2);
        arb.enqueue(1.0);

//        Iterator<Double> iterator = arb.iterator();
//        while(iterator.hasNext()){
//            iterator.next();
//        }

        for(double i : arb){
            for(double j : arb){
            System.out.println(i);
                System.out.println("line breaker here");
                System.out.println(j);
            }
        }

    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
