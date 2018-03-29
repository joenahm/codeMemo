public class People {
	private int legNum;
	private int handNum;
	private String name;

	private People(String inName){
		name = inName;
		init();
	}

	private void init(){
		legNum = 2;
		handNum = 2;

		System.out.println(name+"有"+handNum+"只手"+legNum+"条腿");
	}

	public static void main(String[] args){
		People zhangJian = new People("张建");
	}
}
