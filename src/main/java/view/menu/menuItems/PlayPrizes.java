package view.menu.menuItems;

import view.View;
import view.menu.MenuItem;

public class PlayPrizes extends MenuMethod {

    public PlayPrizes(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Разыграть игрушки";
    }

    @Override
    public void run() {
        getView().playPrizes();
    }
}
