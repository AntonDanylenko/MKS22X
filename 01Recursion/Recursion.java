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

	private double sqrtHelp(double n, double guess){
		//if (guess * guess < 1.0005 * n && guess * guess > 0.9995 * n){
		if (guess * guess == n){
			return guess;
		}
		return sqrtHelp(n, (n/guess + guess)/2);
	}



	/*public static void main(String[]args){
		Recursion r = new Recursion();

		System.out.println("fact(10) = " + r.fact(10));
		System.out.println("fact(0) = " + r.fact(0));
		System.out.println("fib(10) = " + r.fib(10));
		System.out.println("fib(40) = " + r.fib(40));
		System.out.println("fib(0) = " + r.fib(0));
		System.out.println("sqrt(100) = " + r.sqrt(100));
		System.out.println("sqrt(0.0036) = " + r.sqrt(0.0036));
		System.out.println("sqrt(100000000) = " + r.sqrt(100000000));
		System.out.println("sqrt(0) = " + r.sqrt(0));
	}*/
}