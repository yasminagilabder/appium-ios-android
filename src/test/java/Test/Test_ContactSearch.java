package Test;

import org.junit.Test;

public class Test_ContactSearch extends BaseTestClass {

    @Test
    public void searchContact() {
        //Search for contact
        searchPage.search("Sara");

        //Verify result
        searchPage.assertSearchResult("Sara Alston");

        //Navigate to detail page
        searchPage.navigateToSearchResultDetails();

        //Verify that correct page is displayed
        detailPage.assertContactName("Sara Alston");
    }
}
