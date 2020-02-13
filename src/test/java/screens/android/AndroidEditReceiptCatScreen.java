package screens.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import screens.interfaces.EditReceiptCategoryScreen;
import util.category.Category;

import static org.hamcrest.MatcherAssert.assertThat;

public class AndroidEditReceiptCatScreen extends AndroidUpdateReceiptScreen  implements EditReceiptCategoryScreen {
	
	public String categoryTitle = "com.lunchit.android.beta:id/categoryTitle";
	public String categoryImage = "com.lunchit.android.beta:id/categoryImage";
	
	public AndroidEditReceiptCatScreen(AndroidDriver driver) {
		super(driver);
	}
	
	@Override
	public void checkCategoryScreen(Category category) {
		switch (category) {
			case CATEGORY1:
				assertThat("Category title is not present", isElementPresent(By.id(categoryTitle)));
				break;
			case CATEGORY2:
				assertThat("Category image is not present", isElementPresent(By.id(categoryImage)));
				break;
		}
		
	}
}
