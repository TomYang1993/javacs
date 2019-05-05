package synthesizer;

public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {

    int capacity;
    int fillCount;

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }
}
