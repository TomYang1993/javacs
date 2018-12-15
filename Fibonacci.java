
public class Fibonacci{

public static int Fibonacci(int N) {
	if( N <= 1){
		return N;
	}
	return Fibonacci(N - 2) + Fibonacci(N -1);
}

public static void main(String[] args){
	System.out.println(Fibonacci(4));
}


}

