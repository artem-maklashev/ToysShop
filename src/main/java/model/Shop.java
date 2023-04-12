package model;

import model.data.DataIO;
import model.data.JsonFormatter;

import java.io.IOException;
import java.util.*;

public class Shop {
    private Map<Integer, Toy> toyMap;

    public Shop() {
        this.toyMap = new HashMap<Integer, Toy>();
    }

    public void addToy(Toy toy) {
        this.toyMap.put(toy.getId(), toy);
    }

    public void removeToy(int index) {
        this.toyMap.remove(index);
    }

    public void changeWeight(int index, float newWeight) {
        if (toyMap.containsKey(index)) {
            Toy t = toyMap.get(index);
            t.setWeight(newWeight);
        }
    }

    public Toy getPrizeToy() {
        Random random = new Random();
        float totalWeight = 0.0f;
        Toy prizeToy = null;

        for (Toy toy : toyMap.values()) {
            float weight = toy.getWeight();
            totalWeight += weight;
            if (prizeToy == null && random.nextFloat() <= weight / totalWeight) {
                prizeToy = toy;
            }
        }
        return prizeToy;
    }

    public Queue<Toy> getPrizeSet(int quantity) {
        Queue<Toy> toeQueue = new LinkedList<>();
        for (int i = 0; i < quantity; i++) {

            Toy prizeToy = getPrizeToy();
            if (prizeToy != null) {
                toeQueue.add(prizeToy);
            }
        }
        return toeQueue;
    }

    public List<Toy> getToys() {
        return new ArrayList<>(this.toyMap.values());
    }

    public Shop loadShop(DataIO dataIO){
        String data = dataIO.loadData();
        JsonFormatter formatter = new JsonFormatter();
        return formatter.parseIn(data);
    }

    public void saveShop(DataIO dataIO) throws IOException {
        JsonFormatter formatter = new JsonFormatter();
        dataIO.saveData(formatter.parseOut(this));
    }
}
