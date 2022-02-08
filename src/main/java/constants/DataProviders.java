package constants;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="SearchData")
	public Object[] searchData() {
		return new Object[] {"Masks"};
	}
	
	@DataProvider(name="SortData")
	public Object[][] sortData() {
		return new Object[][] {{"Featured"},{"Price: Low to High"},{"Price: High to Low"},{"Avg. Customer Review"},{"Newest Arrivals"}};
	}
}
