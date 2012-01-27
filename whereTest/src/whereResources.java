import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * General functions Class
 * There also could be more subclasses to expose in different ways the tests methods but I'll try
 * to keep it until this point right now.
 */


public class whereResources {
	static WebDriver driver = new FirefoxDriver();
	public static int defaultTimeout = 10;
	
	// We could put this all the ID's and Strings in a properties file
	// Element id's
	public static String baseurl = "http://iokapi.com/b/where";	
	public static String newAd = "newAd";
	public static String closeAd = "closeAd";
	public static String ad = "ad";
	
	// Same here, we can move everything somewhere else for maintainability
	// Strings
	public static String bannerText = "Banner click here!";
	public static String link1 = "Link #1";
	
	/*
	 * Set default timeout in seconds
	 */
	public static void myDefaultTimeout() {
		driver.manage().timeouts().implicitlyWait(defaultTimeout, TimeUnit.SECONDS);
	}
	
	/*
	 * printCurrentURL
	 */
	public static void printCurrentURL(){
		System.out.println(driver.getCurrentUrl());
	}

	/*
	 * Click on URL based on a text
	 */
	public static void clickOnLink(String linkText) {
		driver.findElement(By.linkText(linkText)).click();	
	}
	
	/*
	 * Verify URL
	 */
	public static void verifyURL(){
		boolean match = driver.getCurrentUrl() == baseurl ? true : false;
		try {
			assertTrue(match);
			System.out.println("\nThe current URL is: " + baseurl);
		} catch (Exception e) {
			System.out.println("\nThe current URL is different to the expected one. " +
					"\nCurrent: " + driver.getCurrentUrl() + "" +
					"\nExpected: "+ baseurl);
		}
	}
	
	/*
	 * Click on Add
	 */
	public static void clickOnAd() {
		try {
			clickOnLink(bannerText);			
		} catch (Exception e) {
			System.out.println("\nThere was a problem to click on the Ad, the element is not present: " + e.getMessage());
		}
	}
	
	/*
	 * Click close Ad button
	 */
	public static void closeAdButton(){
		try {
			driver.findElement(By.id(closeAd)).click();
		} catch (Exception e) {
			System.out.println("\nThere was a problem to close the Ad, the element is not present: " + e.getMessage());
		}
	}
	
	/*
	 * New Ad
	 */
	public static void newAd(){
		if (driver.findElement(By.id(newAd)).isDisplayed()){
			driver.findElement(By.id(newAd)).click();
			// waiting for a valid Ad
			while(true){
				if(driver.findElement(By.id(ad)).isDisplayed()){
					clickOnLink("Banner click here!");
					printCurrentURL();
					break;
				} else {
					driver.findElement(By.id(newAd)).click();
				}
			}
		} else {
			System.out.println("Element " + newAd + " not present.");
		}
	}
	
	/*
	 * clickInternalAddLink
	 */
	public static void clickInternalAddLink(){
		try {
			clickOnLink(link1);			
		} catch (Exception e) {
			System.out.println("\nThere was a problem to click on the Ad, the element is not present: " + e.getMessage());
		}
	}
	
	/*
	 * findEvent(String )
	 * http://iokapi.com/b/where/internal.php?uid=1287976026&campaign=bestbuy&event=3
	 */
	public static void findEvent(){
		// If we are testing a servlet we can use the reques.getParameter("event") method to know the value of each parameter
		// For this I've already started with PHP, this method is not available, so we could write our own parse method, 
		// Below there is a method that returns Hash map with the parameter name as key and the parameter value as a value
		// we could use it in case we are not using a servlet
		
	}
	
	
	public static HashMap<String,String[]> parseUrlParameters(String s){
		if (s == null) return new HashMap<String, String[]>(0);
		   // In map1 we use strings and ArrayLists to collect the parameter values.
		   HashMap<String, Object> map1 = new HashMap<String, Object>();
		   int p = 0;
		   while (p < s.length()) {
		      int p0 = p;
		      while (p < s.length() && s.charAt(p) != '=' && s.charAt(p) != '&') p++;
		      String name = urlDecode(s.substring(p0, p));
		      if (p < s.length() && s.charAt(p) == '=') p++;
		      p0 = p;
		      while (p < s.length() && s.charAt(p) != '&') p++;
		      String value = urlDecode(s.substring(p0, p));
		      if (p < s.length() && s.charAt(p) == '&') p++;
		      Object x = map1.get(name);
		      if (x == null) {
		         // The first value of each name is added directly as a string to the map.
		         map1.put (name, value); }
		       else if (x instanceof String) {
		         // For multiple values, we use an ArrayList.
		         ArrayList<String> a = new ArrayList<String>();
		         a.add ((String)x);
		         a.add (value);
		         map1.put (name, a); }
		       else {
		         @SuppressWarnings("unchecked")
		            ArrayList<String> a = (ArrayList<String>)x;
		         a.add (value); }}
		   // Copy map1 to map2. Map2 uses string arrays to store the parameter values.
		   HashMap<String, String[]> map2 = new HashMap<String, String[]>(map1.size());
		   for (Map.Entry<String, Object> e : map1.entrySet()) {
		      String name = e.getKey();
		      Object x = e.getValue();
		      String[] v;
		      if (x instanceof String) {
		         v = new String[]{(String)x}; }
		       else {
		         @SuppressWarnings("unchecked")
		            ArrayList<String> a = (ArrayList<String>)x;
		         v = new String[a.size()];
		         v = a.toArray(v); }
		      map2.put (name, v); }
		   return map2; 
   }

	private static String urlDecode (String s) {
	   try {
	      return URLDecoder.decode(s, "UTF-8"); }
	    catch (UnsupportedEncodingException e) {
	      throw new RuntimeException("Error in urlDecode.", e); }
	}
	
}
