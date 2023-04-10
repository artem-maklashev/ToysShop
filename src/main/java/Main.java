import model.Shop;
import presenter.Presenter;
import view.ConsoleUI;
import view.View;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        View view = new ConsoleUI();
        Presenter presenter = new Presenter(view, shop);
        view.setPresenter(presenter);
        view.start();
    }
}
