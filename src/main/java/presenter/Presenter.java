package presenter;

import model.Shop;
import model.Toy;
import view.View;
import view.menu.menuItems.ShowToys;

import java.util.List;

public class Presenter {
    View view;
    Shop shop;
    public Presenter(View view, Shop shop) {
        this.view = view;
        this.shop = shop;
    }


    public void addToy(String name, float weight) {
        Toy toy = new Toy(name, weight);
        this.shop.addToy(toy);
    }

    public String getToys() {
        var toys =  this.shop.getToys();
        StringBuilder sb = new StringBuilder();
        for (Toy toy: toys
             ) {
            String item = String.format("%5d %30s %5.3f", toy.getId(), toy.getName(), toy.getWeight());
            sb.append(item);
            sb.append("\n");
        }
        return sb.toString();
    }
}
