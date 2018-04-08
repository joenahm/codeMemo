public class Example5_11 {
	public static void main(String[] args){
		B tree = new B();

		System.out.printf("sum=%d\n",tree.sum(30,20));
		System.out.printf("sub=%d\n",tree.sub(30,20));
	}
}

abstract class A{
	abstract int sum(int x, int y);
	int sub(int x, int y){
		return x-y;
	}
}

class B extends A{
	int sum(int x, int y){
		return x+y;
	}
}
