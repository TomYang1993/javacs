package synthesizer;

import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T>  {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        this.capacity = capacity;
        this.fillCount = 0;
        this.first = 0;
        this.last = 0;
        this.rb = (T[])new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        if(last == this.capacity){
            last = 0;
        }

        if(isFull()){
            throw new RuntimeException("Ring Buffer Overflow");
        }

        rb[last] = x;
        last = last + 1;
        fillCount += 1;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if(isEmpty()){
            throw new RuntimeException("Ring Buffer Underflow");
        }
        if(first >= this.capacity){
            first = 0;
        }
        T result = rb[first];
        rb[first] = null;
        first += 1;
        fillCount = fillCount - 1;
        return result;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if(isEmpty()){
            return null;
        }
        if(first == this.capacity){
            first = 0;
        }
        return rb[first];
    }

    @Override
    public Iterator<T> iterator(){
        return new ArrayRingBufferIterator();
    }

    private class ArrayRingBufferIterator implements Iterator<T>{

        private int start;

        public ArrayRingBufferIterator () {
            start = first;
        }

        public boolean hasNext() {
            if (start == capacity) {
                start = 0;
            }
            return !(start == last);
        }

        public T next() {
            if(hasNext()){
                T result = rb[start];
                start = start + 1;
                return result;
            }else {
                throw new RuntimeException("Ring Buffer Underflow");
            }
        }
    }
}
