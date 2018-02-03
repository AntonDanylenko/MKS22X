public class Recursion{
	public int fact(int n){
		if (n<0){
			throw new IllegalArgumentException("n must not be negative");
		}
		if (n==0){
			return 1;
		}
		return n * fact(n-1);
	}


	public int fib(int n){
		if (n<0){
			throw new IllegalArgumentException("n must not be negative");
		}
		if (n==0){
			return 0;
		}
		else if (n==1){
			return 1;
		}
		return fib(n-1) + fib(n-2);
	}
}