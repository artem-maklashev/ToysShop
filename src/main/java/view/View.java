package view;

import presenter.Presenter;

public interface View {
    void setPresenter(Presenter presenter);
    void showToys();
    void addToy();
    void removeToy();
    void changeWeight();
    void start();
    void exit();
    void message(String str);
    void playPrizes();
}
