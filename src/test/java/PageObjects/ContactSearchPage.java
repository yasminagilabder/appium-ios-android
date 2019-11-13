package PageObjects;

public interface ContactSearchPage {

    void search(String name);

    void assertSearchResult(String expectedResult);

    void navigateToSearchResultDetails();
}
