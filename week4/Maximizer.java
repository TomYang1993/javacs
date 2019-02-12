public class Maximizer {
    public static Comparable max(Comparable[] items){
        Comparable max = items[0];
        for(Comparable item: items){
            if(item.compareTo(max) > 0){
                max = item;
            }
        }
        return max;
    }
}
