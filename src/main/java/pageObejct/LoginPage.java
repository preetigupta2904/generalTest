package pageObejct;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
  WebDriver driver;
	
	@FindBy(name="email")
    public  WebElement email;
	
	@FindBy(id="ap_password")
    public  WebElement userpassword;
	
	@FindBy(id="signInSubmit")
    public  WebElement signInBtn;
	
	@FindBy(id="continue")
    public  WebElement continueBtn;
	
	@FindBy(id="nav-link-accountList")
	public WebElement signIn;

	@FindBy(id="nav-link-accountList-nav-line-1")
	public WebElement loginText;
	
	public LoginPage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

public void signIn(String username, String password) {
	signIn.click();
	email.clear();
	email.sendKeys(username);
	continueBtn.click();
	userpassword.clear();
	userpassword.sendKeys(password);
	signInBtn.click();
}
}