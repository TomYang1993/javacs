package Map61B;

import java.util.ArrayList;
import java.util.List;

public class ArrayMap<K, V> implements Map61B<K,V> {

    K[] keys;
    V[] values;
    int size;

    public ArrayMap() {
        keys = (K[])new Object[100];
        values = (V[])new Object[100];
        size = 0;
    }


    public int keyIndex(K key) {

        for(int i = 0; i < size; i++){
            if(keys[i].equals(key)){
                return i;
            }
        }
        return -1;
    }

    public boolean containsKey(K key) {

        return keyIndex(key) > -1;
    }

    public V get(K key){
       int index = keyIndex(key);
       return values[index];
    }

    public int size(){
        return size;
    }

    public void put(K key, V value) {
        if(keyIndex(key) < 0) {
            keys[size] = key;
            values[size] = value;
            size += 1;
        } else{
            values[size] = value;
        }

    }

    public List<K> keys() {

        List<K> keyList = new ArrayList<>();
        for(int i = 0; i < size; i++){
           keyList.add(keys[i]);
        }
        return keyList;
    }

    public static void main(String[] args) {
        ArrayMap<String, Integer> map = new ArrayMap<String, Integer>();
        map.put("Tom", 26);
        map.put("josie", 23);
        map.put("royce", 27);
        map.put("coco", 3);

    }
}
