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
		return fibHelp(n, 0, 1);
	}

	private int fibHelp(int n, int prelast, int last){
		if (n==0){
			return 0;
		}
		if (n==1){
			return 1;
		}
		if (n==2){
			return prelast + last;
		}
		return fibHelp(n-1, last, prelast + last);
	}


	public double sqrt(double n){
		if (n<0){
			throw new IllegalArgumentException("n must not be negative");
		}
		if (n==0){
			return 0;
		}
		return sqrtHelp(n, 1);
	}

	public double sqrtHelp(double n, double guess){
		if (guess * guess < 1.0005 * n || guess * guess > 0.9995 * n){
			return guess;
		}
		return (n, (n/guess + guess)/2);
	}
}