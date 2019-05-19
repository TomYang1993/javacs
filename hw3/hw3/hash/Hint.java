package hw3.hash;

public class Hint {
    public static void main(String[] args) {
        System.out.println("The powers of 256 in Java are:");
//        int x = 1;
//        for (int i = 0; i < 10; i += 1) {
//            System.out.println(i + "th power: " + x);
//            x = x * 256;
//        }

        int[] params = new int[]{1,23,14,5,1,1,1,1};
        int total = 0;
        for (int x : params) {
            total = total * 256;
            System.out.println("th power: " + total);
            total = total + x;
            System.out.println("th power: " + total);
        }

//        int[] params = new int[]{23,14,5,1};
//        int total = 0;
//        for (int x : params) {
//            total = total * 256;
//            System.out.println("th power: " + total);
//            total = total + x;
//            System.out.println("th power: " + total);
//        }

    }
} 
