package com.weborder;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderS {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"/Users/begimaikanybek/Documents/Selenium dependencies/drivers/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get(" http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

		String username = "Tester";
		String password = "test";

		String expectedTitle = "Web Orders Login";
		String actual = driver.getTitle();

		if (expectedTitle.equals(actual)) {
			System.out.println("Succesfully landed on the main page :" + actual);
		} else {
			System.out.println("Fail landing on the main Page: " + actual);
		}

		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys(username);
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys(password);
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		driver.findElement(By.linkText("Order")).click();

		// Step 5 Input random number to Quantity.
		Random randomNumber = new Random();
		String Quantity = randomNumber.nextInt(100) + "";
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(Quantity);

		// 6 Enter Customer Name: John <middle_name> Smith
		CustomerName s1 = new CustomerName();
		String fullName = s1.randomString();
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys(fullName = s1.randomString());

		
		
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rand = new Random();
        int rn = rand.nextInt(100);
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rand.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
		
		
		String st = "123 Any st";
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys(st);
		
		String city = "AnyTown";
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys(city);
		String state = "Virginia";
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys(state);
//		String zip = "11235";
//		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(zip);
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(""+rand.nextInt(9)
		+rand.nextInt(9)+rand.nextInt(9)+rand.nextInt(9)+rand.nextInt(9));
		
		
		String s4="//*[@id=\"ctl00_MainContent_fmwOrder_cardList_1\"]";
		String s2="//*[@id=\"ctl00_MainContent_fmwOrder_cardList_2\"]";
		String s3="//*[@id=\"ctl00_MainContent_fmwOrder_cardList_0\"]";
		int a =rand.nextInt(3);
		
		if(a==1)
		driver.findElement(By.xpath(s3)).click();
		else if(a==2)
			driver.findElement(By.xpath(s4)).click();
		else
			driver.findElement(By.xpath(s2)).click();
		
		StringBuilder cardnumber = new StringBuilder();
		for(int i=0; i<15; i++) {
			cardnumber.append(""+(rand.nextInt(10)-1));
		}
		StringBuilder cardnumber2 = new StringBuilder();
		for(int i=0; i<14; i++) {
			cardnumber2.append(""+(rand.nextInt(10)-1));
		}
		if(a==1 ) {
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(""+4+cardnumber);
		}else if(a==2) {
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(""+5+cardnumber);
		}else {
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(""+3+cardnumber2);
		}
		int date=rand.nextInt(12);
		StringBuilder datee =new StringBuilder();
		if(date<10) {
			
			datee.append("0").append(date);
		}else {
			datee.append(date);
		}
		int year= rand.nextInt(99);
		while(year<19) {
			year=rand.nextInt(99);
		}
//		StringBuilder yearr = new StringBuilder();
//		yearr.append(year);
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys(datee+"/"+year);
//		driver.close();
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_InsertButton\"]")).click();

		// driver.close();
	}

}
