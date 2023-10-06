package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class Test1 {
	@Test(priority=1)
	public void login(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Fxbytes\\eclipse-workspace\\Fxbytes\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://events.legalops.com");
		driver.findElement(By.xpath("//input[@name='user_email']")).sendKeys("userName");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("password");
	}
	@Test(priority=2, enabled=false)
	public void users(){
		Faker faker = new Faker();
		for(int i=1; i<=10; i++) {
			String fakeName = faker.name().fullName();
			String fakeEmail = faker.internet().emailAddress();
			String fakeAddress = faker.address().fullAddress();
			System.out.println(i +"] ---(Name)---> "+ fakeName+"  ---(Emails)--->  "+fakeEmail+"  ---(Address)--->  "+ fakeAddress);	
		}
	}
	@Test(priority=3, enabled=false)
	public void emailsTypes()
	{
		 // Initialize the Faker generator
        Faker faker = new Faker();

        // Generic Email Addresses
        String genericEmail = faker.internet().emailAddress();
        System.out.println("Generic Email: " + genericEmail);

        // Anonymous or Placeholder Emails
        String anonymousEmail = "anonymous_" + faker.number().randomNumber(3, true) + "@example.com";
        System.out.println("Anonymous Email: " + anonymousEmail);

        // Random Usernames
        String randomUsernameEmail = faker.name().username() + "@yahoo.com";
        System.out.println("Random Username Email: " + randomUsernameEmail);

        // Domain-Specific Emails
        String domainSpecificEmail = "user" + faker.number().randomNumber(3, true) + "@companyxyz.com";
        System.out.println("Domain-Specific Email: " + domainSpecificEmail);
	}
}
