package screens.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import screens.common.BaseScreen;
import screens.interfaces.CategoryScreen;
import util.category.Category;

import static org.hamcrest.MatcherAssert.assertThat;

public class AndroidCategoryScreen extends BaseScreen implements CategoryScreen {
	
	private String mainTitle = "com.lunchit.android.beta:id/toolbar_title";
	private String category1 = "com.lunchit.android.beta:id/categoryOneImage";
	private String category2 = "com.lunchit.android.beta:id/imageTwoContainer";
	
	
	public AndroidCategoryScreen(AppiumDriver driver) {
		super(driver);
	}
	
	@Override
	public void checkScreenFormat() {
		sleep(5000);
		assertThat(" Main Title is not present", isElementPresent(By.id(mainTitle)));
		assertThat("Category 1 image is not present", isElementPresent(By.id(category1)));
		assertThat("Category 2 image is not present", isElementPresent(By.id(category2)));
	}
	
	@Override
	public void submit(Category category) {
		switch (category) {
			case CATEGORY1:
				waitAndClick(By.id(category1));
				System.out.println("Clicking Category 1 (Supermarket)....");
				break;
			case CATEGORY2:
				waitAndClick(By.id(category2));
				System.out.println("Clicking Category 2 (Restaurant)....");
				break;
		}
	}
}

