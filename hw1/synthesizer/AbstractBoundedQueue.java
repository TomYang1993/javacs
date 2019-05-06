package synthesizer;

public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {

    protected int capacity;
    protected int fillCount;

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }
}
