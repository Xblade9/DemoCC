package com.selenium.maven;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable2 {

	
	public WebDriver d;
	
	public String url="http://demo.guru99.com/test/web-table-element.php#";
	
	public WebElement e;
	
	@Test
	
	public void webTable()
	
	{
		
		WebDriverManager.chromedriver().setup();
		
		d=new ChromeDriver();
		
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		d.manage().window().maximize();
		
		d.get(url);
		
		List<WebElement>rowSize=d.findElements(By.cssSelector("#leftcontainer >.dataTable"));
		
		int tableSize=rowSize.size();
		
		System.out.println("Table Size : "+tableSize);
		
		Iterator<WebElement>itr=rowSize.iterator();
		
		while(itr.hasNext())
			
		{
			
			System.out.println("Print RowSize : "+itr.next().getText());
			
			
			
		}
		
		List<WebElement>colSize=d.findElements(By.cssSelector("#leftcontainer >.dataTable >thead"));
		
		int col=colSize.size();
		
		System.out.println("Col Size : "+col);
		
		Iterator<WebElement>itr1=colSize.iterator();
		
		while(itr1.hasNext())
		{
			
			System.out.println("Print ColSize :"+itr1.next().getText());
			
			
		}
		
		
		List<WebElement>colNames=d.findElements(By.cssSelector("#leftcontainer >.dataTable >thead >tr >th"));
		
		int coll=colNames.size();
		
		System.out.println("No of Columns : "+coll);
		
		Iterator<WebElement>itr2=colNames.iterator();
		
		while(itr2.hasNext())
			
		{
			System.out.println("Print ColNames "+itr2.next().getText());
			
			
			
		}
		
		
		e=d.findElement(By.cssSelector("#leftcontainer >.dataTable >thead >tr >th:nth-child(1)"));
		
		System.out.println("ColName : "+e.getText());
		
		
		List<WebElement>itr3=d.findElements(By.cssSelector("#leftcontainer >.dataTable >tbody"));
		
		int bodySize=itr3.size();
		
		System.out.println("Table Body Size : "+bodySize);
		
		for(WebElement web:itr3)
		{
			System.out.println("Table Body Contents : "+web.getText());
			
			
		}
		
		
		List<WebElement>itr4=d.findElements(By.cssSelector("#leftcontainer >.dataTable >tbody >tr"));
		
		int rowS=itr4.size();
		
		System.out.println("Row Size : "+rowS);
		
		for(WebElement w:itr4)
			
		{
			
			
			System.out.println("Row values : "+w.getText());
			
			
		}
		
	  List<WebElement>itr5=d.findElements(By.cssSelector("#leftcontainer >.dataTable >tbody >tr >td"));
		
	  int size=itr5.size();
		
	  System.out.println("Size : "+size);
		
		for(WebElement w:itr5)
		{
			
			System.out.println("Dat : "+w.getText());
			
			
		}
		
		
		//specific Data From Row
		
		e=d.findElement(By.cssSelector("#leftcontainer >.dataTable >tbody >tr >td:last-child"));
		
		org.openqa.selenium.Dimension dimi=e.getSize();
		
		System.out.println("Dimensions are : "+dimi);
		
		System.out.println("Particular Data From Web Table : "+e.getText());
		
		
		
		//maximum value from particular col
		
		
	    double t=0;
	    
	    List<WebElement>itr6=d.findElements(By.cssSelector("#leftcontainer >.dataTable >tbody >tr >td:nth-child(3)"));
		
	    //#leftcontainer >.dataTable >tbody >tr >td:nth-child(3)
	    
	    int s=itr6.size();	
		
	    System.out.println("Size of Prev Close (Rs) : "+s);
		
		
	    for(WebElement w:itr6)
	    {
	    	
	    	String text=w.getText();
	    	
	    	double doubleFormat=Double.parseDouble(text);
	    	
	    	if(doubleFormat>t)
	    	{
	    		
	    		t=doubleFormat;
	    		
	    	}
	    	
	    	
	    }
		
		System.out.println("Max value : "+t);
		
		
		
		
		
	}
	
	
	@AfterMethod
	
	public void close()
	{
		
		try {
			Thread.sleep(2000);
			
			d.quit();
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	
}
