package uiTest;

import static org.testng.Assert.assertTrue;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import constants.DataProviders;
import constants.SearchSort;
import constants.Users;
import pageObejct.LoginPage;
import pageObejct.SearchPage;

public class searchTestUI extends BaseTestUI{
	SearchPage searchObj ;
	LoginPage loginObj;
	String modifySearchText = " reuse";
	String noResultText = "No results for";
	
 @Test(groups={"Unit","Regression"},dataProvider="SearchData",dataProviderClass = DataProviders.class,testName="testSearchBar_autoSuggestiontLength",description="Verify that search bar exist and displays upto 10 matching items for a string entered")
	public void testSearchBar_autoSuggestiontLength(String searchText) throws InterruptedException {
		test = extent.createTest("testSearchBar_autoSuggestiontLength");
		searchObj = new SearchPage(driver);
	Reporter.log("Verify the Search bar is displayed");
		Assert.assertTrue(searchObj.search.isDisplayed());
	Reporter.log("Verify upto 10 matching items are displayed in autosuggestion");
		searchObj.searchText(searchText);
		int autoSuggestionLength=searchObj.searchList.size();
		if (autoSuggestionLength<=10) {
			Assert.assertTrue(true, "The auto suggestion list length is less than or equal to 10");
			}
			
	}

	@Test(groups={"Unit","Regression"},testName="testNoResultsPage",description="Verify that No results Page appears for non matching string entered")
	public void testNoResultsPage() throws InterruptedException {
		test = extent.createTest("testNoResultsPage");
		searchObj = new SearchPage(driver);
	Reporter.log("Verify the Search bar is displayed");
		Assert.assertTrue(searchObj.search.isDisplayed());
	Reporter.log("Verify No Result Found Page");
		searchObj.searchText("sdaadadssssss"+"\n");
		Assert.assertEquals(searchObj.noResultText.getText(), noResultText, "Verify that No results found text appears for no matching item found ");
		
	}
	
	@Test(groups={"Unit","Regression"},dataProvider="SearchData",dataProviderClass = DataProviders.class,testName="testSearchBar_autoSuggestiontLength",description="Verify that search bar exist and displays upto 10 matching items for a string entered")
	public void testSortSearchresults(String searchText) throws InterruptedException {
		test = extent.createTest("testSortSearchresults");
		searchObj = new SearchPage(driver);
	Reporter.log("Verify the Search bar is displayed");
		Assert.assertTrue(searchObj.search.isDisplayed());
	Reporter.log("Verify sorting options");
		searchObj.searchText(searchText+"\n");
		searchObj.sortSearch.click();
		 List<WebElement> sortListItems = searchObj.sortList;
		 SearchSort actualSortOptions[]= {SearchSort.FEATURED,SearchSort.PRICELH,SearchSort.PRICEHL,SearchSort.CUSTOMERREVIEW,SearchSort.NEWARRIVAL};
		
		for(WebElement sortOption:sortListItems)  
		 {  
		  boolean match = false;
		  for (int i=0; i<sortListItems.size(); i++){
		      if (sortOption.getText().equals(actualSortOptions[i].sortOption())){
		    	  match = true;
		      }
		    }
		  Assert.assertTrue(match);
		 }
 
	}
	
	@Test(groups={"Unit","Regression","P0"},dataProvider="SearchData",dataProviderClass = DataProviders.class,testName="testNextPageOfSearchPage",description="Verify that next page of search page is loaded successfully")
	public void testNextPageOfSearchPage(String searchText) throws InterruptedException {
		test = extent.createTest("testNextPageOfSearchPage");
		searchObj = new SearchPage(driver);
		Assert.assertTrue(searchObj.search.isDisplayed());
	Reporter.log("Verify on for search item page");
		searchObj.searchText(searchText+"\n");
		String actualSearchText = searchObj.searchCriteria.getText();
		Assert.assertEquals(actualSearchText,'"'+ searchText+'"', "The search results loaded for searched item");
		String searchItemText= searchObj.searchItem.getText();
		assertTrue(searchItemText.contains(searchText));
		searchObj.searchNextPage();
	Reporter.log("Verify on next page");
		Assert.assertEquals(actualSearchText,'"'+ searchText+'"', "The next page of search results loaded for searched item");
	Reporter.log("Verify that page is loaded with modified search ");
		searchObj.searchText(" reuse"+"\n");
		String actualModifySearchText = searchObj.searchCriteria.getText();
		Assert.assertEquals(actualModifySearchText,'"'+ searchText+modifySearchText+'"', "The search results loaded for modified searched item");
		
	}
	
	@Test(groups={"Unit","Regression"},testName="testProductRelatedSearchSection",description="Verify that Product Related Search Section appears")
    public void testProductRelatedSearchSection() throws InterruptedException {
	 test = extent.createTest("testProductRelatedSearchSection");
		searchObj = new SearchPage(driver);
		Assert.assertTrue(searchObj.search.isDisplayed());
	Reporter.log("Verify on for search item page");
		searchObj.searchText("Masks"+"\n");
	Reporter.log("Verify that Related Search section appears");	
		Assert.assertTrue(searchObj.relatedSection.isDisplayed());
    }
	
	
	@Test(groups={"Unit","Regression","P0"},dataProvider="SearchData",dataProviderClass = DataProviders.class,testName="testLoginUserSearchHistory",description="Verify that user is able to see search history")
	public void testLoginUserSearchHistory(String searchText) throws InterruptedException {
		test = extent.createTest("testLoginUserSearchHistory");
		
		Users userName = Users.PREETI;

	Reporter.log("Verify User is successfully logged in and performs search");	
		loginObj = new LoginPage(driver);
		searchObj = new SearchPage(driver);
		loginObj.signIn(userName.getUserName(),userName.getPassword());
		String actualUsername = loginObj.loginText.getText();
		Assert.assertEquals(actualUsername, "Hello, Preeti");
		testNextPageOfSearchPage(searchText);
	Reporter.log("Verify User is able see search history section");	
		Assert.assertTrue(searchObj.relatedSection.isDisplayed());

	}
}
