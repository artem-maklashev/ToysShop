package presenter;

import model.Shop;
import model.Toy;
import model.data.DataIO;
import view.View;
import view.menu.menuItems.ShowToys;

import java.util.List;
import java.util.Set;

public class Presenter {
    View view;
    Shop shop;
    DataIO dataIO;
    public Presenter(View view, Shop shop, DataIO dataIO) {
        this.view = view;
        this.shop = shop;
        this.dataIO = dataIO;
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

    public void playPrizes(int quantity) {
        Set<Toy> prizes = this.shop.getPrizeSet(quantity);

    }
}
