package Map61B;


import java.util.List;

public interface Map61B<K, V> {

    boolean containsKey(K key);

    V get(K key);

    int size();

    void put(K key, V value);

    List<K> keys();


}
