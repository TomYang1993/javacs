/** put an array in ascending order
find the index of the smallest number and swap with the first element in the array
selection sort
*/

public class ArrayOrder {
    /** Returns the maximum value from m array. */
    public static int findMinIndex(int[] m, int startIndex) {
    	int index = startIndex;
    	int min = m[startIndex];
    	while(startIndex + 1 < m.length){
    		if(m[startIndex + 1] < min){
    			min = m[startIndex + 1];
    			index = startIndex + 1;
    		}
    		startIndex++;
    	}

        return index;
    }


/** swap the smallest element one by one from left to right */
    public static void swap(int[] m){
    	for(int i = 0; i < m.length; i++){
    		int targetIndex = findMinIndex(m, i);
    		int temp = m[targetIndex];
    		m[targetIndex] = m[i];
    		m[i] = temp;
    	}
    }

    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};   
       int result = findMinIndex(numbers, 3);
       swap(numbers);
       for(int s:numbers){
       	System.out.println(s);
         
    }
       }
}