import java.text.*;
import java.util.*;

public class E2 {
	public static void main(String[] args){
		Calendar calendar = Calendar.getInstance();
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-04-09 16:35:36");
			calendar.setTime(date);

			printDate(calendar);
			printXofYear(calendar);
		}catch (ParseException e){
			e.printStackTrace();
		}
	}

	private static void printDate(Calendar calendar){
		printInfo("输出年月日时分秒");

		System.out.println("年："+calendar.get(Calendar.YEAR));
		System.out.println("月："+calendar.get(Calendar.MONTH)+1);
		System.out.println("日："+calendar.get(Calendar.DATE));
		System.out.println("时："+calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println("分："+calendar.get(Calendar.MINUTE));
		System.out.println("秒："+calendar.get(Calendar.SECOND));
	}
	private static void printXofYear(Calendar calendar){
		printInfo("输出该时间是该年第几周、第几天");

		System.out.printf("该年第%d周\n",calendar.get(Calendar.WEEK_OF_YEAR));
		System.out.printf("该年第%d天\n",calendar.get(Calendar.DAY_OF_YEAR));
	}

	private static void printInfo(String info){
		System.out.println(info+":");
	}
}
