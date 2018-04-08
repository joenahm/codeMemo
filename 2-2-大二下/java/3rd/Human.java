class Human extends Anthropoid {
	char m = 'A';
	int n = 60;

	public void compute(int a, int b){
		System.out.printf("%d加%d等于%d\n",a,b,a+b);
	}

	public void cry(String s){
		System.out.printf("%c**%s**%c\n",m,s,m);
	}
}
