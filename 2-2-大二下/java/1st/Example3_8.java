public class Example3_8 {
	public static void main(String[] args){
		int[] a = {1,2,3,4};
		char[] b = {'a','b','c','d'};

		for( int i = 0 ; i < a.length ; i++ ){
			System.out.println(a[i]);
		}

		for( int i = 0 ; i < b.length ; i++ ){
			System.out.println(b[i]);
		}

		for( int item : a ){
			System.out.println(item);
		}

		for( char item : b ){
			System.out.println(item);
		}
	}

}
