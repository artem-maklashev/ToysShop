package model;

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

    public Set<Toy> getPrizeSet(int quantity) {
        Set<Toy> toySet = new HashSet<>();
        for (int i = 0; i < quantity; i++) {

            Toy prizeToy = getPrizeToy();
            if (prizeToy != null) {
                toySet.add(prizeToy);
            }
        }
        return toySet;
    }

    public List<Toy> getToys() {
        return new ArrayList<>(this.toyMap.values());
    }
}
