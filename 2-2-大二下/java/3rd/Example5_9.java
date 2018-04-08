public class Example5_9 {
	public static void main(String[] args){
		Human people = new Human();
		Anthropoid ape = people;

		ape.cry("我王境泽今天就算饿死，死外边，从这儿跳下去，也不会吃你们一口东西！");
		System.out.println(ape.m);
		System.out.println(people.m);

		Human wangJingZe = (Human)ape;
		wangJingZe.compute(55,33);
		wangJingZe.m = 'T';

		System.out.println(wangJingZe.m);
	}
}
