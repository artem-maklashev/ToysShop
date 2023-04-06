package model;

import java.util.Set;
import java.util.TreeSet;

public class Shop {

    private Set<Toy> toys;

    public Shop(Set<Toy> toys) {
        this.toys = new TreeSet<Toy>();
    }

    public void addToy(Toy toy){
        this.toys.add(toy);
    }

    public void removeToy(int index){
        this.toys.removeIf(toy -> toy.getId()== index);
    }
}
