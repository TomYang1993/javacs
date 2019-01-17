public class Sort {

    public static void sort(String[] x) {

    }

    public static int findSmallest(String[] x){
        int indexOfSmallest = 0;
        for(int i =0;i< x.length;i++){
            if(x[i].compareTo(x[indexOfSmallest]) < 0){
                indexOfSmallest = i;
            }
        }
        return indexOfSmallest;
    }

}