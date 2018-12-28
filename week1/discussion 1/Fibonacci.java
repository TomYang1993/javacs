
public class Fibonacci{

/** K is the recording index, j,i are the fibonacci numbers which are always next to each other
 * once K reaches index N, the iteration stops
 */
	public static int Fibonacci(int N, int K, int j, int i) {
		if( N == K){
			return j;
		}
		return Fibonacci(N, K+1, i, i+j);
	}

public static int Fibonacci(int N) {
	if( N <= 1){
		return N;
	}
	return Fibonacci(N - 2) + Fibonacci(N -1);
}

public static void main(String[] args){
	System.out.println(Fibonacci(4));
	System.out.println(Fibonacci(6, 0, 0, 1));
}


}

