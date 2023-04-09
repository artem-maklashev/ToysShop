package presenter;

import model.Shop;
import view.View;

public class Presenter {
    View view;
    Shop shop;
    Presenter(View view, Shop shop) {
        this.view = view;
        this.shop = shop;
    }
}
