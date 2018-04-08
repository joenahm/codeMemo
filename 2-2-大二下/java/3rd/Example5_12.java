
public class Example5_12 {
	public static void main(String[] args){
		Vehicle manualCar = new Manual();
		manualCar.start();
		manualCar.speedUp();
		manualCar.brake();

		Vehicle automaticCar = new Automatic();
		automaticCar.start();
		automaticCar.speedUp();
		automaticCar.brake();
	}
}

abstract class Vehicle{
	public abstract void start();
	public abstract void speedUp();
	public abstract void brake();
}

class Manual extends  Vehicle{
	Manual(){
		System.out.println("手动挡汽车：");
	}
	public void start(){
		System.out.println("踩离合挂挡，松离合加油门");
	}
	public void speedUp(){
		System.out.println("加油门，踩离合挂挡，松离合加油门");
	}
	public void brake(){
		System.out.println("踩离合踩刹车");
	}
}

class Automatic extends Vehicle{
	Automatic(){
		System.out.println("自动挡汽车");
	}
	public void start(){
		System.out.println("挂前进挡，加油门");
	}
	public void speedUp(){
		System.out.println("加油门");
	}
	public void brake(){
		System.out.println("踩刹车");
	}
}
