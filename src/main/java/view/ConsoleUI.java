package view;

import view.menu.Menu;
import presenter.Presenter;
import view.menu.menuItems.*;

public class ConsoleUI implements View{
    private Presenter presenter;
    private boolean isRun = true;

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showToys() {

    }

    @Override
    public void addToy() {

    }

    @Override
    public void removeToy() {

    }

    @Override
    public void changeWeight() {

    }

    @Override
    public void start() {
        Menu menu = new Menu(this);
        menu.addItem(new ShowToys(this));
        menu.addItem(new AddToy(this));
        menu.addItem(new ChangeWeight(this));
        menu.addItem((new RemoveToy(this)));
        menu.addItem(new Exit(this));
        while (isRun){
            System.out.println("Выберите пункт меню:");
        }
    }

    @Override
    public void exit() {

    }

    @Override
    public void message(String str) {
        System.out.println(str);
    }
}
