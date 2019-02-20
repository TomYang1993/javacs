package Map61B;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MapHelper {

    public static <K, V> V get(Map61B<K,V> map, K key) {
        if(map.containsKey(key)){
            return map.get(key);
        }
        return null;
    }

    public static <K extends Comparable<K>, V> K maxKey(Map61B<K,V> map) {
        List<K> keys = map.keys();
        K largest = keys.get(0);
        for(K key :keys) {
            if(key.compareTo(largest) > 0) {
                largest = key;
            }
        }
        return largest;
    }

    @Test
    public void testGet() {
        Map61B<String, Integer> map = new ArrayMap<String, Integer>();
        map.put("Tom", 26);
        map.put("josie", 23);
        map.put("royce", 27);
        map.put("coco", 3);
        Integer i = MapHelper.get(map, "Tom");
        Integer expected = 26;
        assertEquals(expected, i);
    }

    @Test
    public void testMaxKey() {
        Map61B<String, Integer> map = new ArrayMap<String, Integer>();
        map.put("Tom", 26);
        map.put("josie", 23);
        map.put("royce", 27);
        map.put("coco", 3);
        String i = MapHelper.maxKey(map);
        String expected = "royce";
        assertEquals(expected, i);
    }

}
