import java.util.Comparator;

public class Dog implements Comparable<Dog>{

    String name;
    int size;
    private String secret;


    public Dog(String name, int size, String s){
        this.name = name;
        this.size = size;
        this.secret = s;
    }

    public void bark() {
        System.out.println("This is " + name);
    }


    private static class NameComparator implements Comparator<Dog> {
        public int compare (Dog a, Dog b){
            return a.name.compareTo(b.name);
        }
    }

    public static NameComparator getNameComparator() {
        return new NameComparator();
    }

    public int compareTo(Dog d){
      return this.size - d.size;
    }
}
