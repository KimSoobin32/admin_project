package admin;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class today {
	public String getDateTimeNow() {
		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter dtf  = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String today = time.format(dtf);
		
		return today;
	}
}
