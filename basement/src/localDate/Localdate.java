package localDate;
/**
 * 测试各种时间日期的用法
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Localdate {
	public static void main(String args[]) {
		LocalDate date = LocalDate.now();
		System.out.println(date);
		
		 //-------------解析字符串---------------

		DateTimeFormatter df=DateTimeFormatter.ofPattern("yyyy-MM-dd");

		  LocalDate parsedDate = LocalDate.parse("2018-03-06", df);
		  Class<? extends LocalDate> class1 = parsedDate.getClass();
		  System.out.println(parsedDate);
		  System.out.println(class1);
		  
		  
		  
		  
	}
}
