package selenium.testcases;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import selenium.SeleniumTestWrapper;
import selenium.pageobjects.HeaderPage;
import selenium.pageobjects.SearchResultPage;
import selenium.pageobjects.SignInPage;
import selenium.pageobjects.StartPage;
import selenium.utils.annotations.browser.BrowserDimension;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static selenium.utils.browser.Screen.XLARGE;

@BrowserDimension(XLARGE)
public class UnauthenticatedTest extends SeleniumTestWrapper {

	StartPage startPage = PageFactory.initElements(getDriver(), StartPage.class);
	HeaderPage header = PageFactory.initElements(getDriver(), HeaderPage.class);
	SignInPage signInPage = PageFactory.initElements(getDriver(),SignInPage.class);
	SearchResultPage searchResultPage = PageFactory.initElements(getDriver(), SearchResultPage.class);

	@Before
	public void setup() {
		startPage.open();
	}

	@Test
	public void testForUserSearch() {

		header.searchFor(header.getSearchString());

		// check for correct search value
		assertThat(header.getSearchString()).contains(searchResultPage.getInputValue());

		searchResultPage.clickNaviElement("Users");

		// check account name is in hit list
		assertThat(searchResultPage.getAccountNames()).contains(header.getSearchString()) ;

	}

	@Test
	public void signInWithInvalidCredentialsTest(){
		header.gotoSignInPage();
		signInPage.submitLoginCredentials("bla","bla");
		assertThat(signInPage.getErrorMessage()).contains("Incorrect username or password.");
	}

}
