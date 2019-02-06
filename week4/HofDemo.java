public class HofDemo {
    public static int do_twice(TenX f, int x){
        return f.apply(f.apply(x));
    }

    public static void main(String[] args){
        System.out.println(do_twice(new TenX(), 2));
    }
}