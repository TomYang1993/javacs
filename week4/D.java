public class D {
    public static void main(String[] args) {
        //upper class can not downgrade
//        B a0 = new A();
//        a0.m1();
//        a0.m2(16);
        A b0 = new B();
        System.out.println(b0.x);
        b0.m1();
        b0.m2();
        //have the static type first and then dynamic selection will happen, m2(int y) does not exist on A type
        //        b0.m2(61);
        B b1 = new B();
        b1.m2(61);
        b1.m3();
        A c0 = new C();
        c0.m2();
        // C is a A, but not all As are c
        //C c1 = (A) new C();
        A a1 = (A) c0;
        C c2 = (C) a1;
        c2.m3();
        //runtime error
//        c2.m4();
        c2.m5();
        ((C) c0).m3();
        // A type does not have m3
        //(C) c0.m3();
        b0.update();
        b0.m1();
    }
}
