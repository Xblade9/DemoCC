package com.selenium.maven;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable1 {

	public WebDriver driver;
	
	public String URL="http://demo.guru99.com/test/web-table-element.php";
	
	double t=0;
	
	@BeforeTest
	
	public void open()
	
	{
		
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(URL);
				
		
	}
	
	
	@Test
	
	public void webTable()
	
	{
		//to get no of col from the web table
		
		List<WebElement> col=driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th"));
		
		int colSize=col.size();

		System.out.println("No of cols are : "+colSize);
		
		//to get no of rows from the web table
		
		List<WebElement> row=driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th[1]"));
		
		int rowSize=row.size();
		
		System.out.println("No of Rows are : "+rowSize);
		
		WebElement rowName=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[2]/td[1]"));
		
		String rName=rowName.getText();
		
		System.out.println("Row Name : "+rName);
		
		WebElement data=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[2]/td[2]"));
		
		String rowText=data.getText();
		
		System.out.println("Third row of Table Data : "+rowText);
		
		
		//To fetch the particular data from the web table
		
		List<WebElement>allDataFromOneCol=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[2]"));
				
		for (WebElement we : allDataFromOneCol)
		
		{
				
			String fetch=we.getText();
		
			System.out.println(fetch);
			
		}
		
		//To get Maximum value from the WebTable
		
		
		System.out.println("----------------------------");
		
		
		List<WebElement>max=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));
		
		int rowSizee=max.size();
		
		System.out.println(rowSizee);
		
		for (WebElement webElement : max) {
			
			String m=webElement.getText();
			
			double r=Double.parseDouble(m);
			
			if(r>t)
			{
				
				t=r;
			}
			
			
		}
		
		System.out.println("Maxiumu value is : "+t);
		
		
		//to get all the data from the web table
		
		System.out.println("`````````````````````````````````");
		
		List<WebElement>w1=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		
		int rows=w1.size();
		
		for(int r=0;r<rows;r++)
		{
		
		List<WebElement>w2=driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th"));

		int cols=w2.size();
		
		for(int c=0;c<cols;c++)
			
		{
			 System.out.println("Value from Row "+" "+r+" "+"and column "+" "+c+" "+" "+w1.get(c).getText());
		  
		}
		
		System.out.println("*******************************************");
		
		}
		
	}
	
	@AfterTest
	
	public void close()
	
	{
		
		try 
		{
			Thread.sleep(2000);
			
			driver.quit();
		} 
		
		catch (Exception e)
		
		{
			// TODO: handle exception
			
			e.printStackTrace();
		
		}
	
	}
	
	
	
}
	