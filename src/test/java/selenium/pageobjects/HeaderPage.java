package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import selenium.Pages;

public class HeaderPage extends Pages {

	public HeaderPage(final WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "input.header-search-input")
	WebElement searchInput;

	@FindBy(css = "octicon octicon-mark-github")
	WebElement octocatHome;

	@FindBy(linkText = "Sign in")
	WebElement signIn;

	@FindBy(linkText = "Sign up")
	WebElement signUp;

	@FindBy(linkText = "Features")
	WebElement features;


	@FindBy(linkText = "Business")
	WebElement business;

	@FindBy(linkText = "Explore")
	WebElement explore;

	@FindBy(linkText = "Pricing")
	WebElement pricing;


	public void searchFor(String searchString){
		searchInput.sendKeys(searchString);
		searchInput.submit();
	}

	public String getSearchString(){
		return getTestData("search.string");
	}

	public void gotoSignInPage(){
		signIn.click();
	}

	public void gotoSignUpPage() {
		signUp.click();
	}

	public void gotoFeaturesPage() {
		features.click();
	}
	public void gotoPricingPage() {
		pricing.click();
	}
	public void gotoExplorePage() {
		explore.click();
	}

	public void gotoBusinessPage() {
		business.click();
	}
}
