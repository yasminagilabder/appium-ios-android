package screens.interfaces;

public interface DetailView {
	void checkScreenFormat(String name, String lastName);
	void edit();
	void delete();
	void back();
	void checkModalScreen();
	void confirmModalScreen(Boolean confirm);
}
