import java.util.Iterator;
import java.util.LinkedList;

public class List {
	public static void main(String[] args){
		LinkedList<String> linkList = new LinkedList<>();

		init(linkList);
		iteratorTraverse(linkList,true);
		System.out.println();
		forgetTraverse(linkList,true);
		System.out.println();
		timeConsumingTest(9999);
	}

	private static void init(LinkedList<String> list){
		list.add("Java");
		list.add("真");
		list.add("有趣");
		list.add("!");
	}
	private static void iteratorTraverse(LinkedList<String> list,boolean isShow){
		System.out.println("迭代器遍历：");
		for( Iterator iterator = list.iterator();iterator.hasNext(); ){
			if( isShow ){
				System.out.println(iterator.next());
			}else{
				iterator.next();
			}
		}
	}
	private static void forgetTraverse(LinkedList<String> list,boolean isShow){
		System.out.println("for-get遍历：");
		for( int i = 0 ; i < list.size() ; i++ ){
			if( isShow ){
				System.out.println(list.get(i));
			}else{
				list.get(i);
			}
		}
	}
	private static void timeConsumingTest(int level){
		System.out.println("遍历"+level+"个元素所耗时间：");

		long baseTime;

		LinkedList<String> temp = new LinkedList<>();
		for( int i = 0 ; i < level ; i++ ){
			temp.add(Integer.toString(i));
		}

		baseTime = System.currentTimeMillis();
		iteratorTraverse(temp,false);
		System.out.println("用时"+(System.currentTimeMillis()-baseTime)+"ms");

		baseTime = System.currentTimeMillis();
		forgetTraverse(temp,false);
		System.out.println("用时"+(System.currentTimeMillis()-baseTime)+"ms");
	}
}
