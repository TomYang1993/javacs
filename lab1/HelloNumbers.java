
public class HelloNumbers {
	public static void main(String[] args) {
		int x = 1;
		int sum = 0;
        while (x < 11) {
            System.out.print(sum + " ");
            sum = sum + x;
            x += 1;
        }
}
}
