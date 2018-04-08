public class Example5_3 {
	public static void main(String[] args){
		Student stu = new Student();

		stu.x = 98;
		System.out.printf("对象stu的x的值是%d\n",stu.getIntX());

		stu.setDoubleX(98.99);
		System.out.printf("对象stu从父类继承下来的x的值是：%f\n",stu.getDoubleX());
	}
}

class People{
	private double x;

	public void setDoubleX(double x){
		this.x = x;
	}
	public double getDoubleX(){
		return x;
	}
}
class Student extends People{
	public int x;

	public int getIntX(){
		return x;
	}
}
