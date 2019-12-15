package localDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Localdate {
	public static void main(String args[]) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter df=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println(now);
		String format = now.format(df);
		System.out.println(format);
//		  LocalDate parsedDate = LocalDate.parse("2018-03-06", df);
//		  Class<? extends LocalDate> class1 = parsedDate.getClass();
//		  System.out.println(parsedDate);
//		  System.out.println(class1);
	}
}
