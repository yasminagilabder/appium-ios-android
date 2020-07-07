/*
 * Copyright 2018 Elias Nogueira
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pageObjectModel;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;

import io.appium.java_client.pagefactory.iOSBy;
import org.openqa.selenium.By;

import screens.common.Actions;
import screens.interfaces.MainView;

import java.time.temporal.ChronoUnit;


public class MainScreenPageObject extends Actions {


	@AndroidFindBy(id = "org.traeg.fastip:id/totalAmtTextView")
	@iOSBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[4]")
	@WithTimeout(time = 10,chronoUnit = ChronoUnit.SECONDS)
    MobileElement selectUser;


	public MainScreenPageObject(AppiumDriver<?> driver) {
		super(driver);
		//PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	public void selectUser(String name, String last) {
		String completeName="\""+last+", "+name+"\"";
		click(By.id(last.trim() + ", " + name.trim()));

		click(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[@text="+completeName+"]"));
	}


}
