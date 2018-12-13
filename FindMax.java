public class FindMax {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
    	int max = 0;
    	for(int i = 0; i < m.length; i++){
    		if(m[i] >= max){
    			max = m[i];
    		}
    	}
        return max;
    }
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};   
       int result = max(numbers);
       System.out.println(result);   
    }
}