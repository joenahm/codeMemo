enum Fruit{
	苹果,梨,西瓜,香蕉,芒果
}

public class Example3_10 {
	public static void main(String[] args){
		double price = 0;

		for( Fruit fruit : Fruit.values() ){
			boolean show = true;
			//改成默认就show，每次都改多呆哦

			switch ( fruit ){
				case 苹果:
					price = 1.5;
					break;
				case 芒果:
					price = 6.8;
					break;
				case 香蕉:
					price = 2.8;
					break;
				default:
					show = false;
			}

			if( show ){
				System.out.println(fruit + "500克的价格：" + price + "元");
			}
		}
	}
}
