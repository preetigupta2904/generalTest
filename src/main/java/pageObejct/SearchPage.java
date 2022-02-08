package pageObejct;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;
	
	@FindBy(name="field-keywords")
    public  WebElement search;
	
	@FindBy(css="span.a-size-medium.a-color-base")
	public WebElement noResultText;
	
	@FindBy(className="s-suggestion-container")
	public List<WebElement> searchList;
	
	@FindBy(className="a-dropdown-prompt")
	public WebElement sortSearch;
	
	@FindBy(className="a-dropdown-item")
	public List<WebElement> sortList;
	
	@FindBy(css="span.a-color-state.a-text-bold")
    public  WebElement searchCriteria;
	
	@FindBy(css="a.s-pagination-item.s-pagination-next.s-pagination-button.s-pagination-separator")
    public  WebElement nextPage;
	
	@FindBy(id="rhf")
    public  WebElement relatedSection;
	
	@FindBy(className="a-size-base-plus")
    public  WebElement searchItem;
	
	
	public SearchPage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }
	
	public void searchText(String text) {
		search.sendKeys(text);
		
	}
	
	public void searchList() {
		
	}
	
	public void searchNextPage() {
		nextPage.click();
	}
	
	public void productRelatedSection() {
		
		
	}
	
	public void noResultText() {
		
	}
}
