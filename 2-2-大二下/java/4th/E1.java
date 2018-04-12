public class E1 {
	public static void main(String[] args){
		String str = "3|Four Rooms (1995)|01-Jan-1995||http://us.imdb.com(1995)|0|0|0|0|0|1|0|0";

		splitBy(str,"[|]");
		filter(str);
		allIndexOf(str,"1995");
	}

	private static void splitBy(String str, String spliter){
		printInfo("用|分割字符串并输出");

		String[] result = str.split(spliter);

		for( String part : result ){
			System.out.println(part);
		}
	}
	private static void filter(String str){
		printInfo("过滤掉非英文单词（连续字母视为单词）");

		String result = str.replaceAll("[^a-zA-Z ]","");

		System.out.println(result);
	}
	private static void allIndexOf(String str, String substr){
		printInfo("找到所有1995的位置并输出");

		int index = str.indexOf(substr);
		System.out.println(index);

		while( index >= 0 ){
			index = str.indexOf(substr,index+substr.length());
			if( index != -1 ) {
				System.out.println(index);
			}
		}
	}

	private static void printInfo(String info){
		System.out.println(info+":");
	}
}
