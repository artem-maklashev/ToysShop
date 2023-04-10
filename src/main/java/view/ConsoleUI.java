package view;

import model.Toy;
import view.menu.Menu;
import presenter.Presenter;
import view.menu.menuItems.*;

import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private boolean isRun = true;

    private Scanner s;

    public ConsoleUI(){
        s = new Scanner(System.in);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showToys() {
        var toys = this.presenter.getToys();
        message(toys);
    }

    @Override
    public void addToy() {
        String name = scan("Введите наименование игрушки: ");
        message("Введите вес игрушки для розыгрыша:");
        float weight;
        if (s.hasNextFloat()) {
            weight = s.nextFloat();
        } else {
            message("Введено не число. Попробуйте еще раз");
            return;
        }
        this.presenter.addToy(name, weight);
        s.skip(".*\n");
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
            menu.printMenu();
            int selection = Integer.parseInt(scan("Выберите пункт меню: "));
            menu.getItem(selection).run();
        }
    }

    @Override
    public void exit() {
        this.isRun = false;
    }

    @Override
    public void message(String str) {
        System.out.println(str);
    }

    @Override
    public void takePrizeToys() {

    }

    public String scan(String message){
        message(message);
//        s.skip(".*\n");
        return s.nextLine();
    }


}
