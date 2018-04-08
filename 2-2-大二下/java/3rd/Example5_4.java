public class Example5_4 {
	public static void main(String[] args){
		B tree = new B();

		System.out.printf("调用覆盖版本方法得到的结果：%f\n",tree.f(5,6));
		System.out.printf("调用继承自父类方法得到的结果：%d\n",tree.g(3,5));
	}
}

class A{
	public double f(float x, float y){
		return x+y;
	}
	public int g(int x, int y){
		return x+y;
	}
}

class B extends A{
	public double f(float x, float y){
		return x*y;
	}
}
