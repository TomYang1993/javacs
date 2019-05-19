package hw3.hash;

import java.util.Arrays;
import java.util.List;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /* TODO:
         * Write a utility function that returns true if the given oomages
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each oomage's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * Oomages and no bucket has more than N / 2.5 Oomages.
         */
        int[] buckets = new int[M];
        int oomagesSize = oomages.size();
        for(int i = 0; i < M; i++){
            buckets[i] = 0;
        }
        for(int i = 0; i < oomagesSize; i++){
            int hashCode = oomages.get(i).hashCode();
            int index = (hashCode & 0x7FFFFFFF) % M;
            buckets[index] += 1;
        }
        Arrays.sort(buckets);

        return (buckets[0] > (oomagesSize / 50.0)) && (buckets[M-1] < (oomagesSize / 2.5));
    }
}
