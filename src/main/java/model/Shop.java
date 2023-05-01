package model;

import model.data.DataIO;
import java.io.IOException;
import java.util.*;

public class Shop {

    private Map<Integer, Toy> toyMap;

    public Shop() {
        this.toyMap = new HashMap<Integer, Toy>();
    }
    public Map<Integer, Toy> getToyMap() {
        return toyMap;
    }

    public void addToy(String name, int weight) {
        Toy.setIdCounter(this.getMaxId()+1);
        Toy toy = new Toy(name, weight);
        this.toyMap.put(toy.getId(), toy);
    }

    public void removeToy(int index) {
        this.toyMap.remove(index);
    }

    public void changeWeight(int index, int newWeight) {
        if (toyMap.containsKey(index)) {
            Toy t = toyMap.get(index);
            t.setWeight(newWeight);
        }
    }

    public int getMaxId(){
        return toyMap.values().stream().mapToInt(Toy::getId).max().orElse(0);
    }

  public Toy getPrizeToy() {
    int totalWeight = toyMap.values().stream().mapToInt(Toy::getWeight).sum();
    if (totalWeight <= 0) {
        return null;
    }
    Random random = new Random();
    int randomNumber = random.nextInt(totalWeight);

    double currentWeight = 0;
      PriorityQueue<Toy> toyQueue = new PriorityQueue<Toy>();
    toyQueue.addAll(toyMap.values());

    for (Toy toy : toyQueue) {
        currentWeight += toy.getWeight();
        if (randomNumber < currentWeight) {
            return toy;
        }
    }
    return null;
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
        return dataIO.loadData();
    }

    public void saveShop(DataIO dataIO) throws IOException {
        dataIO.saveData(this);
    }

    public int getSize() {
        return toyMap.size();
    }
}
