public class Example5_15 {
	public static void main(String[] args){
		Bus bus7 = new Bus();
		bus7.charge();

		Cab tianYu = new Cab();
		tianYu.charge();
		tianYu.controlTemperature();

		Cinema hongXing = new Cinema();
		hongXing.charge();
		hongXing.controlTemperature();
	}
}

interface Rechargeable{
	public void charge();
}
interface Airconditioned{
	public void controlTemperature();
}

class Bus implements Rechargeable{
	public void charge(){
		System.out.println("公交车：投币1元，不计里程");
	}
}
class Cab implements Rechargeable,Airconditioned{
	public void charge(){
		System.out.println("出租车：3.2元/公里，3公里起步");
	}
	public void controlTemperature(){
		System.out.println("海尔空调已开启");
	}
}
class Cinema implements Rechargeable,Airconditioned{
	public void charge(){
		System.out.println("电影院：门票10元");
	}
	public void controlTemperature(){
		System.out.println("中央空调已启动");
	}
}