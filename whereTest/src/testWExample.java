import java.io.IOException;

import org.junit.Test;


public class testWExample extends whereResources {

	/*
	 * Tests
	 * 1. Verify page URL
	 * 2. Load a new Ad
	 * 3. Click on the Ad and Verify Landing Page
	 *   3.1 Verify Event
	 * 4. Close the Ad
	 * 5. Click a Link on the Ad and Verify Landing Page 2
	 *   5.1 Verify Event
	 * 6. Back to the Home Page
	 */
	
	// 1. Verify page URL
	@Test
	public void verifyHomePageURL(String url) throws IOException{	
		try {
			verifyURL();
			System.out.println("\nThe current URL is: " + url);
		} catch (Exception e) {
			System.out.println("\nThe current URL is different to the expected one. " +
					"\nCurrent: " + driver.getCurrentUrl() + "" +
					"\nExpected: "+ url);
		}
	}
	
	// 2. Load new Ad
	// <newAd button>|<ad element>
	@Test
	public void loadNewAd() throws IOException{
		try {
			newAd();
		} catch (Exception e) {
			System.out.println("\nThere were problems generating a New Ad. " + e.getMessage());
		}
	}
	
	// 3. Click on the Ad and verify landing page
	@Test 
	public void clickAdd() throws IOException{		
		try {
			clickOnAd();
			System.out.println("\nClicked on Ad link");
		} catch (Exception e) {
			System.out.println("There were problems Clicking on the Ad. " + e.getMessage());
		}
	}
	
	// 3.1 Verify Event = 2
	@Test
	public void verifyEvent(){
		// explained in whereResource.java
	}
	
	// 4. Close the Ad
	@Test
	public void closeAd() throws IOException{
		try {
			closeAdButton();
			System.out.println("\nClose Ad button pressed.");
		} catch (Exception e) {
			System.out.println("\nThere were problems closing the ad. " + e.getMessage());
		}
	}
	
	// 5. Click a Link on the Ad and Verify Landing Page 2
	@Test
	public void clickAdLandPage() throws IOException{
		try {
			clickInternalAddLink();
			System.out.println("\nClicked on: " + link1);
		} catch (Exception e) {
			System.out.println("\nThere were problems clicking ont the Ad. " + e.getMessage());
		}
	}
	
	// 5.1 Verify Event = 3
	@Test
	public void verifyEvent2(){
		
	}
	
	// 6. Back to the home page
	@Test
	public void backToHome() throws IOException{
		try {
			driver.get(baseurl);
			System.out.println("\nGetting back to the home page.");
		} catch (Exception e) {
			System.out.println("\nThere was an error to get back to the home page. " + e.getMessage());
		}
	}
}
