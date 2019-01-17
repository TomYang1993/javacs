public class Sort {

    public static void sort(String[] x) {
        sort(x, 0);
    }

    public static int findSmallest(String[] x, int start){
        int indexOfSmallest = start;
        for(int i =start;i< x.length;i++){
            if(x[i].compareTo(x[indexOfSmallest]) < 0){
                indexOfSmallest = i;
            }
        }
        return indexOfSmallest;
    }

    public static void swap(String[] x, int a, int b){
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }

    public static void sort(String[] x, int start){
        if(start == x.length){
            return;
        }
        int smallestIndex = findSmallest(x,start);
        swap(x, start, smallestIndex);
        sort(x, start + 1);
    }

}