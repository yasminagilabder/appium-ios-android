package Test;

import AppiumSupport.AppiumBaseClass;
import AppiumSupport.AppiumController;
import PageObjects.*;
import org.junit.After;
import org.junit.Before;

public class BaseTestClassLunchit extends AppiumBaseClass {
	/*ContactSearchPage searchPage;
	ContactDetailPage detailPage;*/
	
	@Before
	public void setUp() throws Exception {
		AppiumController.instance.start();
		switch (AppiumController.executionOS) {
			case ANDROID:
				/*searchPage = new ContactSearchPageAndroid(driver());
				detailPage = new ContactDetailPageAndroid(driver());*/
				break;
			case IOS:
			/*	searchPage = new ContactSearchPageIOS(driver());
				detailPage = new ContactDetailPageIOS(driver());*/
				break;
		}
	}
	
	@After
	public void tearDown() {
		AppiumController.instance.stop();
	}
}
