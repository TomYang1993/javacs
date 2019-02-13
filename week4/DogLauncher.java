import java.util.Comparator;

public class DogLauncher {
 public static void main(String[] args) {
     Dog d1 = new Dog("ben", 6, "haha");
     Dog d2 = new Dog("a", 2, "haha");
     Dog d3 = new Dog("kj", 7, "haha");
     Dog d4 = new Dog("f", 16, "haha");
     Dog d5 = new Dog("gh", 46, "haha");
     Dog[] dogList = new Dog[]{d1, d2, d3, d4, d5};
     Dog maxim = (Dog)Maximizer.max(dogList);
     maxim.bark();

     //d3.secret = "string literal";

     Comparator nc = Dog.getNameComparator();
     int result = nc.compare(d3, d2);
     if(result > 0){
         d3.bark();
     }
 }
}
