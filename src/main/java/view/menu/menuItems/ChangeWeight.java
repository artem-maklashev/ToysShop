package view.menu.menuItems;

import view.View;

public class ChangeWeight extends MenuMethod{
    public ChangeWeight(View view) {
        super(view);
    }

    @Override
    public String description() {
        return null;
    }

    @Override
    public void run() {
        getView().changeWeight();
    }
}
