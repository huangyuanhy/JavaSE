package java8;

import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.junit.Test;

public class Java8TimeTest {
	@Test
	public void test() {
		//Instant:时间戳 以1970年1月1日到现在的时间的毫秒值
		//默认utc时间 格里尼治
		Instant in1=Instant.now();
		System.out.println(in1);
		//加上时区后，为北京时间
		OffsetDateTime atOffset = in1.atOffset(ZoneOffset.ofHours(8));
		System.out.println(atOffset);
		//打印时间戳
		System.out.println(in1.toEpochMilli());
	}
	//duration 计算两个 时间 的间隔
	// period 计算两个 日期 的间隔
	long duration=Duration.between(Instant.now(),Instant.now()).toMillis();
}
