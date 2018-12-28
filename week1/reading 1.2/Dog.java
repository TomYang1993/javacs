public class Dog {
    public int weightInPounds;

    public Dog(int w) {
        weightInPounds = w;
    }


public static Dog maxDog(Dog d1, Dog d2) {
    if (weightInPounds > d2.weightInPounds) {
        return this;
    }
    return d2;
}

public static void main(String[] args) {
        /* Create an array of two dogs. */
        Dog[] dogs = new Dog[2];
        dogs[0] = new Dog(8);
        dogs[1] = new Dog(20);
        System.out.println(Dog.maxDog(dogs[0], dogs[1]));
      
    }
}