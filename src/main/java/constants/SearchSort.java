package constants;

public enum SearchSort {
	FEATURED("Featured"),
	PRICELH("Price: Low to High"),
	PRICEHL("Price: High to Low"),
	CUSTOMERREVIEW("Avg. Customer Review"),
	NEWARRIVAL("Newest Arrivals");
	
	public final String sort;
	
	SearchSort(String sort) {
		this.sort = sort;
		
	}

	public String sortOption() {
	    return this.sort;
	}
}
