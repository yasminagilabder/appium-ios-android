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
import io.appium.java_client.pagefactory.iOSXCUITBy;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import screens.common.BaseScreen;
import screens.interfaces.MainView;

import java.time.temporal.ChronoUnit;


public class MainScreenPageObject extends BaseScreen implements MainView {

//	@AndroidFindBy(id = "org.traeg.fastip:id/billAmtEditText")
	@iOSXCUITBy(xpath = "(//XCUIElementTypeStaticText[@name=\"NameLabel\"])[4]")

	@WithTimeout(time = 10,chronoUnit = ChronoUnit.SECONDS)
    MobileElement selectUser;


	public MainScreenPageObject(AppiumDriver<?> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@Override
	public void checkScreenFormat() {

	}

	@Override
	public void selectUser(String name, String last) {

	}


}
