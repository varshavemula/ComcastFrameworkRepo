package PracticeTest;

import org.testng.annotations.Test;

import java.util.Date;

public class CaptureTimeStamp {

	@Test
	public void timeStamp()
	{
		String time=new Date().toString().replace(" ","_").replaceAll(":", "_");
		System.out.println(time);
	}
}
