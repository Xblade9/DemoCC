package testng;

import org.testng.annotations.Test;

public class GRPXML2 {

	
	@Test
	public void Australia()
	{
		
		System.out.println("We are 3 Times continous world champion");
		
	}
	
	@Test(groups = "Football Clubs")
	
	public void manchesterUnited()
	{
		
		System.out.println("This is the Theatre Of Dreams");
		
	}
	
	
	
}
