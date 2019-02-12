import java.util.Comparator;

public class DogLauncher {
 public static void main(String[] args) {
     Dog d1 = new Dog("ben", 6);
     Dog d2 = new Dog("a", 2);
     Dog d3 = new Dog("kj", 7);
     Dog d4 = new Dog("f", 16);
     Dog d5 = new Dog("gh", 46);
     Dog[] dogList = new Dog[]{d1, d2, d3, d4, d5};
     Dog maxim = (Dog)Maximizer.max(dogList);
     maxim.bark();

     Comparator nc = Dog.getNameComparator();
     int result = nc.compare(d3, d2);
     if(result > 0){
         d3.bark();
     }
 }
}
