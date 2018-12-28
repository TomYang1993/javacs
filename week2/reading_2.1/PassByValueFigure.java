public class PassByValueFigure {

    public static class Walrus {
        public int weight;
        public double tuskSize;
    
        public Walrus(int w, double ts) {
              weight = w;
              tuskSize = ts;
        }
    }
    public static void main(String[] args) {
           Walrus walrus = new Walrus(3500, 10.5);
           int x = 9;

           doStuff(walrus, x);
           System.out.println(walrus.weight);
           System.out.println(x);
    }

    public static void doStuff(Walrus W, int x) {
           W.weight = W.weight - 100;
           x = x - 5;
    }
}

