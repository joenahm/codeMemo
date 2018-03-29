public class Computer {
	public static double getResult(double a, int ... x){
		int sum = 0;

		for( int val : x ){
			sum += val;
		}

		return (a*sum);
	}
}
